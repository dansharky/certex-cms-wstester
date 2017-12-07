package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * Request
 * <p>
 * <p>Java class for Request complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE" minOccurs="0"/>
 *         &lt;element name="DN" type="{http://www.gamma.kz/webra/xsd}string255TYPE" minOccurs="0"/>
 *         &lt;element name="tariffId" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.gamma.kz/webra/xsd}requestStatusTYPE" minOccurs="0"/>
 *         &lt;element name="orderDetailId" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.gamma.kz/webra/xsd}requestTYPE" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="cause" type="{http://www.gamma.kz/webra/xsd}string255TYPE" minOccurs="0"/>
 *         &lt;element name="comment" type="{http://www.gamma.kz/webra/xsd}string255TYPE" minOccurs="0"/>
 *         &lt;element name="fxRequestDetails" type="{http://www.gamma.kz/webra/xsd}RequestDetail" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Request", namespace = "http://www.gamma.kz/webra/xsd", propOrder = {
        "id",
        "dn",
        "tariffId",
        "status",
        "orderDetailId",
        "type",
        "startDate",
        "endDate",
        "cause",
        "comment",
        "fxRequestDetails"
})
public class Request {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger id;
    @XmlElement(name = "DN", namespace = "http://www.gamma.kz/webra/xsd")
    protected String dn;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger tariffId;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    @XmlSchemaType(name = "string")
    protected RequestStatusTYPE status;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger orderDetailId;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    @XmlSchemaType(name = "string")
    protected RequestTYPE type;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startDate;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDate;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String cause;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String comment;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected List<RequestDetail> fxRequestDetails;

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
     * Gets the value of the dn property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDN() {
        return dn;
    }

    /**
     * Sets the value of the dn property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDN(String value) {
        this.dn = value;
    }

    /**
     * Gets the value of the tariffId property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getTariffId() {
        return tariffId;
    }

    /**
     * Sets the value of the tariffId property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setTariffId(BigInteger value) {
        this.tariffId = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is
     * {@link RequestStatusTYPE }
     */
    public RequestStatusTYPE getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is
     *              {@link RequestStatusTYPE }
     */
    public void setStatus(RequestStatusTYPE value) {
        this.status = value;
    }

    /**
     * Gets the value of the orderDetailId property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getOrderDetailId() {
        return orderDetailId;
    }

    /**
     * Sets the value of the orderDetailId property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setOrderDetailId(BigInteger value) {
        this.orderDetailId = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     * {@link RequestTYPE }
     */
    public RequestTYPE getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link RequestTYPE }
     */
    public void setType(RequestTYPE value) {
        this.type = value;
    }

    /**
     * Gets the value of the startDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the cause property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCause() {
        return cause;
    }

    /**
     * Sets the value of the cause property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCause(String value) {
        this.cause = value;
    }

    /**
     * Gets the value of the comment property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the fxRequestDetails property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fxRequestDetails property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFxRequestDetails().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RequestDetail }
     */
    public List<RequestDetail> getFxRequestDetails() {
        if (fxRequestDetails == null) {
            fxRequestDetails = new ArrayList<RequestDetail>();
        }
        return this.fxRequestDetails;
    }

}
