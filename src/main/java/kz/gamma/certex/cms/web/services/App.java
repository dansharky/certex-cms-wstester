package kz.gamma.certex.cms.web.services;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import kz.gamma.certex.cms.web.services.client.ClientKeyStoreProvider;
import kz.gamma.certex.cms.web.services.client.WebServiceClient;
import kz.gamma.certex.cms.web.services.common.CryptoProcessor;
import kz.gamma.certex.cms.web.services.common.XMLProcessor;
import kz.gamma.certex.cms.web.services.common.entities.PkiDocument;
import kz.gamma.certex.cms.web.services.common.entities.RequestPkiService;
import kz.gamma.certex.cms.web.services.common.entities.ResponsePkiService;

import kz.gamma.cms.Pkcs7Data;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;

public class App {

    private static final String ENCODING = "UTF-8";
    private static final String WS_SYSTEM = "WebraWS test case";
    public static final byte[] BOM = new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF};
    ;

    private static class Args {


        public final static String[] METHODS = {"createPerson", "getCertList", "revokeCert", "requestCert",
                "changePassword", "findPerson", "getCityList", "getBankList", "getCountryList",
                "loadPerson", "getIssuerList", "removePerson", "getRoleList", "createOrder",
                "getPositionList", "getRegionList", "getPersonList", "getTariffList",
                "updatePerson", "getTumar", "setDN", "getOrganization", "updateCUser",
                "generateSnList", "confirmOrder", "getOrderList", "getRequestList",
                "getDelayedRequestList"};

        @Parameter(names = "-method", description = "web service method name", required = true)
        String method;

        @Parameter(names = "-input", description = "Request file")
        String input;

        @Parameter(names = "-output", description = "Response file", required = true)
        String output;

        @Parameter(names = "-wsdl", description = "wsdl url", required = true)
        String wsdlUrl;

        @Parameter(names = "-profile", description = "profile name")
        String profile;

        @Parameter(names = "-pass", description = "pass to pfx")
        String pass;
    }

    public static void main(String[] args) throws Exception {

        final String userDir = System.getProperty("user.dir");
        final String xsdFilePath = userDir + "/pki_document.xsd";

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

        final WebServiceClient ws = new WebServiceClient(as.wsdlUrl);
        final PkiDocument docIn = Utils.createPkiDocument(as.method, as.input, xsdFilePath);
        final RequestPkiService request = Utils.createPkiRequest(as.method, WS_SYSTEM);
        final byte[] pkcs7Bytes = Utils.objectToPkcs7(docIn, as.profile, as.pass);
        request.setPkcs7(pkcs7Bytes);

        ResponsePkiService response = ws.webraWS.pkiService(request);

        if (response.getPkcs7() == null) {
            System.out.println("Error: " + response.getError().getCode() + " " +
                    response.getError().getMessage());
            return;
        }

//        Pkcs7Data respPkcs7 = CryptoProcessor.getPkcs7Object(response.getPkcs7());
//        FileOutputStream fos = new FileOutputStream(as.output);
//        fos.write(BOM);
//        fos.write(respPkcs7.getData());
//        fos.close();

        Object out = Utils.pkcs7ToObject(response.getPkcs7(), new File(xsdFilePath));
        String result = XMLProcessor.marshal(out);

        FileWriter fw = new FileWriter(as.output, false);
        fw.write(new String(BOM));

        Document xmlDoc;
        String formattedXML = "";
        try {
            xmlDoc = Utils.toXmlDocument(result);
            formattedXML = Utils.prettyPrint(xmlDoc);
        } catch (ParserConfigurationException | SAXException | IOException
                | TransformerException e) {
            e.printStackTrace();
        }

        fw.write(formattedXML);
        fw.close();

        System.out.println("THE RESULT:");
        System.out.println(formattedXML);
                System.out.println(result);

    }


}
