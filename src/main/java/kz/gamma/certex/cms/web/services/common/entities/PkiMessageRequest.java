package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;


/**
 * Request
 * <p>
 * <p>Java class for PkiMessageRequest complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="PkiMessageRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="service" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="requestDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="system" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="seance" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" />
 *       &lt;attribute name="encoding" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PkiMessageRequest", namespace = "http://www.gamma.kz/webra/xsd")
@XmlSeeAlso({
        RequestPkiService.class
})
public class PkiMessageRequest {

    @XmlAttribute(name = "service")
    protected String service;
    @XmlAttribute(name = "requestDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar requestDate;
    @XmlAttribute(name = "system")
    protected String system;
    @XmlAttribute(name = "seance")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger seance;
    @XmlAttribute(name = "encoding")
    protected String encoding;

    /**
     * Gets the value of the service property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setService(String value) {
        this.service = value;
    }

    /**
     * Gets the value of the requestDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getRequestDate() {
        return requestDate;
    }

    /**
     * Sets the value of the requestDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setRequestDate(XMLGregorianCalendar value) {
        this.requestDate = value;
    }

    /**
     * Gets the value of the system property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSystem() {
        return system;
    }

    /**
     * Sets the value of the system property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSystem(String value) {
        this.system = value;
    }

    /**
     * Gets the value of the seance property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getSeance() {
        return seance;
    }

    /**
     * Sets the value of the seance property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setSeance(BigInteger value) {
        this.seance = value;
    }

    /**
     * Gets the value of the encoding property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEncoding() {
        return encoding;
    }

    /**
     * Sets the value of the encoding property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEncoding(String value) {
        this.encoding = value;
    }

}
