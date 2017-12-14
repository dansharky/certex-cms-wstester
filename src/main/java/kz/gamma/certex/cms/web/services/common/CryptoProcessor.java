package kz.gamma.certex.cms.web.services.common;

import kz.gamma.cms.*;
import kz.gamma.tumarcsp.params.StoreObjectParam;

import java.io.IOException;
import java.security.*;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by dansharky on 3/17/17.
 * <p>
 * Class containing methods to verify
 * and sign xml messages
 */

public class CryptoProcessor {

    /**
     * Формирование объекта PKCS#7
     *
     * @param pkcs7 PKCS#7 в DER кодировке
     * @return Объект PKCS#7
     * @throws Exception
     */
    public static Pkcs7Data getPkcs7Object(byte[] pkcs7) throws Exception {
        Pkcs7Data pkcs7Data = new Pkcs7Data(pkcs7, "");
        try {
            pkcs7Data.retrieveData();
        } catch (Exception e) {
            throw new Exception("Неправильный формат pkcs7", e);
        }
        return pkcs7Data;
    }

    public static byte[] sign(byte[] data, KeyStore store, String password)
            throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException,
            NoSuchProviderException, InvalidAlgorithmParameterException,
            CertStoreException, CMSException, IOException   {
        return sign(data, store, password, null);
    }

    public static byte[] sign(byte[] data, KeyStore store, String password, String alias)
            throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException,
            NoSuchProviderException, InvalidAlgorithmParameterException,
            CertStoreException, CMSException, IOException {

        Enumeration en = store.aliases();
        if (alias == null) {
            while (en.hasMoreElements()) {
                alias = ((StoreObjectParam) en.nextElement()).sn;
            }
        }
        PrivateKey privKey = (PrivateKey) store.getKey(alias, password.toCharArray());
        X509Certificate cert = (X509Certificate) store.getCertificate(alias);

        // Формирование подписанного сообщения в формате PKCS#7
        CMSSignedDataGenerator gen = new CMSSignedDataGenerator();

        // Следует отметить что запросы могут подписывать только Центры Ресгистрации,
        // а также пользователи, если формируют сертификат только для себя!!!
        // Это означает DN имя в запросе, совпадает с DN именем в сертификате подписавшего запрос,
        // и этот пользователь присутствует в системе.
        gen.addSigner(privKey, cert, CMSSignedGenerator.DIGEST_GOST3411G);

        // Добавление сертификата подписавшего запрос в PKCS#7
        List<X509Certificate> certList = new ArrayList<X509Certificate>();
        certList.add(cert);
        CertStore certs = CertStore.getInstance("Collection", new CollectionCertStoreParameters(certList), "GAMMA");
        gen.addCertificatesAndCRLs(certs);

        // Упаковываем запрос в PKCS#7
        CMSSignedData signedData = gen.generate(new CMSProcessableByteArray(data), true, "GAMMA");

        return signedData.getEncoded();
    }
}
