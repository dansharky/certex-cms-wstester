
package kz.gamma.certex.cms.web.services.common.entities;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="personId" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE"/>
 *         &lt;element name="isCUser" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="pinId" type="{http://www.gamma.kz/webra/xsd}string255TYPE"/>
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
    "personId",
    "isCUser",
    "pinId"
})
@XmlRootElement(name = "docUpdateCUserIn", namespace = "http://www.gamma.kz/webra/xsd")
public class DocUpdateCUserIn
    extends PkiDocument
{

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger personId;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected Boolean isCUser;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected String pinId;

    /**
     * Gets the value of the personId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPersonId() {
        return personId;
    }

    /**
     * Sets the value of the personId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPersonId(BigInteger value) {
        this.personId = value;
    }

    /**
     * Gets the value of the isCUser property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsCUser() {
        return isCUser;
    }

    /**
     * Sets the value of the isCUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCUser(Boolean value) {
        this.isCUser = value;
    }

    /**
     * Gets the value of the pinId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPinId() {
        return pinId;
    }

    /**
     * Sets the value of the pinId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPinId(String value) {
        this.pinId = value;
    }

}
