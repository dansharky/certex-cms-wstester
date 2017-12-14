package kz.gamma.certex.cms.web.services;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import kz.gamma.jce.PKCS10CertificationRequest;
import kz.gamma.jce.provider.GammaTechProvider;
import kz.gamma.util.encoders.Base64;
import org.junit.Assert;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.util.List;

public class PrepareCertRequestXml {

    private static final String DETAIL_XML =
            "\t<fxRequestDetails>\n" +
                    "\t\t<bodySigned>%body%\n" +
                    "\t\t</bodySigned>\n" +
                    "\t</fxRequestDetails>";

    private static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<docRequestCertIn xmlns=\"http://www.gamma.kz/webra/xsd\"><request>\n" +
            "\t<DN>%dn%</DN>\n" +
            "\t<tariffId>%tariffId%</tariffId>\n" +
            "\t<status>novel</status>\n" +
            "\t<orderDetailId>%detailId%</orderDetailId>\n" +
            "\t<type>%type%</type>\n" +
            "\t<cause>cert request test</cause>\n" +
            "\t<comment>cert request test</comment>\n" +
            "%details%" +
            "</request>\n" +
            "</docRequestCertIn>";

    private static class Args {
        @Parameter(names = "-dn", description = "DN name")
        String dn;

        @Parameter(names = "-dn-file", description = "File with DN name")
        String dnFile;

        @Parameter(names = "-template", description = "Template", required = true)
        String template;

        @Parameter(names = "-gen-profile", description = "Profile", required = true)
        String genProfile;

        @Parameter(names = "-gen-pass", description = "Pass", required = true)
        String genPass;

        @Parameter(names = "-sign-profile", description = "Profile")
        String signProfile;

        @Parameter(names = "-sign-alias", description = "Sign alias")
        String signAlias;

        @Parameter(names = "-sign-pass", description = "Pass")
        String signPass;

        @Parameter(names = "-tariff-id", description = "Tariff Id", required = true)
        Long tariffId;

        @Parameter(names = "-detail-id", description = "Detail Id", required = true)
        Long detailId;

        @Parameter(names = "-type", description = "Request type", required = true)
        String type;

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

        String signProfile = as.signProfile != null ? as.signProfile : as.genProfile;
        String signPass = as.signPass != null ? as.signPass : as.genPass;

        if (as.dnFile != null) {
            List<String> lines = Files.readAllLines(Paths.get(as.dnFile), Charset.forName("UTF-8"));
            as.dn = lines.get(0);
        }

        String details;
        if (as.template.contains("|")) {
            String[] templates = as.template.split("\\|");
            StringBuilder sb = new StringBuilder();
            for (String template : templates) {
                template = template.trim();
                boolean gostAlg = isGost(template);
                String detail = generateDetail(as.genProfile, as.genPass,
                        signProfile, signPass, as.signAlias,
                        as.dn, template, gostAlg);
                sb.append(detail).append("\n");
            }
            details = sb.toString();
        } else {
            boolean gostAlg = isGost(as.template);
            details = generateDetail(as.genProfile, as.genPass,
                    signProfile, signPass, as.signAlias,
                    as.dn, as.template, gostAlg);
        }

        String xml = XML
                .replace("%dn%", as.dn)
                .replace("%tariffId%", Long.toString(as.tariffId))
                .replace("%detailId%", Long.toString(as.detailId))
                .replace("%type%", as.type)
                .replace("%details%", details)
                .replace("%detail%", details);

        System.out.println(xml);
        if (as.output != null) {
            System.out.println("Writing result to output: " + as.output);
//            Files.write(Paths.get(as.output), xml.getBytes());
            Files.write(Paths.get(as.output), xml.getBytes("UTF-8"));
        }
    }


    private static boolean isGost(String template) {
        return template.matches(".*CN=GOST.*");
    }

    private static String generateDetail(String genProfile, String genPass,
                                         String signProfile, String signPass, String signAlias,
                                         String dn, String template, boolean gost) throws Exception {

        KeyPair keyPair;
        PKCS10CertificationRequest req;
        if (gost) {
            keyPair = Utils.generateGOSTKeyPair(genProfile, genPass);
            req = Utils.makeGOSTpkcs10Request(dn, keyPair, template);
        } else {
            keyPair = Utils.generateRSAKeyPair(genProfile, genPass);
            req = Utils.makeRSApkcs10Request(dn, keyPair, template);
        }

        Assert.assertTrue(req.verify());

        byte[] pkcs7Signed = Utils.signPKCS10WithDefProfile(req, signProfile, signPass, signAlias);
        String sign = new String(Base64.encode(pkcs7Signed));

        return DETAIL_XML.replace("%body%", sign);
    }


}
