
package kz.gamma.certex.cms.web.services.common.entities;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Response
 * 
 * <p>Java class for PkiMessageResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PkiMessageResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="error" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="code" type="{http://www.gamma.kz/webra/xsd}codeTYPE"/>
 *                   &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="details" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="status" type="{http://www.gamma.kz/webra/xsd}statusTYPE"/>
 *       &lt;/sequence>
 *       &lt;attribute name="service" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="responseDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="system" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="seance" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" />
 *       &lt;attribute name="encoding" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PkiMessageResponse", namespace = "http://www.gamma.kz/webra/xsd", propOrder = {
    "error",
    "status"
})
@XmlSeeAlso({
    ResponsePkiService.class
})
public class PkiMessageResponse {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected PkiMessageResponse.Error error;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    @XmlSchemaType(name = "string")
    protected StatusTYPE status;
    @XmlAttribute(name = "service")
    protected String service;
    @XmlAttribute(name = "responseDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar responseDate;
    @XmlAttribute(name = "system")
    protected String system;
    @XmlAttribute(name = "seance")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger seance;
    @XmlAttribute(name = "encoding")
    protected String encoding;

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link PkiMessageResponse.Error }
     *     
     */
    public PkiMessageResponse.Error getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link PkiMessageResponse.Error }
     *     
     */
    public void setError(PkiMessageResponse.Error value) {
        this.error = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link StatusTYPE }
     *     
     */
    public StatusTYPE getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusTYPE }
     *     
     */
    public void setStatus(StatusTYPE value) {
        this.status = value;
    }

    /**
     * Gets the value of the service property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setService(String value) {
        this.service = value;
    }

    /**
     * Gets the value of the responseDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getResponseDate() {
        return responseDate;
    }

    /**
     * Sets the value of the responseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setResponseDate(XMLGregorianCalendar value) {
        this.responseDate = value;
    }

    /**
     * Gets the value of the system property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystem() {
        return system;
    }

    /**
     * Sets the value of the system property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystem(String value) {
        this.system = value;
    }

    /**
     * Gets the value of the seance property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSeance() {
        return seance;
    }

    /**
     * Sets the value of the seance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSeance(BigInteger value) {
        this.seance = value;
    }

    /**
     * Gets the value of the encoding property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncoding() {
        return encoding;
    }

    /**
     * Sets the value of the encoding property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncoding(String value) {
        this.encoding = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="code" type="{http://www.gamma.kz/webra/xsd}codeTYPE"/>
     *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="details" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "code",
        "message",
        "details"
    })
    public static class Error {

        @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
        @XmlSchemaType(name = "string")
        protected CodeTYPE code;
        @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
        protected String message;
        @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
        protected String details;

        /**
         * Gets the value of the code property.
         * 
         * @return
         *     possible object is
         *     {@link CodeTYPE }
         *     
         */
        public CodeTYPE getCode() {
            return code;
        }

        /**
         * Sets the value of the code property.
         * 
         * @param value
         *     allowed object is
         *     {@link CodeTYPE }
         *     
         */
        public void setCode(CodeTYPE value) {
            this.code = value;
        }

        /**
         * Gets the value of the message property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMessage() {
            return message;
        }

        /**
         * Sets the value of the message property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMessage(String value) {
            this.message = value;
        }

        /**
         * Gets the value of the details property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDetails() {
            return details;
        }

        /**
         * Sets the value of the details property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDetails(String value) {
            this.details = value;
        }

    }

}
