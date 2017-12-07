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
 *         &lt;element name="isCUser" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "personId",
        "isCUser"
})
@XmlRootElement(name = "docUpdateCUserIn", namespace = "http://www.gamma.kz/webra/xsd")
public class DocUpdateCUserIn
        extends PkiDocument {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger personId;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected Boolean isCUser;

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
     * Gets the value of the isCUser property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isIsCUser() {
        return isCUser;
    }

    /**
     * Sets the value of the isCUser property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setIsCUser(Boolean value) {
        this.isCUser = value;
    }

}
