package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * Organization
 * <p>
 * <p>Java class for Organization complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="Organization">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="legalData" type="{http://www.gamma.kz/webra/xsd}Legal"/>
 *         &lt;element name="isBlocked" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isCertLogin" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isSimpleOrder" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isPreOrder" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isDefaultOrder" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isApproveInit" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isApproveOneReg" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isApproveTwoReg" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isApproveOneRev" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isApproveTwoRev" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isGetTumar" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isGetTumarJce" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="defaultOrder" type="{http://www.gamma.kz/webra/xsd}Order" minOccurs="0"/>
 *         &lt;element name="createDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="defaultUser" type="{http://www.gamma.kz/webra/xsd}Person" minOccurs="0"/>
 *         &lt;element name="fxOrganizationsApproves" type="{http://www.gamma.kz/webra/xsd}ApproveUserTypes" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Organization", namespace = "http://www.gamma.kz/webra/xsd", propOrder = {
        "legalData",
        "isBlocked",
        "isCertLogin",
        "isSimpleOrder",
        "isPreOrder",
        "isDefaultOrder",
        "isApproveInit",
        "isApproveOneReg",
        "isApproveTwoReg",
        "isApproveOneRev",
        "isApproveTwoRev",
        "isGetTumar",
        "isGetTumarJce",
        "defaultOrder",
        "createDate",
        "defaultUser",
        "fxOrganizationsApproves"
})
public class Organization {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected Legal legalData;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected boolean isBlocked;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected boolean isCertLogin;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected boolean isSimpleOrder;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected boolean isPreOrder;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected boolean isDefaultOrder;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected boolean isApproveInit;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected boolean isApproveOneReg;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected boolean isApproveTwoReg;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected boolean isApproveOneRev;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected boolean isApproveTwoRev;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected boolean isGetTumar;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected boolean isGetTumarJce;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected Order defaultOrder;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar createDate;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected Person defaultUser;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected List<ApproveUserTypes> fxOrganizationsApproves;

    /**
     * Gets the value of the legalData property.
     *
     * @return possible object is
     * {@link Legal }
     */
    public Legal getLegalData() {
        return legalData;
    }

    /**
     * Sets the value of the legalData property.
     *
     * @param value allowed object is
     *              {@link Legal }
     */
    public void setLegalData(Legal value) {
        this.legalData = value;
    }

    /**
     * Gets the value of the isBlocked property.
     */
    public boolean isIsBlocked() {
        return isBlocked;
    }

    /**
     * Sets the value of the isBlocked property.
     */
    public void setIsBlocked(boolean value) {
        this.isBlocked = value;
    }

    /**
     * Gets the value of the isCertLogin property.
     */
    public boolean isIsCertLogin() {
        return isCertLogin;
    }

    /**
     * Sets the value of the isCertLogin property.
     */
    public void setIsCertLogin(boolean value) {
        this.isCertLogin = value;
    }

    /**
     * Gets the value of the isSimpleOrder property.
     */
    public boolean isIsSimpleOrder() {
        return isSimpleOrder;
    }

    /**
     * Sets the value of the isSimpleOrder property.
     */
    public void setIsSimpleOrder(boolean value) {
        this.isSimpleOrder = value;
    }

    /**
     * Gets the value of the isPreOrder property.
     */
    public boolean isIsPreOrder() {
        return isPreOrder;
    }

    /**
     * Sets the value of the isPreOrder property.
     */
    public void setIsPreOrder(boolean value) {
        this.isPreOrder = value;
    }

    /**
     * Gets the value of the isDefaultOrder property.
     */
    public boolean isIsDefaultOrder() {
        return isDefaultOrder;
    }

    /**
     * Sets the value of the isDefaultOrder property.
     */
    public void setIsDefaultOrder(boolean value) {
        this.isDefaultOrder = value;
    }

    /**
     * Gets the value of the isApproveInit property.
     */
    public boolean isIsApproveInit() {
        return isApproveInit;
    }

    /**
     * Sets the value of the isApproveInit property.
     */
    public void setIsApproveInit(boolean value) {
        this.isApproveInit = value;
    }

    /**
     * Gets the value of the isApproveOneReg property.
     */
    public boolean isIsApproveOneReg() {
        return isApproveOneReg;
    }

    /**
     * Sets the value of the isApproveOneReg property.
     */
    public void setIsApproveOneReg(boolean value) {
        this.isApproveOneReg = value;
    }

    /**
     * Gets the value of the isApproveTwoReg property.
     */
    public boolean isIsApproveTwoReg() {
        return isApproveTwoReg;
    }

    /**
     * Sets the value of the isApproveTwoReg property.
     */
    public void setIsApproveTwoReg(boolean value) {
        this.isApproveTwoReg = value;
    }

    /**
     * Gets the value of the isApproveOneRev property.
     */
    public boolean isIsApproveOneRev() {
        return isApproveOneRev;
    }

    /**
     * Sets the value of the isApproveOneRev property.
     */
    public void setIsApproveOneRev(boolean value) {
        this.isApproveOneRev = value;
    }

    /**
     * Gets the value of the isApproveTwoRev property.
     */
    public boolean isIsApproveTwoRev() {
        return isApproveTwoRev;
    }

    /**
     * Sets the value of the isApproveTwoRev property.
     */
    public void setIsApproveTwoRev(boolean value) {
        this.isApproveTwoRev = value;
    }

    /**
     * Gets the value of the isGetTumar property.
     */
    public boolean isIsGetTumar() {
        return isGetTumar;
    }

    /**
     * Sets the value of the isGetTumar property.
     */
    public void setIsGetTumar(boolean value) {
        this.isGetTumar = value;
    }

    /**
     * Gets the value of the isGetTumarJce property.
     */
    public boolean isIsGetTumarJce() {
        return isGetTumarJce;
    }

    /**
     * Sets the value of the isGetTumarJce property.
     */
    public void setIsGetTumarJce(boolean value) {
        this.isGetTumarJce = value;
    }

    /**
     * Gets the value of the defaultOrder property.
     *
     * @return possible object is
     * {@link Order }
     */
    public Order getDefaultOrder() {
        return defaultOrder;
    }

    /**
     * Sets the value of the defaultOrder property.
     *
     * @param value allowed object is
     *              {@link Order }
     */
    public void setDefaultOrder(Order value) {
        this.defaultOrder = value;
    }

    /**
     * Gets the value of the createDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getCreateDate() {
        return createDate;
    }

    /**
     * Sets the value of the createDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setCreateDate(XMLGregorianCalendar value) {
        this.createDate = value;
    }

    /**
     * Gets the value of the defaultUser property.
     *
     * @return possible object is
     * {@link Person }
     */
    public Person getDefaultUser() {
        return defaultUser;
    }

    /**
     * Sets the value of the defaultUser property.
     *
     * @param value allowed object is
     *              {@link Person }
     */
    public void setDefaultUser(Person value) {
        this.defaultUser = value;
    }

    /**
     * Gets the value of the fxOrganizationsApproves property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fxOrganizationsApproves property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFxOrganizationsApproves().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApproveUserTypes }
     */
    public List<ApproveUserTypes> getFxOrganizationsApproves() {
        if (fxOrganizationsApproves == null) {
            fxOrganizationsApproves = new ArrayList<ApproveUserTypes>();
        }
        return this.fxOrganizationsApproves;
    }

}
