package kz.gamma.certex.cms.web.services;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import kz.gamma.asn1.*;
import kz.gamma.asn1.pkcs.PKCSObjectIdentifiers;
import kz.gamma.asn1.x509.Attribute;
import kz.gamma.asn1.x509.X509Extensions;
import kz.gamma.asn1.x509.X509Name;
import kz.gamma.certex.cms.web.services.client.ClientKeyStoreProvider;
import kz.gamma.certex.cms.web.services.common.CryptoProcessor;
import kz.gamma.core.utils.EndiannessUtils;
import kz.gamma.jce.PKCS10CertificationRequest;
import kz.gamma.jce.provider.GammaTechProvider;
import kz.gamma.jce.provider.JDKKeyPairGenerator;
import kz.gamma.util.encoders.Base64;
import org.junit.Assert;

import java.io.IOException;
import java.nio.ByteOrder;
import java.security.*;
import java.util.Hashtable;
import java.util.Vector;

public class PrepareCertRequestXml {

    private static final String ECGOST34310 = "ECGOST34310";
    private static final String GAMMA = "GAMMA";
    private static final String GOST_ALG = "1.3.6.1.4.1.6801.1.5.8";

    private static final EndiannessUtils endiannessUtils = new EndiannessUtils();

    private static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<docRequestCertIn xmlns=\"http://www.gamma.kz/webra/xsd\"><request>\n" +
            "\t<DN>%dn%</DN>\n" +
            "\t<tariffId>%tariffId%</tariffId>\n" +
            "\t<status>novel</status>\n" +
            "\t<orderDetailId>%detailId%</orderDetailId>\n" +
            "\t<type>initialization</type>\n" +
            "\t<cause>cert request test</cause>\n" +
            "\t<comment>cert request test</comment>\n" +
            "\t<fxRequestDetails>\n" +
            "\t\t<bodySigned>%body%\n" +
            "\t\t</bodySigned>\n" +
            "\t</fxRequestDetails>\n" +
            "</request>\n" +
            "</docRequestCertIn>";

    private static class Args {
        @Parameter(names = "-dn", description = "DN name")
        String dn;

        @Parameter(names = "-template", description = "Template")
        String template;

        @Parameter(names = "-gen-profile", description = "Profile")
        String genProfile;

        @Parameter(names = "-gen-pass", description = "Pass")
        String genPass;

        @Parameter(names = "-sign-profile", description = "Profile")
        String signProfile;

        @Parameter(names = "-sign-pass", description = "Pass")
        String signPass;

        @Parameter(names = "-tariff-id", description = "Tariff Id")
        Long tariffId;

        @Parameter(names = "-detail-id", description = "Detail Id")
        Long detailId;

    }


    public static void main(String[] args) throws Exception {
        Security.addProvider(new GammaTechProvider());

        Args as = new Args();
        JCommander.newBuilder()
                .addObject(as)
                .build()
                .parse(args);

        if (as.dn != null &&
                as.genProfile != null &&
                as.genPass != null &&
                as.signProfile != null &&
                as.signPass != null &&
                as.tariffId != null &&
                as.detailId != null) {

            generateXml(as.genProfile, as.genPass, as.dn, as.template, as.signProfile,
                as.signPass, as.tariffId, as.detailId);
        }
    }


    private static void generateXml(String genProfile, String genPass,
                                    String dn, String template,
                                    String signProfile, String signPass,
                                    Long tariffId, Long detailId) throws Exception {

        KeyPair keyPair = generateGOSTKeyPair(genProfile, genPass);
        PKCS10CertificationRequest req = makeGOSTpkcs10Request(dn, keyPair, template);

        Assert.assertTrue(req.verify());

        byte[] pkcs7Signed = signPKCS10WithDefProfile(req, signProfile, signPass);
        String sign = new String(Base64.encode(pkcs7Signed));
        System.out.println(XML
                .replace("%dn%", dn)
                .replace("%tariffId%", Long.toString(tariffId))
                .replace("%detailId%", Long.toString(detailId))
                .replace("%body%", sign)
        );
    }

    private static KeyPair generateGOSTKeyPair(String profile, String pass) throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance(ECGOST34310, GAMMA);
        if (GammaTechProvider.algUtil.algKey.containsKey(GOST_ALG)) {
            kpg.initialize(GammaTechProvider.algUtil.algKey.get(GOST_ALG));
        }
        ((JDKKeyPairGenerator.ECGOST34310) kpg).setProfName(profile, pass);
        return kpg.generateKeyPair();
    }

    private static PKCS10CertificationRequest makeGOSTpkcs10Request(String dnName, KeyPair keyPair, String template)
            throws NoSuchAlgorithmException, NoSuchProviderException,
            InvalidKeyException, SignatureException, IOException {
        Attribute attribute = getAttribute();
        return new PKCS10CertificationRequest(ECGOST34310,
                new X509Name(dnName), keyPair.getPublic(),
                getASN1Template(template, attribute), keyPair.getPrivate());
    }

    private static Attribute getAttribute() {
        Vector<Object> ordering = new Vector<>();
        Hashtable<Object, Object> extensions = new Hashtable<>();
        X509Extensions x509extensions = new X509Extensions(ordering, extensions);
        return new Attribute(PKCSObjectIdentifiers.pkcs_9_at_extensionRequest, new DERSet(x509extensions));
    }



    private static ASN1Set getASN1Template(String name, Attribute attribute) throws IOException {
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


    //private static final String profilePass = "123";

    private static byte[] signPKCS10WithDefProfile(PKCS10CertificationRequest req, String profile, String pass)
            throws Exception {
        ClientKeyStoreProvider provider = new ClientKeyStoreProvider(profile, pass);
        return CryptoProcessor.sign(req.getDEREncoded(), provider.getStore(), provider.getPassword());
    }
}
