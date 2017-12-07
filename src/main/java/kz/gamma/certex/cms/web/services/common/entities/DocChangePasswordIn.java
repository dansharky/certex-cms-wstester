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
 *         &lt;element name="password" type="{http://www.gamma.kz/webra/xsd}Password"/>
 *         &lt;element name="personId" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "password",
        "personId"
})
@XmlRootElement(name = "docChangePasswordIn", namespace = "http://www.gamma.kz/webra/xsd")
public class DocChangePasswordIn
        extends PkiDocument {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected String password;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger personId;

    /**
     * Gets the value of the password property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPassword(String value) {
        this.password = value;
    }

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

}
