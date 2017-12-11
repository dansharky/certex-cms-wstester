package kz.gamma.certex.cms.web.services;

import com.beust.jcommander.JCommander;
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
import java.util.Date;
import java.util.GregorianCalendar;

public class App {

/*    private static final String profilePath = "officer_gost.pfx";
    private static final String profilePass = "1";*/

    public static void main(String[] args) {

        String[] methods = {"createPerson", "getCertList", "revokeCert", "requestCert",
                "changePassword", "findPerson", "getCityList", "getBankList", "getCountryList",
                "loadPerson", "getIssuerList", "removePerson", "getRoleList", "createOrder",
                "getPositionList", "getRegionList", "getPersonList", "getTariffList",
                "updatePerson", "getTumar", "setDN", "getOrganization", "updateCUser",
                "generateSnList", "confirmOrder", "getOrderList", "getRequestList",
                "getDelayedRequestList"};

        Args arguments = new Args();
        JCommander.newBuilder()
                .addObject(arguments)
                .build()
                .parse(args);

        if (arguments.getMethod() == null) {
            System.out.println("-method");
            for (String method : methods) {
                System.out.println("       " + method);
            }
        }

        if (arguments.getInputFilePath() == null) {
            System.out.println("-input");
            System.out.println("       path to xml file containing the request");
        }

        if (arguments.getWsdlUrl() == null) {
            System.out.println("-wsdl");
            System.out.println("       wsdl url");
        }

        if (arguments.getXsdFilePath() == null) {
            System.out.println("-xsd");
            System.out.println("       path to xsd file");
        }

        if (arguments.getProfile() == null) {
            System.out.println("-profile");
            System.out.println("       profile name");
        }

        if (arguments.getPass() == null) {
            System.out.println("-pass");
            System.out.println("       pass");
        }

        if (arguments.getMethod() != null && !arguments.getMethod().isEmpty()
                && arguments.getInputFilePath() != null && !arguments.getInputFilePath().isEmpty()
                && arguments.getWsdlUrl() != null && !arguments.getWsdlUrl().isEmpty()
                && arguments.getXsdFilePath() != null && !arguments.getXsdFilePath().isEmpty()
                && arguments.getProfile() != null && !arguments.getProfile().isEmpty()
                && arguments.getPass() != null && !arguments.getPass().isEmpty()) {

            PkiDocument docIn;
            try {
                WebServiceClient ws = new WebServiceClient(arguments.getWsdlUrl());
                String encoding = "UTF-8";
                byte[] bytes = IOUtils.toByteArray(new FileInputStream(arguments.getInputFilePath()));
                docIn = (PkiDocument) XMLProcessor.unmarshal(bytes, true, encoding, new File(arguments.getXsdFilePath()));
                docIn = MessageResolver.getDoc(docIn, arguments.getMethod());
                RequestPkiService request = createPkiRequest(arguments.getMethod(), encoding);
                ClientKeyStoreProvider ksp = new ClientKeyStoreProvider(arguments.getProfile(), arguments.getPass());
                byte[] pkcs7Bytes = objectToPkcs7(docIn, ksp, encoding);
                request.setPkcs7(pkcs7Bytes);
                ResponsePkiService response = ws.webraWS.pkiService(request);
                Object out;
                if (response.getPkcs7() != null) {
                    out = pkcs7ToObject(response.getPkcs7(), true, encoding, new File(arguments.getXsdFilePath()));
                } else {
                    System.out.println("Error: " + response.getError().getCode() + " " + response.getError().getMessage());
                    return;
                }
                String result = XMLProcessor.marshal(out);
                FileWriter fw = new FileWriter("result.xml", true);
                byte[] bom = new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF};
                fw.write(new String(bom));

                Document xmlDoc = null;
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
                System.out.println(result);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static RequestPkiService createPkiRequest(String type, String encoding) {
        RequestPkiService pkiRequest = new RequestPkiService();
        pkiRequest.setRequestDate(dateTimeToGregorianCalendar(new Date()).normalize());
        pkiRequest.setSeance(BigInteger.valueOf(new Date().getTime()));
        pkiRequest.setSystem("WebraWS test case");
        pkiRequest.setService(type);
        pkiRequest.setEncoding(encoding);

        return pkiRequest;
    }

    public static XMLGregorianCalendar dateTimeToGregorianCalendar(Date date) {
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


    public static byte[] objectToPkcs7(Object obj, KeyStoreProvider keyStoreProvider, String encoding) throws Exception {

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

    public static Object pkcs7ToObject(byte[] pkcs7, boolean validate, String encoding, File file) throws Exception {

        Pkcs7Data signedCapicomData = CryptoProcessor.getPkcs7Object(pkcs7);

        if (!signedCapicomData.verify())
            throw new Exception("Подпись контейнера не прошла проверку");

        try {
            return XMLProcessor.unmarshal(signedCapicomData.getData(), validate, encoding, file);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new Exception("Ошибка при демаршилизации объекта " + pkcs7, e);
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
        Document document = docBuilder.parse(new InputSource(new StringReader(
                str)));

        return document;
    }


}
