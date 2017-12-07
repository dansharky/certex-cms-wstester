package kz.gamma.certex.cms.web.services;

import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dansharky on 11/14/17.
 */
public class Args {

    @Parameter(names = "-method", description = "web service method name")
    private String method;

    @Parameter(names = "-input", description = "path to xml file containing request")
    private String inputFilePath;

    @Parameter(names = "-wsdl", description = "wsdl url")
    private String wsdlUrl;

    @Parameter(names = "-xsd", description = "path to xsd")
    private String xsdFilePath;

    @Parameter(names = "-pfx", description = "path to pfxFile")
    private String pfxFilePath;

    @Parameter(names = "-pass", description = "pass to pfx")
    private String pfxPass;

    public String getMethod() {
        return method;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public String getWsdlUrl() {
        return wsdlUrl;
    }

    public String getXsdFilePath() {
        return xsdFilePath;
    }

    public String getPfxFilePath() {
        return pfxFilePath;
    }

    public String getPfxPass() {
        return pfxPass;
    }
}
