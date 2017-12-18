package kz.gamma.certex.cms.web.services;

import kz.gamma.asn1.*;
import kz.gamma.asn1.cms.RevokeRequest;
import kz.gamma.asn1.pkcs.PKCSObjectIdentifiers;
import kz.gamma.asn1.x509.Attribute;
import kz.gamma.asn1.x509.X509Extensions;
import kz.gamma.asn1.x509.X509Name;
import kz.gamma.certex.cms.web.services.client.ClientKeyStoreProvider;
import kz.gamma.certex.cms.web.services.common.CryptoProcessor;
import kz.gamma.certex.cms.web.services.common.KeyStoreProvider;
import kz.gamma.certex.cms.web.services.common.XMLProcessor;
import kz.gamma.certex.cms.web.services.common.entities.*;
import kz.gamma.cms.*;
import kz.gamma.core.utils.EndiannessUtils;
import kz.gamma.jce.PKCS10CertificationRequest;
import kz.gamma.jce.provider.GammaTechProvider;
import kz.gamma.jce.provider.JDKKeyPairGenerator;
import kz.gamma.tumarcsp.LibraryWrapper;
import kz.gamma.tumarcsp.TumarCspFunctions;
import kz.gamma.util.encoders.Base64;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.math.BigInteger;
import java.nio.ByteOrder;
import java.security.*;
import java.security.cert.*;
import java.util.*;

public class Utils {

    private static final String X_509 = "X.509";
    private static final String GKS = "GKS";
    private static final String RSA = "RSA";
    public static final String ENCODING = "UTF-8";

    private static final String SHA_256_WITH_RSA = "SHA256withRSA";
    private static final String GAMMA = "GAMMA";
    private static final String GOST_ALG = "1.3.6.1.4.1.6801.1.5.8";
    private static final String RSA_ALG = "1.3.6.1.4.1.6801.1.5.22";

    private static final String ECGOST34310 = "ECGOST34310";
    private static final String SHA1_WITHRSA = "SHA1WITHRSA";

    private static final EndiannessUtils endiannessUtils = new EndiannessUtils();


