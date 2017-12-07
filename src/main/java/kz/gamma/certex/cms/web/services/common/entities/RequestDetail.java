package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * RequestDetail
 * <p>
 * <p>Java class for RequestDetail complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="RequestDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE" minOccurs="0"/>
 *         &lt;element name="tariffDetailId" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE" minOccurs="0"/>
 *         &lt;element name="profile" type="{http://www.gamma.kz/webra/xsd}string255TYPE" minOccurs="0"/>
 *         &lt;element name="bodySigned" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="certBody" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestDetail", namespace = "http://www.gamma.kz/webra/xsd", propOrder = {
        "id",
        "tariffDetailId",
        "profile",
        "bodySigned",
        "certBody"
})
public class RequestDetail {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger id;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger tariffDetailId;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String profile;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected byte[] bodySigned;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected byte[] certBody;

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
     * Gets the value of the tariffDetailId property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getTariffDetailId() {
        return tariffDetailId;
    }

    /**
     * Sets the value of the tariffDetailId property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setTariffDetailId(BigInteger value) {
        this.tariffDetailId = value;
    }

    /**
     * Gets the value of the profile property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProfile() {
        return profile;
    }

    /**
     * Sets the value of the profile property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProfile(String value) {
        this.profile = value;
    }

    /**
     * Gets the value of the bodySigned property.
     *
     * @return possible object is
     * byte[]
     */
    public byte[] getBodySigned() {
        return bodySigned;
    }

    /**
     * Sets the value of the bodySigned property.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setBodySigned(byte[] value) {
        this.bodySigned = value;
    }

    /**
     * Gets the value of the certBody property.
     *
     * @return possible object is
     * byte[]
     */
    public byte[] getCertBody() {
        return certBody;
    }

    /**
     * Sets the value of the certBody property.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setCertBody(byte[] value) {
        this.certBody = value;
    }

}
