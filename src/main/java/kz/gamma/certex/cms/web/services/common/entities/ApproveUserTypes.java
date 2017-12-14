
package kz.gamma.certex.cms.web.services.common.entities;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Organization
 * 
 * <p>Java class for ApproveUserTypes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApproveUserTypes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE"/>
 *         &lt;element name="name">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="255"/>
 *               &lt;pattern value="[^"]{1,255}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="approveLevel" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="requestUserType" type="{http://www.gamma.kz/webra/xsd}userTYPE"/>
 *         &lt;element name="confirmUserType" type="{http://www.gamma.kz/webra/xsd}userTYPE"/>
 *         &lt;element name="requestType" type="{http://www.gamma.kz/webra/xsd}requestTYPE"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApproveUserTypes", namespace = "http://www.gamma.kz/webra/xsd", propOrder = {
    "id",
    "name",
    "approveLevel",
    "requestUserType",
    "confirmUserType",
    "requestType"
})
public class ApproveUserTypes {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger id;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected String name;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected short approveLevel;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    @XmlSchemaType(name = "string")
    protected UserTYPE requestUserType;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    @XmlSchemaType(name = "string")
    protected UserTYPE confirmUserType;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    @XmlSchemaType(name = "string")
    protected RequestTYPE requestType;

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
     * Gets the value of the approveLevel property.
     * 
     */
    public short getApproveLevel() {
        return approveLevel;
    }

    /**
     * Sets the value of the approveLevel property.
     * 
     */
    public void setApproveLevel(short value) {
        this.approveLevel = value;
    }

    /**
     * Gets the value of the requestUserType property.
     * 
     * @return
     *     possible object is
     *     {@link UserTYPE }
     *     
     */
    public UserTYPE getRequestUserType() {
        return requestUserType;
    }

    /**
     * Sets the value of the requestUserType property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserTYPE }
     *     
     */
    public void setRequestUserType(UserTYPE value) {
        this.requestUserType = value;
    }

    /**
     * Gets the value of the confirmUserType property.
     * 
     * @return
     *     possible object is
     *     {@link UserTYPE }
     *     
     */
    public UserTYPE getConfirmUserType() {
        return confirmUserType;
    }

    /**
     * Sets the value of the confirmUserType property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserTYPE }
     *     
     */
    public void setConfirmUserType(UserTYPE value) {
        this.confirmUserType = value;
    }

    /**
     * Gets the value of the requestType property.
     * 
     * @return
     *     possible object is
     *     {@link RequestTYPE }
     *     
     */
    public RequestTYPE getRequestType() {
        return requestType;
    }

    /**
     * Sets the value of the requestType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestTYPE }
     *     
     */
    public void setRequestType(RequestTYPE value) {
        this.requestType = value;
    }

}
