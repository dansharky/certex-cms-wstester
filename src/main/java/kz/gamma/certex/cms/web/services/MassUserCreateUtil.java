package kz.gamma.certex.cms.web.services;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import kz.gamma.certex.cms.web.services.client.WebServiceClient;
import kz.gamma.certex.cms.web.services.common.CryptoProcessor;
import kz.gamma.certex.cms.web.services.common.XMLProcessor;
import kz.gamma.certex.cms.web.services.common.entities.PkiDocument;
import kz.gamma.certex.cms.web.services.common.entities.RequestPkiService;
import kz.gamma.certex.cms.web.services.common.entities.ResponsePkiService;
import kz.gamma.cms.Pkcs7Data;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MassUserCreateUtil {


    public static final String XML_TEMPLATE = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<docCreatePersonIn xmlns=\"http://www.gamma.kz/webra/xsd\" dateTime=\"2001-12-17T09:30:47Z\">\n" +
            "    <person>\n" +
            "        <lastName>%lastName%</lastName>\n" +
            "        <firstName>%firstName%</firstName>\n" +
            "        <middleName>%middleName%</middleName>\n" +
            "        <roleId>%roleId%</roleId>\n" +
            "        <birthDate>%birthDate%</birthDate>\n" +
            "        <idNumber>%idNumber%</idNumber>\n" +
            "        <idIssuer>%idIssuer%</idIssuer>\n" +
            "        <idIssueDate>%idIssueDate%</idIssueDate>\n" +
            "        <iin>%iin%</iin>\n" +
            "        <st>%st%</st>\n" +
            "        <l>%l%</l>\n" +
            "        <phone>%phone%</phone>\n" +
            "        <mobile>%mobile%</mobile>\n" +
            "        <email>%email%</email>\n" +
            "        <address>%address%</address>\n" +
            "        <legalData>\n" +
            "            <orgName>%legalData.orgName%</orgName>\n" +
            "            <certificate>%legalData.certificate%</certificate>\n" +
            "            <certificateIssuer>%legalData.certificateIssuer%</certificateIssuer>\n" +
            "            <certificateIssueDate>%legalData.certificateIssueDate%</certificateIssueDate>\n" +
            "            <directorSirname>%legalData.directorSirname%</directorSirname>\n" +
            "            <directorPosition>%legalData.directorPosition%</directorPosition>\n" +
            "            <noResident>%legalData.noResident%</noResident>\n" +
            "            <country>%legalData.country%</country>\n" +
            "            <bin>%legalData.bin%</bin>\n" +
            "            <vatin>%legalData.vatin%</vatin>\n" +
            "            <iin>%legalData.iin%</iin>\n" +
            "            <phone>%legalData.phone%</phone>\n" +
            "            <address>%legalData.address%</address>\n" +
            "        </legalData>\n" +
            "        <noResident>%noResident%</noResident>\n" +
            "        <citizenship>%citizenship%</citizenship>\n" +
            "        <ip>%ip%</ip>\n" +
            "        <bik>%bik%</bik>\n" +
            "        <account>%account%</account>\n" +
            "        <isCUser>%isCUser%</isCUser>\n" +
            "        <generatePass>%generatePass%</generatePass>\n" +
            "        <requestCertEmail>%requestCertEmail%</requestCertEmail>\n" +
            "    </person>\n" +
            "    <login>%login%</login>\n" +
            "    <password>%password%</password>\n" +
            "</docCreatePersonIn>";
//    private static final String DEFAULT_SEPARATOR = ",";
    private static final String DEFAULT_SEPARATOR = "\t";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final String TYPE = "createPerson";

    private static class Args {
        @Parameter(names = "-file", description = "CSV File with users", required = true)
        String file;

        @Parameter(names = "-profile", description = "profile name")
        String profile;

        @Parameter(names = "-pass", description = "pass to pfx")
        String pass;

        @Parameter(names = "-wsdl", description = "wsdl url", required = true)
        String wsdlUrl;

        @Parameter(names = "-output-dir", description = "Response folder", required = true)
        String output;

        @Parameter(names = "-encoding", description = "File encoding")
        String encoding;

        @Parameter(names = "-separator", description = "CSV Separator")
        String separator;
    }


    public static void main(String[] args) throws Exception {
        final String userDir = System.getProperty("user.dir");
        final String xsdFilePath = userDir + "/pki_document.xsd";
        final File xsdFile = new File(xsdFilePath);

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

        final Path path = Paths.get(as.file);
        if (!Files.exists(path)) {
            System.err.println("Input file doesn't exists!");
            return;
        }

        String separator = as.separator != null ? as.separator : DEFAULT_SEPARATOR;
        String encoding = as.encoding != null ? as.encoding : DEFAULT_ENCODING;


        List<String> lines = Files.readAllLines(path, Charset.forName(encoding));
        if (lines.size() < 2) {
            System.err.println("Input file has not enough data");
            return;
        }

        Map<String, Integer> columnIndex = new HashMap<>();
        String[] header = lines.get(0).split(separator);
        for (int i = 0; i < header.length; i++) {
            columnIndex.put(header[i], i);
        }

        List<String> params = parseParams(XML_TEMPLATE);

        final WebServiceClient ws = new WebServiceClient(as.wsdlUrl);

        for (int i = 1; i < lines.size(); i++) {

            try {
                System.out.printf("Processing row #%d\n", i);
                String[] row = lines.get(i).split(separator);
                System.out.printf("\tgot %d columns\n", row.length);
                String xml = XML_TEMPLATE;
                for (String param : params) {
                    Integer index = columnIndex.get(param);
                    if (index != null && index < row.length) {
                        String paramValue = row[index].trim();
                        if (paramValue.equals("TRUE")) paramValue = "true";
                        if (paramValue.equals("FALSE")) paramValue = "false";
                        xml = xml.replace("%" + param + "%", paramValue);
                    } else {
                        xml = xml.replaceAll("$.*%" + param + "%.*^", "");
                    }
                }


                final PkiDocument docIn = (PkiDocument) XMLProcessor.unmarshal(xml.getBytes(), true, encoding, xsdFile);
                final RequestPkiService request = Utils.createPkiRequest(TYPE, App.WS_SYSTEM);
                final byte[] pkcs7Bytes = Utils.objectToPkcs7(docIn, as.profile, as.pass);
                request.setPkcs7(pkcs7Bytes);

//                final WebServiceClient ws = new WebServiceClient(as.wsdlUrl);
                ResponsePkiService response = ws.webraWS.pkiService(request);

                if (response.getPkcs7() == null) {
                    System.out.println("Error: " + response.getError().getCode() + " " +
                            response.getError().getMessage());
                    continue;
                }

                Pkcs7Data respPkcs7 = CryptoProcessor.getPkcs7Object(response.getPkcs7());
                FileOutputStream fos = new FileOutputStream(as.output + "/mass-create-resp-" + i + ".xml" );
//            fos.write(BOM);
                fos.write(respPkcs7.getData());
                fos.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    private static List<String> parseParams(String template) {
        String[] lines = template.split("\n");
        Pattern pattern = Pattern.compile(".*%([a-zA-z0-9_.]+)%.*");
        List<String> params = new ArrayList<>();
        for (String line: lines) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                params.add(matcher.group(1));
            }
        }
        return params;
    }

}
