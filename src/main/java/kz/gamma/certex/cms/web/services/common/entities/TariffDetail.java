package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * TariffDetail
 * <p>
 * <p>Java class for TariffDetail complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="TariffDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE"/>
 *         &lt;element name="certificate" type="{http://www.gamma.kz/webra/xsd}string255TYPE" minOccurs="0"/>
 *         &lt;element name="certificateInit" type="{http://www.gamma.kz/webra/xsd}string255TYPE" minOccurs="0"/>
 *         &lt;element name="keySize" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="isSaveKey" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="algType" type="{http://www.gamma.kz/webra/xsd}algTYPE" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TariffDetail", namespace = "http://www.gamma.kz/webra/xsd", propOrder = {
        "id",
        "certificate",
        "certificateInit",
        "keySize",
        "isSaveKey",
        "algType"
})
public class TariffDetail {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger id;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String certificate;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String certificateInit;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected BigInteger keySize;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected boolean isSaveKey;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    @XmlSchemaType(name = "string")
    protected AlgTYPE algType;

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
     * Gets the value of the certificate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCertificate() {
        return certificate;
    }

    /**
     * Sets the value of the certificate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCertificate(String value) {
        this.certificate = value;
    }

    /**
     * Gets the value of the certificateInit property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCertificateInit() {
        return certificateInit;
    }

    /**
     * Sets the value of the certificateInit property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCertificateInit(String value) {
        this.certificateInit = value;
    }

    /**
     * Gets the value of the keySize property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getKeySize() {
        return keySize;
    }

    /**
     * Sets the value of the keySize property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setKeySize(BigInteger value) {
        this.keySize = value;
    }

    /**
     * Gets the value of the isSaveKey property.
     */
    public boolean isIsSaveKey() {
        return isSaveKey;
    }

    /**
     * Sets the value of the isSaveKey property.
     */
    public void setIsSaveKey(boolean value) {
        this.isSaveKey = value;
    }

    /**
     * Gets the value of the algType property.
     *
     * @return possible object is
     * {@link AlgTYPE }
     */
    public AlgTYPE getAlgType() {
        return algType;
    }

    /**
     * Sets the value of the algType property.
     *
     * @param value allowed object is
     *              {@link AlgTYPE }
     */
    public void setAlgType(AlgTYPE value) {
        this.algType = value;
    }

}
