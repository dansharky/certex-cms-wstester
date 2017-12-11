import kz.gamma.asn1.*;
import kz.gamma.asn1.pkcs.PKCSObjectIdentifiers;
import kz.gamma.asn1.x509.Attribute;
import kz.gamma.asn1.x509.X509Extensions;
import kz.gamma.asn1.x509.X509Name;
import kz.gamma.certex.cms.web.services.App;
import kz.gamma.certex.cms.web.services.client.ClientKeyStoreProvider;
import kz.gamma.certex.cms.web.services.common.CryptoProcessor;
import kz.gamma.core.utils.EndiannessUtils;
import kz.gamma.jce.PKCS10CertificationRequest;
import kz.gamma.jce.provider.GammaTechProvider;
import kz.gamma.jce.provider.JDKKeyPairGenerator;
import kz.gamma.util.encoders.Base64;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.ByteOrder;
import java.security.*;
import java.util.Hashtable;
import java.util.Vector;

public class TestHelper {

    private static final String ECGOST34310 = "ECGOST34310";
    private static final String GAMMA = "GAMMA";
    private static final String GOST_ALG = "1.3.6.1.4.1.6801.1.5.8";
    private static final String CP_1251 = "Cp1251";
    private static final String UNICODE = "Unicode";
    private static final EndiannessUtils endiannessUtils = new EndiannessUtils();

    public static void main(String[] args) throws Exception {
        Security.addProvider(new GammaTechProvider());
        String genProfile = "profile://eToken";
        String genPass = "123456";
        String signProfile = "officer_gost";
        String signPass = "1";

//        String dn = "C=KZ, O=Real Madrid, CN=Butragenho Emilio, UID=RNN203748927348, E=wreg_trunk@gt.kz";
        String dn = "C=KZ, O=Ausie Corp., CN=Nicol Kidman, UID=111111111110";

        String temlate = "C=KZ, O=Template, CN=GOST_USER_SIGN_14D";

        makeNewGOSTCert(genProfile, genPass, dn, temlate, signProfile, signPass);
    }

    private static void makeNewGOSTCert(String genProfile, String genPass,
                                        String dn, String template,
                                        String signProfile, String signPass) throws Exception {

        KeyPair keyPair = generateGOSTKeyPair(genProfile, genPass);
        PKCS10CertificationRequest req = makeGOSTpkcs10Request(dn, keyPair, template);

//        System.out.println("PKCS10:");
//        String body = new String(Base64.encode(req.getDEREncoded()));
//        System.out.println(body);
        Assert.assertTrue(req.verify());

        System.out.println();
//        System.out.println("PKCS10 signed:");
        byte[] pkcs7Signed = signPKCS10WithDefProfile(req, signProfile, signPass);
        String sign = new String(Base64.encode(pkcs7Signed));
        System.out.println(sign);
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
        String stringCp1251 = new String(name.getBytes(), CP_1251);
        byte[] unicode = stringCp1251.getBytes(UNICODE);
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
