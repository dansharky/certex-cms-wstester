package kz.gamma.certex.cms.web.services;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import kz.gamma.certex.cms.Utils;
import kz.gamma.jce.PKCS10CertificationRequest;
import kz.gamma.jce.provider.GammaTechProvider;
import kz.gamma.util.encoders.Base64;
import org.junit.Assert;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;

public class PrepareCertRequestXml {

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
        @Parameter(names = "-dn", description = "DN name", required = true)
        String dn;

        @Parameter(names = "-template", description = "Template", required = true)
        String template;

        @Parameter(names = "-gen-profile", description = "Profile", required = true)
        String genProfile;

        @Parameter(names = "-gen-pass", description = "Pass", required = true)
        String genPass;

        @Parameter(names = "-sign-profile", description = "Profile", required = true)
        String signProfile;

        @Parameter(names = "-sign-pass", description = "Pass", required = true)
        String signPass;

        @Parameter(names = "-tariff-id", description = "Tariff Id", required = true)
        Long tariffId;

        @Parameter(names = "-detail-id", description = "Detail Id", required = true)
        Long detailId;

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

        KeyPair keyPair = Utils.generateGOSTKeyPair(as.genProfile, as.genPass);
        PKCS10CertificationRequest req = Utils.makeGOSTpkcs10Request(as.dn, keyPair, as.template);
        Assert.assertTrue(req.verify());

        byte[] pkcs7Signed = Utils.signPKCS10WithDefProfile(req, as.signProfile, as.signPass);
        String sign = new String(Base64.encode(pkcs7Signed));

        String xml = XML
                .replace("%dn%", as.dn)
                .replace("%tariffId%", Long.toString(as.tariffId))
                .replace("%detailId%", Long.toString(as.detailId))
                .replace("%body%", sign);
        System.out.println(xml);
        if (as.output != null) {
            System.out.println("Writing result to output: " + as.output);
            Files.write(Paths.get(as.output), xml.getBytes());
        }
    }




}
