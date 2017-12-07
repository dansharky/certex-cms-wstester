package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * OrderDetail
 * <p>
 * <p>Java class for OrderDetail complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="OrderDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE" minOccurs="0"/>
 *         &lt;element name="dn" type="{http://www.gamma.kz/webra/xsd}string255TYPE"/>
 *         &lt;element name="tariffId" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE"/>
 *         &lt;element name="claimCount" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="|[0-9]*"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderDetail", namespace = "http://www.gamma.kz/webra/xsd", propOrder = {
        "id",
        "dn",
        "tariffId",
        "claimCount"
})
public class OrderDetail {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger id;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected String dn;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger tariffId;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String claimCount;

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
    public String getDn() {
        return dn;
    }

    /**
     * Sets the value of the dn property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDn(String value) {
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
     * Gets the value of the claimCount property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getClaimCount() {
        return claimCount;
    }

    /**
     * Sets the value of the claimCount property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setClaimCount(String value) {
        this.claimCount = value;
    }

}
