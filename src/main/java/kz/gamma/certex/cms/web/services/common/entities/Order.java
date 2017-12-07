package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * Order
 * <p>
 * <p>Java class for Order complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="Order">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE" minOccurs="0"/>
 *         &lt;element name="clientId" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE" minOccurs="0"/>
 *         &lt;element name="invoiceNum" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE" minOccurs="0"/>
 *         &lt;element name="bankId" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE" minOccurs="0"/>
 *         &lt;element name="account" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.gamma.kz/webra/xsd}string255TYPE">
 *               &lt;pattern value="[0-9A-Z]{9,20}|"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="status" type="{http://www.gamma.kz/webra/xsd}orderTYPE" minOccurs="0"/>
 *         &lt;element name="payerNumberType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="IIN"/>
 *               &lt;enumeration value="BIN"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="payerNumber" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="\d{12}|"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="payerName" type="{http://www.gamma.kz/webra/xsd}string255TYPE"/>
 *         &lt;element name="payerAddress" type="{http://www.gamma.kz/webra/xsd}string255TYPE"/>
 *         &lt;element name="fxOrderDetails" type="{http://www.gamma.kz/webra/xsd}OrderDetail" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Order", namespace = "http://www.gamma.kz/webra/xsd", propOrder = {
        "id",
        "clientId",
        "invoiceNum",
        "bankId",
        "account",
        "status",
        "payerNumberType",
        "payerNumber",
        "payerName",
        "payerAddress",
        "fxOrderDetails"
})
public class Order {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger id;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger clientId;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger invoiceNum;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger bankId;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String account;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    @XmlSchemaType(name = "string")
    protected OrderTYPE status;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String payerNumberType;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String payerNumber;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected String payerName;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected String payerAddress;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected List<OrderDetail> fxOrderDetails;

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the clientId property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getClientId() {
        return clientId;
    }

    /**
     * Sets the value of the clientId property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setClientId(BigInteger value) {
        this.clientId = value;
    }

    /**
     * Gets the value of the invoiceNum property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getInvoiceNum() {
        return invoiceNum;
    }

    /**
     * Sets the value of the invoiceNum property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setInvoiceNum(BigInteger value) {
        this.invoiceNum = value;
    }

    /**
     * Gets the value of the bankId property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getBankId() {
        return bankId;
    }

    /**
     * Sets the value of the bankId property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setBankId(BigInteger value) {
        this.bankId = value;
    }

    /**
     * Gets the value of the account property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAccount(String value) {
        this.account = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is
     * {@link OrderTYPE }
     */
    public OrderTYPE getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is
     *              {@link OrderTYPE }
     */
    public void setStatus(OrderTYPE value) {
        this.status = value;
    }

    /**
     * Gets the value of the payerNumberType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPayerNumberType() {
        return payerNumberType;
    }

    /**
     * Sets the value of the payerNumberType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPayerNumberType(String value) {
        this.payerNumberType = value;
    }

    /**
     * Gets the value of the payerNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPayerNumber() {
        return payerNumber;
    }

    /**
     * Sets the value of the payerNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPayerNumber(String value) {
        this.payerNumber = value;
    }

    /**
     * Gets the value of the payerName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPayerName() {
        return payerName;
    }

    /**
     * Sets the value of the payerName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPayerName(String value) {
        this.payerName = value;
    }

    /**
     * Gets the value of the payerAddress property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPayerAddress() {
        return payerAddress;
    }

    /**
     * Sets the value of the payerAddress property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPayerAddress(String value) {
        this.payerAddress = value;
    }

    /**
     * Gets the value of the fxOrderDetails property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fxOrderDetails property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFxOrderDetails().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrderDetail }
     */
    public List<OrderDetail> getFxOrderDetails() {
        if (fxOrderDetails == null) {
            fxOrderDetails = new ArrayList<OrderDetail>();
        }
        return this.fxOrderDetails;
    }

}
