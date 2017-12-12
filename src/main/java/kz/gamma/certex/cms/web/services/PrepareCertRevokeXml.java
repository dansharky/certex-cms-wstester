package kz.gamma.certex.cms.web.services;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import kz.gamma.asn1.cms.RevokeRequest;
import kz.gamma.certex.cms.Utils;
import kz.gamma.jce.provider.GammaTechProvider;
import kz.gamma.util.encoders.Base64;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.*;

public class PrepareCertRevokeXml {

    private static final String GKS = "GKS";
    private static final String GAMMA = "GAMMA";
    private static final int DEFAULT_REV_REASON = 4;


    private static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<docRevokeCertIn xmlns=\"http://www.gamma.kz/webra/xsd\">\n" +
            "\t<signedCMS>%signedCMS%\t\n" +
            "\t</signedCMS>\n" +
            "\t<serialNumber>%serial%</serialNumber>\n" +
            "</docRevokeCertIn>";


    private static class Args {

        @Parameter(names = "-profile", description = "Profile", required = true)
        String profile;

        @Parameter(names = "-pass", description = "Pass", required = true)
        String pass;

        @Parameter(names = "-alias", description = "Serial Alias", required = true)
        String alias;

        @Parameter(names = "-reason", description = "Revoke reason")
        Integer reason;


        @Parameter(names = "-output", description = "Output File")
        String output;
    }

    public static void main(String[] args) throws Exception {
        Security.addProvider(new GammaTechProvider());

        Args as = new Args();
        try {
            JCommander.newBuilder()
                    .addObject(as)
                    .build()
                    .parse(args);
        } catch (ParameterException e) {
            System.err.println(e.getMessage());
            return;
        }


        KeyStore keyStore = KeyStore.getInstance(GKS, GAMMA);
        keyStore.load(new ByteArrayInputStream(as.profile.getBytes()), as.pass.toCharArray());
        PrivateKey privKey = (PrivateKey) keyStore.getKey(as.alias, as.profile.toCharArray());
        X509Certificate x509 = (X509Certificate) keyStore.getCertificate(as.alias);
        if (x509 == null) {
            System.err.println("Cert not found!");
            return;
        }

        int revReason = as.reason != null ? as.reason : DEFAULT_REV_REASON;
        RevokeRequest req = new RevokeRequest(x509, revReason);

        byte[] cmsBytes = Utils.getSignedRevokeRequest(req, privKey, x509);
        String cmsSigned = new String(Base64.encode(cmsBytes));

        String xml = XML.replace("%serial%", as.alias).replace("%signedCMS%", cmsSigned);
        System.out.println("xml = " + xml);
        if (as.output != null) {
            System.out.println("Writing result to output: " + as.output);
            Files.write(Paths.get(as.output), xml.getBytes());
        }
    }

}
