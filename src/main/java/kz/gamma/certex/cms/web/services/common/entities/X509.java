package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * X.509
 * <p>
 * <p>Java class for X.509 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="X.509">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serialNumber" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="body" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "X.509", namespace = "http://www.gamma.kz/webra/xsd", propOrder = {
        "serialNumber",
        "body"
})
public class X509 {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected byte[] serialNumber;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected byte[] body;

    /**
     * Gets the value of the serialNumber property.
     *
     * @return possible object is
     * byte[]
     */
    public byte[] getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the value of the serialNumber property.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setSerialNumber(byte[] value) {
        this.serialNumber = value;
    }

    /**
     * Gets the value of the body property.
     *
     * @return possible object is
     * byte[]
     */
    public byte[] getBody() {
        return body;
    }

    /**
     * Sets the value of the body property.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setBody(byte[] value) {
        this.body = value;
    }

}
