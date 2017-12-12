package kz.gamma.certex.cms.web.services;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import kz.gamma.certex.cms.web.services.client.ClientKeyStoreProvider;
import kz.gamma.certex.cms.web.services.client.WebServiceClient;
import kz.gamma.certex.cms.web.services.common.CryptoProcessor;
import kz.gamma.certex.cms.web.services.common.KeyStoreProvider;
import kz.gamma.certex.cms.web.services.common.XMLProcessor;
import kz.gamma.certex.cms.web.services.common.entities.PkiDocument;
import kz.gamma.certex.cms.web.services.common.entities.RequestPkiService;
import kz.gamma.certex.cms.web.services.common.entities.ResponsePkiService;
import kz.gamma.cms.Pkcs7Data;
import org.apache.commons.io.IOUtils;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import java.io.*;
import javax.xml.transform.stream.StreamResult;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {

    private static final String ENCODING = "UTF-8";

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

        PkiDocument docIn;
        final WebServiceClient ws = new WebServiceClient(as.wsdlUrl);

        byte[] bytes = IOUtils.toByteArray(new FileInputStream(as.inputFilePath));
        docIn = (PkiDocument) XMLProcessor.unmarshal(bytes, true, ENCODING, new File(xsdFilePath));
        docIn = MessageResolver.getDoc(docIn, as.method);

        RequestPkiService request = createPkiRequest(as.method, ENCODING);

        ClientKeyStoreProvider ksp = new ClientKeyStoreProvider(as.profile, as.pass);
        byte[] pkcs7Bytes = objectToPkcs7(docIn, ksp, ENCODING);
        request.setPkcs7(pkcs7Bytes);

        ResponsePkiService response = ws.webraWS.pkiService(request);
        Object out;
        if (response.getPkcs7() != null) {
            out = pkcs7ToObject(response.getPkcs7(), ENCODING, new File(xsdFilePath));
        } else {
            System.out.println("Error: " + response.getError().getCode() + " " + response.getError().getMessage());
            return;
        }

        String result = XMLProcessor.marshal(out);
        FileWriter fw = new FileWriter("result.xml", true);
        byte[] bom = new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF};
        fw.write(new String(bom));

        Document xmlDoc;
        String formattedXML = "";
        try {
            xmlDoc = toXmlDocument(result);
            formattedXML = prettyPrint(xmlDoc);
        } catch (ParserConfigurationException | SAXException | IOException
                | TransformerException e) {
            e.printStackTrace();
        }

        fw.write(formattedXML);
        fw.close();

        System.out.println("THE RESULT:");
        System.out.println(formattedXML);
//                System.out.println(result);

    }

    private static RequestPkiService createPkiRequest(String type, String encoding) {
        RequestPkiService pkiRequest = new RequestPkiService();
        pkiRequest.setRequestDate(dateTimeToGregorianCalendar(new Date()).normalize());
        pkiRequest.setSeance(BigInteger.valueOf(new Date().getTime()));
        pkiRequest.setSystem("WebraWS test case");
        pkiRequest.setService(type);
        pkiRequest.setEncoding(encoding);

        return pkiRequest;
    }

    private static XMLGregorianCalendar dateTimeToGregorianCalendar(Date date) {
        if (date == null)
            return null;

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
            return null;
        }
    }


    private static byte[] objectToPkcs7(Object obj, KeyStoreProvider keyStoreProvider, String encoding) throws Exception {

        String objStr;
        objStr = XMLProcessor.marshal(obj);
        byte[] pkcs7;
        try {
            pkcs7 = CryptoProcessor.sign(objStr.getBytes(encoding), keyStoreProvider.getStore(), keyStoreProvider.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Ошибка при подписывании объекта " + obj, e);
        }

        return pkcs7;
    }

    private static Object pkcs7ToObject(byte[] pkcs7, String encoding, File file) throws Exception {

        Pkcs7Data signedCapicomData = CryptoProcessor.getPkcs7Object(pkcs7);

        if (!signedCapicomData.verify())
            throw new Exception("Подпись контейнера не прошла проверку");

        try {
            return XMLProcessor.unmarshal(signedCapicomData.getData(), true, encoding, file);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new Exception("Ошибка при демаршилизации объекта " + Arrays.toString(pkcs7), e);
        }

    }

    private static String prettyPrint(Document document)
            throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory
                .newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        DOMSource source = new DOMSource(document);
        StringWriter strWriter = new StringWriter();
        StreamResult result = new StreamResult(strWriter);

        transformer.transform(source, result);

        return strWriter.getBuffer().toString();

    }

    private static Document toXmlDocument(String str)
            throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

        return docBuilder.parse(new InputSource(new StringReader(
                str)));
    }


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

        @Parameter(names = "-input", description = "path to xml file containing request", required = true)
        String inputFilePath;

        @Parameter(names = "-wsdl", description = "wsdl url", required = true)
        String wsdlUrl;

        @Parameter(names = "-profile", description = "profile name")
        String profile;

        @Parameter(names = "-pass", description = "pass to pfx")
        String pass;
    }
}
