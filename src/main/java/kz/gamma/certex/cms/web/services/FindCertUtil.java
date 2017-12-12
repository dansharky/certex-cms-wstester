package kz.gamma.certex.cms.web.services;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import kz.gamma.certex.cms.Utils;
import kz.gamma.jce.provider.GammaTechProvider;
import kz.gamma.tumarcsp.params.StoreObjectParam;
import kz.gamma.util.encoders.Base64;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class FindCertUtil {

    private static final String GKS = "GKS";
    private static final String GAMMA = "GAMMA";

    private static class Args {
        @Parameter(names = "-profile", description = "Profile", required = true)
        String profile;

        @Parameter(names = "-pass", description = "Pass", required = true)
        String pass;
    }

    public static void main(String[] args) throws Exception {
                Security.addProvider(new GammaTechProvider());
        FindCertUtil.Args as = new FindCertUtil.Args();
        try {
            JCommander.newBuilder()
                    .addObject(as)
                    .build()
                    .parse(args);
        } catch (ParameterException e) {
            System.err.println(e.getMessage());
            return;
        }

        listCerts(as.profile, as.pass);
    }

    private static void listCerts(String profile, String pass)
            throws NoSuchProviderException, KeyStoreException, CertificateException,
            NoSuchAlgorithmException, IOException {

        final KeyStore keyStore = KeyStore.getInstance(GKS, GAMMA);
        keyStore.load(new ByteArrayInputStream(profile.getBytes()), pass.toCharArray());
        final CertificateFieldsResolver cr = new CertificateFieldsResolver();

        System.out.printf("Storage %s\n", profile);
        System.out.println("List of certificates installed:");
        Enumeration aliases = keyStore.aliases();
        //берем последний серт - так исторический сложилось
        int idx = 0;
        while (aliases.hasMoreElements()) {
            StoreObjectParam alObj = (StoreObjectParam) aliases.nextElement();
            X509Certificate x509 = alObj.getX509certificate();
//            X509Certificate x509 = Utils.getX509FromBytes(Base64.decode(alObj.getPubKey()));
            System.out.printf("%d. [%tD]  %s\n", idx, alObj.getTimeCreate(), alObj.sn);

            if (x509 != null) {
                System.out.println(x509);
            }

            idx++;
        }
    }

}
