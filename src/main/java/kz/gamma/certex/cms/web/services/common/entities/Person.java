
package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Person
 * 
 * <p>Java class for Person complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Person">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lastName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="50"/>
 *               &lt;pattern value="[\- \u04e8\u04e9\u04d8\u04d9\u0492\u0493\u049a\u049b\u04a2\u04a3\u04b0\u04b1\u04ae\u04af\u04ba\u04bb²³à-ÿÀ-ß¨¸a-zA-Z]{1,50}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="firstName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="50"/>
 *               &lt;pattern value="[\- \u04e8\u04e9\u04d8\u04d9\u0492\u0493\u049a\u049b\u04a2\u04a3\u04b0\u04b1\u04ae\u04af\u04ba\u04bb²³à-ÿÀ-ß¨¸a-zA-Z]{1,50}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="middleName" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="50"/>
 *               &lt;pattern value="[\- \u04e8\u04e9\u04d8\u04d9\u0492\u0493\u049a\u049b\u04a2\u04a3\u04b0\u04b1\u04ae\u04af\u04ba\u04bb²³à-ÿÀ-ß¨¸a-zA-Z]{0,50}|"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="roleId" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;union>
 *               &lt;simpleType>
 *                 &lt;restriction base="{http://www.gamma.kz/webra/xsd}uLong20TYPE">
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
 *         &lt;element name="birthDate" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="|(((0[1-9]|[12]\d|3[01])\.(0[13578]|1[02])\.((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\.(0[13456789]|1[012])\.((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\.02\.((19|[2-9]\d)\d{2}))|(29\.02\.((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="idNumber" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="61"/>
 *               &lt;pattern value="[A-Z0-9 «»!$&amp;\(\)\*\-\.:&lt;=>\?@\[\]\^_\{\|\}~ ]{0,61}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="idIssuer" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="idIssueDate" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="|(((0[1-9]|[12]\d|3[01])\.(0[13578]|1[02])\.((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\.(0[13456789]|1[012])\.((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\.02\.((19|[2-9]\d)\d{2}))|(29\.02\.((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))"/>
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
 *         &lt;element name="st" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="l" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="phone" type="{http://www.gamma.kz/webra/xsd}Phone" minOccurs="0"/>
 *         &lt;element name="mobile" type="{http://www.gamma.kz/webra/xsd}Phone" minOccurs="0"/>
 *         &lt;element name="email" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="address" type="{http://www.gamma.kz/webra/xsd}string255TYPE" minOccurs="0"/>
 *         &lt;element name="legalData" type="{http://www.gamma.kz/webra/xsd}Legal" minOccurs="0"/>
 *         &lt;element name="noResident" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="citizenship" minOccurs="0">
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
 *         &lt;element name="ip" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="bik" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="account" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="uid" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="61"/>
 *               &lt;pattern value="[A-Z0-9 «»!$&amp;\(\)\*\-\.:&lt;=>\?@\[\]\^_\{\|\}~ ]{1,61}|"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="password" type="{http://www.gamma.kz/webra/xsd}Password" minOccurs="0"/>
 *         &lt;element name="isCUser" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="generatePass" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="requestCertEmail" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="pinId" type="{http://www.gamma.kz/webra/xsd}string255TYPE" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Person", namespace = "http://www.gamma.kz/webra/xsd", propOrder = {
    "lastName",
    "firstName",
    "middleName",
    "roleId",
    "birthDate",
    "idNumber",
    "idIssuer",
    "idIssueDate",
    "iin",
    "st",
    "l",
    "phone",
    "mobile",
    "email",
    "address",
    "legalData",
    "noResident",
    "citizenship",
    "ip",
    "bik",
    "account",
    "uid",
    "password",
    "isCUser",
    "generatePass",
    "requestCertEmail",
    "pinId"
})
public class Person {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected String lastName;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected String firstName;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String middleName;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String roleId;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String birthDate;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String idNumber;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String idIssuer;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String idIssueDate;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String iin;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected Object st;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected Object l;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String phone;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String mobile;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String email;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String address;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected Legal legalData;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected boolean noResident;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String citizenship;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected boolean ip;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String bik;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String account;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String uid;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String password;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected boolean isCUser;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected boolean generatePass;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected boolean requestCertEmail;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String pinId;

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the middleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the value of the middleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMiddleName(String value) {
        this.middleName = value;
    }

    /**
     * Gets the value of the roleId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * Sets the value of the roleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleId(String value) {
        this.roleId = value;
    }

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthDate(String value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the idNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * Sets the value of the idNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdNumber(String value) {
        this.idNumber = value;
    }

    /**
     * Gets the value of the idIssuer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdIssuer() {
        return idIssuer;
    }

    /**
     * Sets the value of the idIssuer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdIssuer(String value) {
        this.idIssuer = value;
    }

    /**
     * Gets the value of the idIssueDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdIssueDate() {
        return idIssueDate;
    }

    /**
     * Sets the value of the idIssueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdIssueDate(String value) {
        this.idIssueDate = value;
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
     * Gets the value of the st property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSt() {
        return st;
    }

    /**
     * Sets the value of the st property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSt(Object value) {
        this.st = value;
    }

    /**
     * Gets the value of the l property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getL() {
        return l;
    }

    /**
     * Sets the value of the l property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setL(Object value) {
        this.l = value;
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
     * Gets the value of the mobile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the value of the mobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobile(String value) {
        this.mobile = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
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
     * Gets the value of the legalData property.
     * 
     * @return
     *     possible object is
     *     {@link Legal }
     *     
     */
    public Legal getLegalData() {
        return legalData;
    }

    /**
     * Sets the value of the legalData property.
     * 
     * @param value
     *     allowed object is
     *     {@link Legal }
     *     
     */
    public void setLegalData(Legal value) {
        this.legalData = value;
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
     * Gets the value of the citizenship property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCitizenship() {
        return citizenship;
    }

    /**
     * Sets the value of the citizenship property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCitizenship(String value) {
        this.citizenship = value;
    }

    /**
     * Gets the value of the ip property.
     * 
     */
    public boolean isIp() {
        return ip;
    }

    /**
     * Sets the value of the ip property.
     * 
     */
    public void setIp(boolean value) {
        this.ip = value;
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
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccount(String value) {
        this.account = value;
    }

    /**
     * Gets the value of the uid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the value of the uid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUid(String value) {
        this.uid = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the isCUser property.
     * 
     */
    public boolean isIsCUser() {
        return isCUser;
    }

    /**
     * Sets the value of the isCUser property.
     * 
     */
    public void setIsCUser(boolean value) {
        this.isCUser = value;
    }

    /**
     * Gets the value of the generatePass property.
     * 
     */
    public boolean isGeneratePass() {
        return generatePass;
    }

    /**
     * Sets the value of the generatePass property.
     * 
     */
    public void setGeneratePass(boolean value) {
        this.generatePass = value;
    }

    /**
     * Gets the value of the requestCertEmail property.
     * 
     */
    public boolean isRequestCertEmail() {
        return requestCertEmail;
    }

    /**
     * Sets the value of the requestCertEmail property.
     * 
     */
    public void setRequestCertEmail(boolean value) {
        this.requestCertEmail = value;
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
