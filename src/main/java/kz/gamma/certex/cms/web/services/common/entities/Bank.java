
package kz.gamma.certex.cms.web.services.common.entities;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Bank
 * 
 * <p>Java class for Bank complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Bank">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE"/>
 *         &lt;element name="name">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.gamma.kz/webra/xsd}string255TYPE">
 *               &lt;pattern value="[\- "\u04e8\u04e9\u04d8\u04d9\u0492\u0493\u049a\u049b\u04a2\u04a3\u04b0\u04b1\u04ae\u04af\u04ba\u04bb²³à-ÿÀ-ß¨¸a-zA-Z0-9]{1,255}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="bik">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.gamma.kz/webra/xsd}string255TYPE">
 *               &lt;pattern value="[0-9A-Z]{8}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="address" type="{http://www.gamma.kz/webra/xsd}string255TYPE" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.gamma.kz/webra/xsd}string255TYPE" minOccurs="0"/>
 *         &lt;element name="branch" type="{http://www.gamma.kz/webra/xsd}string255TYPE" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Bank", namespace = "http://www.gamma.kz/webra/xsd", propOrder = {
    "id",
    "name",
    "bik",
    "address",
    "description",
    "branch"
})
public class Bank {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger id;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected String name;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected String bik;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String address;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String description;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String branch;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the bik property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBik() {
        return bik;
    }

    /**
     * Sets the value of the bik property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBik(String value) {
        this.bik = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the branch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranch() {
        return branch;
    }

    /**
     * Sets the value of the branch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranch(String value) {
        this.branch = value;
    }

}
