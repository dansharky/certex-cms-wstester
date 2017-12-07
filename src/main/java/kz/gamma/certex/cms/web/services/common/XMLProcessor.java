package kz.gamma.certex.cms.web.services.common;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;

/**
 * Created by dansharky on 3/17/17.
 * Class containing methods to
 * marshall and unmarshall xml messages
 * into objects
 */
public class XMLProcessor {

    public static JAXBContext jaxbContext;
    public static SchemaFactory sf;
    /*    public static final String xsdFile = "/pki_messages.xsd";
        public static final String xsdType = "/pki_type.xsd";*/
    public static Schema schema;

    static {
        try {
            jaxbContext = JAXBContext.newInstance("kz.gamma.certex.cms.web.services.common.entities");
            sf = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            //ClassLoader classLoader = new XMLProcessor().getClass().getClassLoader();
            //File file = new File(classLoader.getResource(xsdFile).getFile());
/*            InputStream inSchema = new XMLProcessor().getClass().getResourceAsStream(xsdFile);
            InputStream inType = new XMLProcessor().getClass().getResourceAsStream(xsdType);
            Source schemaSource = new StreamSource(inSchema);
            Source schemaType = new StreamSource(inType);
            Source[] schemaFiles = new Source[] {schemaType, schemaSource};
            schema = sf.newSchema(schemaFiles);*/
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Object unmarshal(byte[] xml, boolean validate, String encoding, File xsd) throws UnsupportedEncodingException, SAXException {
        Object result = null;
        try {
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            if (validate) {
                unmarshaller.setSchema(sf.newSchema(xsd));
            }
            result = unmarshaller.unmarshal(byteToInputSource(xml, encoding));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String marshal(Object obj) {
        String result = "";
        try {
            Marshaller marshaller = jaxbContext.createMarshaller();
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(obj, stringWriter);
            result = stringWriter.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }


    private static InputSource byteToInputSource(byte[] xml, String encoding) throws UnsupportedEncodingException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xml);
        if (encoding == null || "".equals(encoding))
            encoding = "UTF-8";
        Reader reader = new BufferedReader(new InputStreamReader(byteArrayInputStream, encoding));
        return new InputSource(reader);
    }

}