    public static X509Certificate getX509CertificateFromFile(String path) {
        byte[] certDecode = new byte[0];
        try (BufferedInputStream fis = new BufferedInputStream(new FileInputStream(path))) {
            byte[] cerBuff = IOUtils.toByteArray(fis);
            certDecode = Base64.decode(cerBuff);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return getX509FromBytes(certDecode);
    }

    public static X509Certificate getX509FromBytes(byte[] certDecode) {
        X509Certificate CAcert = null;
        try (InputStream caIn = new ByteArrayInputStream(certDecode)) {
            CertificateFactory certFactory = CertificateFactory.getInstance(X_509);
            CAcert = (X509Certificate) certFactory.generateCertificate(caIn);
        } catch (CertificateException | IOException e) {
            e.printStackTrace();
        }
        return CAcert;
    }


    public static void addCertInProfile(RequestDetail requestDetail,
                                        String profile, String pass,
                                        String alg,
                                        String caGostCertPath, String headCaGostCertPath,
                                        String caRSACertPath, String headRSACertPath) throws Exception {


        CertificateFactory certFact = CertificateFactory.getInstance(X_509);
        InputStream in = new ByteArrayInputStream(requestDetail.getBodySigned());
        X509Certificate cert = (X509Certificate) certFact.generateCertificate(in);

        KeyStore keyStore = KeyStore.getInstance(GKS, GAMMA);
        keyStore.load(new ByteArrayInputStream(profile.getBytes()), pass.toCharArray());
        X509Certificate x509 = Utils.getX509FromBytes(requestDetail.getCertBody());
        CertificateFieldsResolver cr = new CertificateFieldsResolver();
        String serial = (String) cr.getSerialNumber(x509, CertificateFieldsResolver.HEX_STRING);
        keyStore.setCertificateEntry(serial, cert);
        in.close();

//        Для того чтобы поставить сертификат УЦ на java необходимо выполнить следующие шаги:
//        Загрузить контейнер с ключами, в который устанавливается сертификат УЦ:
        Number handleProv = TumarCspFunctions.cpAcquireContext(profile, LibraryWrapper.CRYPT_SILENT, LibraryWrapper.PV_TABLE);
//        Получить ссылку на ключ:
        Number handleKey = TumarCspFunctions.cpGetUserKey(handleProv, LibraryWrapper.AT_SIGNATURE);
//        Установить сертификат УЦ:

        X509Certificate caRSACert = null;
        X509Certificate headCARSACert = null;
        switch (alg) {
            case ECGOST34310:
                caRSACert = Utils.getX509CertificateFromFile(caGostCertPath);
                headCARSACert = Utils.getX509CertificateFromFile(headCaGostCertPath);
                break;
            case SHA_256_WITH_RSA:
                caRSACert = Utils.getX509CertificateFromFile(caRSACertPath);
                headCARSACert = Utils.getX509CertificateFromFile(headRSACertPath);
                break;
            default:
                break;
        }
        if (caRSACert == null || headCARSACert == null) {
            System.out.println("Cant load CA certificate");
            return;
        }
        TumarCspFunctions.cpSetKeyParam(handleProv, handleKey, LibraryWrapper.KP_CERTIFICATE_CA, caRSACert.getEncoded(), LibraryWrapper.ZERO);
        TumarCspFunctions.cpSetKeyParam(handleProv, handleKey, LibraryWrapper.KP_CERTIFICATE_CA, headCARSACert.getEncoded(), LibraryWrapper.ZERO);
//        Освободить контексты:
        TumarCspFunctions.cpDestroyKey(handleProv, handleKey);
        TumarCspFunctions.cpReleaseContext(handleProv, LibraryWrapper.ZERO);
    }


    public static KeyPair generateGOSTKeyPair(String profile, String pass)
            throws NoSuchProviderException, NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance(ECGOST34310, GAMMA);
        if (GammaTechProvider.algUtil.algKey.containsKey(GOST_ALG)) {
            kpg.initialize(GammaTechProvider.algUtil.algKey.get(GOST_ALG));
        }
        ((JDKKeyPairGenerator.ECGOST34310) kpg).setProfName(profile, pass);
        return kpg.generateKeyPair();
    }

