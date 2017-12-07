package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>Java class for anonymous complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.gamma.kz/webra/xsd}PkiDocument">
 *       &lt;sequence>
 *         &lt;element name="personId" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE"/>
 *         &lt;element name="DN">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.gamma.kz/webra/xsd}string255TYPE">
 *               &lt;pattern value="[ ,«»!$&amp;\(\)\*\-\.:&lt;=>\?@\[\]\^_\{\|\}~ӨөӘәҒғҚқҢңҰұҮүҺһІіa-zA-Zа-яА-Я0-9]{1,255}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "personId",
        "dn"
})
@XmlRootElement(name = "docSetDNIn", namespace = "http://www.gamma.kz/webra/xsd")
public class DocSetDNIn
        extends PkiDocument {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger personId;
    @XmlElement(name = "DN", namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected String dn;

    /**
     * Gets the value of the personId property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getPersonId() {
        return personId;
    }

    /**
     * Sets the value of the personId property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setPersonId(BigInteger value) {
        this.personId = value;
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

}
