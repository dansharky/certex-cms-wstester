package kz.gamma.certex.cms.web.services;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import kz.gamma.certex.cms.web.services.common.XMLProcessor;
import kz.gamma.certex.cms.web.services.common.entities.DocRequestCertOut;
import kz.gamma.certex.cms.web.services.common.entities.RequestDetail;
import kz.gamma.jce.provider.GammaTechProvider;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.security.Security;

public class PostCertRequest {

    private static final String ENCODING = "UTF-8";
    private static final String DEFAULT_ALGORITHM = "ECGOST34310";

    private static class Args {

        @Parameter(names = "-request", description = "Request result", required = true)
        String request;

        @Parameter(names = "-profile", description = "Profile", required = true)
        String profile;

        @Parameter(names = "-pass", description = "Pass", required = true)
        String pass;

        @Parameter(names = "-algorithm", description = "Algorithm")
        String algorithm;
    }


    public static void main(String[] args) throws Exception {
        Security.addProvider(new GammaTechProvider());

        final String userDir = System.getProperty("user.dir");
        final String xsdFilePath = userDir + "/pki_document.xsd";
        String caGostCertPath = userDir + "/base_Gost.cer";
        String headCaGostCertPath = userDir + "/base_Gost_Head.cer";
        String caRSACertPath = userDir + "/base_Rsa.cer";
        String headRSACertPath = userDir + "/base_Rsa_Head.cer";

        final Args as = new Args();
        try {
            JCommander.newBuilder()
                    .addObject(as)
                    .build()
                    .parse(args);
        } catch (ParameterException e) {
            System.err.println(e.getMessage());
            return;
        }

        String alg = as.algorithm != null ? as.algorithm : DEFAULT_ALGORITHM;

        byte[] bytes = IOUtils.toByteArray(new FileInputStream(as.request));
        DocRequestCertOut docOut = (DocRequestCertOut) XMLProcessor.unmarshal(bytes, true, ENCODING, new File(xsdFilePath));
        System.out.println(docOut);

        System.out.println("Got : " + docOut.getRequest().getFxRequestDetails().size() + " certs, installing");

        for (RequestDetail rd : docOut.getRequest().getFxRequestDetails()) {
            Utils.addCertInProfile(rd,
                    as.profile, as.pass, alg,
                    caGostCertPath, headCaGostCertPath,
                    caRSACertPath, headRSACertPath);
        }

        System.out.println("Certificate is installed!");
    }


}
