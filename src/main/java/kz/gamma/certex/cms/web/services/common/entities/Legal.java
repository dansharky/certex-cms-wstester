
package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Legal
 * 
 * <p>Java class for Legal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Legal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orgName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="64"/>
 *               &lt;pattern value="[ «»¹!"#$%~&amp;'\(\)\*\+,\-\./:;&lt;=>\?@\[\]\^_`\{\|\}\\\u04e8\u04e9\u04d8\u04d9\u0492\u0493\u049a\u049b\u04a2\u04a3\u04b0\u04b1\u04ae\u04af\u04ba\u04bb²³a-zA-Zà-ÿÀ-ß0-9]{1,64}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="certificate" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="30"/>
 *               &lt;pattern value="[/¹\.\- \(\)\\à-ÿÀ-ß¨¸a-zA-Z0-9]{0,30}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="certificateIssuer" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="certificateIssueDate" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="|(((0[1-9]|[12]\d|3[01])\.(0[13578]|1[02])\.((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\.(0[13456789]|1[012])\.((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\.02\.((19|[2-9]\d)\d{2}))|(29\.02\.((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="directorSirname">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="50"/>
 *               &lt;pattern value="[\- \.\u04e8\u04e9\u04d8\u04d9\u0492\u0493\u049a\u049b\u04a2\u04a3\u04b0\u04b1\u04ae\u04af\u04ba\u04bb²³à-ÿÀ-ß¨¸a-zA-Z]{1,50}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="directorPosition">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="noResident" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="country" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;union>
 *               &lt;simpleType>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                   &lt;pattern value="[A-Z]{2}"/>
 *                 &lt;/restriction>
 *               &lt;/simpleType>
 *               &lt;simpleType>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                   &lt;enumeration value=""/>
 *                 &lt;/restriction>
 *               &lt;/simpleType>
 *             &lt;/union>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="bin" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;union>
 *               &lt;simpleType>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                   &lt;pattern value="[0-9]{12}"/>
 *                 &lt;/restriction>
 *               &lt;/simpleType>
 *               &lt;simpleType>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                   &lt;enumeration value=""/>
 *                 &lt;/restriction>
 *               &lt;/simpleType>
 *             &lt;/union>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="vatin" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[0-9a-zA-Z#\-\./]{0,20}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="iin" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;union>
 *               &lt;simpleType>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                   &lt;pattern value="[0-9]{12}"/>
 *                 &lt;/restriction>
 *               &lt;/simpleType>
 *               &lt;simpleType>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                   &lt;enumeration value=""/>
 *                 &lt;/restriction>
 *               &lt;/simpleType>
 *             &lt;/union>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="phone" type="{http://www.gamma.kz/webra/xsd}Phone" minOccurs="0"/>
 *         &lt;element name="address" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="joinNumber" type="{http://www.gamma.kz/webra/xsd}string255TYPE" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Legal", namespace = "http://www.gamma.kz/webra/xsd", propOrder = {
    "orgName",
    "certificate",
    "certificateIssuer",
    "certificateIssueDate",
    "directorSirname",
    "directorPosition",
    "noResident",
    "country",
    "bin",
    "vatin",
    "iin",
    "phone",
    "address",
    "joinNumber"
})
public class Legal {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected String orgName;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String certificate;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String certificateIssuer;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String certificateIssueDate;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected String directorSirname;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected String directorPosition;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected boolean noResident;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String country;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String bin;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String vatin;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String iin;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String phone;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String address;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String joinNumber;

    /**
     * Gets the value of the orgName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * Sets the value of the orgName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgName(String value) {
        this.orgName = value;
    }

    /**
     * Gets the value of the certificate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificate() {
        return certificate;
    }

    /**
     * Sets the value of the certificate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificate(String value) {
        this.certificate = value;
    }

    /**
     * Gets the value of the certificateIssuer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateIssuer() {
        return certificateIssuer;
    }

    /**
     * Sets the value of the certificateIssuer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateIssuer(String value) {
        this.certificateIssuer = value;
    }

    /**
     * Gets the value of the certificateIssueDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateIssueDate() {
        return certificateIssueDate;
    }

    /**
     * Sets the value of the certificateIssueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateIssueDate(String value) {
        this.certificateIssueDate = value;
    }

    /**
     * Gets the value of the directorSirname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirectorSirname() {
        return directorSirname;
    }

    /**
     * Sets the value of the directorSirname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirectorSirname(String value) {
        this.directorSirname = value;
    }

    /**
     * Gets the value of the directorPosition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirectorPosition() {
        return directorPosition;
    }

    /**
     * Sets the value of the directorPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirectorPosition(String value) {
        this.directorPosition = value;
    }

    /**
     * Gets the value of the noResident property.
     * 
     */
    public boolean isNoResident() {
        return noResident;
    }

    /**
     * Sets the value of the noResident property.
     * 
     */
    public void setNoResident(boolean value) {
        this.noResident = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the bin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBin() {
        return bin;
    }

    /**
     * Sets the value of the bin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBin(String value) {
        this.bin = value;
    }

    /**
     * Gets the value of the vatin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVatin() {
        return vatin;
    }

    /**
     * Sets the value of the vatin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVatin(String value) {
        this.vatin = value;
    }

    /**
     * Gets the value of the iin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIin() {
        return iin;
    }

    /**
     * Sets the value of the iin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIin(String value) {
        this.iin = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
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
     * Gets the value of the joinNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJoinNumber() {
        return joinNumber;
    }

    /**
     * Sets the value of the joinNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJoinNumber(String value) {
        this.joinNumber = value;
    }

}