    public static KeyPair generateRSAKeyPair(String profile, String pass)
            throws NoSuchProviderException, NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance(RSA, GAMMA);
        if (GammaTechProvider.algUtil.algKey.containsKey(RSA_ALG)) {
            kpg.initialize(GammaTechProvider.algUtil.algKey.get(RSA_ALG));
        }
        ((JDKKeyPairGenerator.RSA) kpg).setProfName(profile, pass);
        return kpg.generateKeyPair();

    }

    public static Attribute getAttribute() {
        Vector<Object> ordering = new Vector<>();
        Hashtable<Object, Object> extensions = new Hashtable<>();
        X509Extensions x509extensions = new X509Extensions(ordering, extensions);
        return new Attribute(PKCSObjectIdentifiers.pkcs_9_at_extensionRequest, new DERSet(x509extensions));
    }

    public static ASN1Set getASN1Template(String name, Attribute attribute) throws IOException {
        String stringCp1251 = new String(name.getBytes(), "Cp1251");
        byte[] unicode = stringCp1251.getBytes("Unicode");
        byte[] unicodeWithoutBOM = null;

        try {
            ByteOrder resultBytes = endiannessUtils.getEndianness(unicode);
            if (resultBytes.equals(ByteOrder.BIG_ENDIAN) || resultBytes.equals(ByteOrder.LITTLE_ENDIAN)) {
                unicodeWithoutBOM = new byte[unicode.length - 2];
                System.arraycopy(unicode, 2, unicodeWithoutBOM, 0, unicode.length - 2);
            }
        } catch (RuntimeException var15) {
            unicodeWithoutBOM = unicode;
        }

        assert unicodeWithoutBOM != null;
        byte[] resultBytes1 = new byte[unicodeWithoutBOM.length];
        if (unicodeWithoutBOM[0] != 0) {
            resultBytes1 = endiannessUtils.changeEndianness(unicodeWithoutBOM);
        } else {
            System.arraycopy(unicodeWithoutBOM, 0, resultBytes1, 0, unicodeWithoutBOM.length);
        }

        DERBMPString str = new DERBMPString(resultBytes1);
        BERConstructedOctetString ASNocts = new BERConstructedOctetString(str.getEncoded());
        DERBoolean ASNtrue = new DERBoolean(true);

        ASN1EncodableVector vectTemp = new ASN1EncodableVector();
        vectTemp.add(PKCSObjectIdentifiers.MS_ENROLL_CERTTYPE_EXTENSION);
        vectTemp.add(ASNtrue);
        vectTemp.add(ASNocts);
        DERSequence seqTemplate = new DERSequence(vectTemp);

        ASN1EncodableVector vecSeqTemplate = new ASN1EncodableVector();
        vecSeqTemplate.add(seqTemplate);
        DERSequence seqvecSeqTemplate = new DERSequence(vecSeqTemplate);
        DERSet setSeqTemplate = new DERSet(seqvecSeqTemplate);

        ASN1EncodableVector vect1 = new ASN1EncodableVector();
        vect1.add(PKCSObjectIdentifiers.MS_CERT_EXTENSIONS_OBJID);
        vect1.add(setSeqTemplate);

        DERSequence qz = new DERSequence(vect1);
        ASN1EncodableVector asn1EncodableVector = new ASN1EncodableVector();
        asn1EncodableVector.add(qz);
        asn1EncodableVector.add(attribute);
        return new DERSet(asn1EncodableVector);
    }

    public static byte[] signPKCS10WithDefProfile(PKCS10CertificationRequest req,
                                                  String profile, String pass, String alias) throws Exception {
        ClientKeyStoreProvider provider = new ClientKeyStoreProvider(profile, pass);
        return CryptoProcessor.sign(req.getDEREncoded(), provider.getStore(), provider.getPassword(), alias);
    }

    public static PKCS10CertificationRequest makeGOSTpkcs10Request(String dnName, KeyPair keyPair, String template)
            throws NoSuchAlgorithmException, NoSuchProviderException,
            InvalidKeyException, SignatureException, IOException {
        Attribute attribute = getAttribute();
        return new PKCS10CertificationRequest(ECGOST34310,
                new X509Name(dnName), keyPair.getPublic(),
                getASN1Template(template, attribute), keyPair.getPrivate());
    }

    public static PKCS10CertificationRequest makeRSApkcs10Request(String dnName, KeyPair keyPair, String template)
            throws NoSuchAlgorithmException, NoSuchProviderException,
            InvalidKeyException, SignatureException, IOException {
        Attribute attribute = getAttribute();

        return new PKCS10CertificationRequest(SHA1_WITHRSA,
                new X509Name(dnName), keyPair.getPublic(), getASN1Template(template, attribute), keyPair.getPrivate());
    }

    public static byte[] getSignedRevokeRequest(RevokeRequest req, PrivateKey key, X509Certificate cert)
            throws NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, CertStoreException, CMSException, IOException {
        CMSSignedData signedData;
        if (cert == null) {
            throw new NullPointerException("Certificate cannot be null");
        } else {
            CMSSignedDataGenerator gen = new CMSSignedDataGenerator();
            if (cert.getSigAlgName().equals(ECGOST34310)) {
                gen.addSigner(key, cert, CMSSignedDataGenerator.DIGEST_GOST3411G);
            } else {
                if (!cert.getSigAlgName().equals(SHA_256_WITH_RSA)) {
                    throw new RuntimeException("Bad signature algorithm name: \"" + cert.getSigAlgName() + "\"");
                }

                gen.addSigner(key, cert, CMSSignedDataGenerator.DIGEST_SHA1);
            }

            ArrayList<X509Certificate> list = new ArrayList<>();
            list.add(cert);
            CertStore store = CertStore.getInstance("Collection", new CollectionCertStoreParameters(list), GammaTechProvider.PROVIDER_NAME);
            gen.addCertificatesAndCRLs(store);
            CMSProcessableByteArray content = new CMSProcessableByteArray(req.getTBSRequest());
            signedData = gen.generate("1.3.6.1.5.5.7.12.2", content, true, GammaTechProvider.PROVIDER_NAME);
            return signedData.getEncoded();
        }
    }

    public static RequestPkiService createPkiRequest(String type, String system) {
        RequestPkiService pkiRequest = new RequestPkiService();
        pkiRequest.setRequestDate(dateTimeToGregorianCalendar(new Date()).normalize());
        pkiRequest.setSeance(BigInteger.valueOf(new Date().getTime()));
        pkiRequest.setSystem(system);
        pkiRequest.setService(type);
        pkiRequest.setEncoding(ENCODING);
        return pkiRequest;
    }

    public static XMLGregorianCalendar dateTimeToGregorianCalendar(Date date) {
        if (date == null)
            return null;

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] objectToPkcs7(Object obj, String profile, String pass) throws Exception {
        final ClientKeyStoreProvider ksp = new ClientKeyStoreProvider(profile, pass);

        String objStr;
        objStr = XMLProcessor.marshal(obj);
        byte[] pkcs7;
        try {
            pkcs7 = CryptoProcessor.sign(objStr.getBytes(ENCODING), ksp.getStore(), ksp.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Ошибка при подписывании объекта " + obj, e);
        }

        return pkcs7;
    }

    public static Object pkcs7ToObject(byte[] pkcs7, File xsd) throws Exception {

        Pkcs7Data signedCapicomData = CryptoProcessor.getPkcs7Object(pkcs7);
        if (!signedCapicomData.verify())
            throw new Exception("Подпись контейнера не прошла проверку");

        try {
            return XMLProcessor.unmarshal(signedCapicomData.getData(), true, ENCODING, xsd);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new Exception("Ошибка при демаршилизации объекта " + Arrays.toString(pkcs7), e);
        }

    }

    public static String prettyPrint(Document document)
            throws TransformerException {
        TransformerFactory transformerFactory =
                TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        DOMSource source = new DOMSource(document);
        StringWriter strWriter = new StringWriter();
        StreamResult result = new StreamResult(strWriter);

        transformer.transform(source, result);

        return strWriter.getBuffer().toString();

    }

    public static Document toXmlDocument(String str)
            throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

        return docBuilder.parse(new InputSource(new StringReader(
                str)));
    }

    public static PkiDocument createPkiDocument(String method, String filePath, String xsdFilePath)
            throws IOException, SAXException {
        PkiDocument result;
        switch (method) {
            case "getCityList":
                result = new DocCityListIn();
                break;
            case "getCountryList":
                result = new DocCountryListIn();
                break;
            case "getIssuerList":
                result = new DocIssuerListIn();
                break;
            case "getRoleList":
                result = new DocGetRolesIn();
                break;
            case "getPositionList":
                result = new DocPositionListIn();
                break;
            case "getRegionList":
                result = new DocRegionListIn();
                break;
            case "getPersonList":
                result = new DocGetPersonListIn();
                break;
            case "getTariffList":
                result = new DocTariffListIn();
                break;
            case "getTumar":
                result = new DocGetTumarIn();
                break;
            case "getOrganization":
                result = new DocGetOrganizationIn();
                break;
            default:
                byte[] bytes = IOUtils.toByteArray(new FileInputStream(filePath));
                result =(PkiDocument) XMLProcessor.unmarshal(bytes, true, ENCODING, new File(xsdFilePath));
                break;
        }

        return result;
    }
}
