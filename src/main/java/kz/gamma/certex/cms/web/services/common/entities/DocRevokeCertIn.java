
package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.gamma.kz/webra/xsd}PkiDocument">
 *       &lt;sequence>
 *         &lt;element name="signedCMS" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="serialNumber" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "signedCMS",
    "serialNumber"
})
@XmlRootElement(name = "docRevokeCertIn", namespace = "http://www.gamma.kz/webra/xsd")
public class DocRevokeCertIn
    extends PkiDocument
{

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected byte[] signedCMS;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected byte[] serialNumber;

    /**
     * Gets the value of the signedCMS property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getSignedCMS() {
        return signedCMS;
    }

    /**
     * Sets the value of the signedCMS property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setSignedCMS(byte[] value) {
        this.signedCMS = value;
    }

    /**
     * Gets the value of the serialNumber property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the value of the serialNumber property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setSerialNumber(byte[] value) {
        this.serialNumber = value;
    }

}
