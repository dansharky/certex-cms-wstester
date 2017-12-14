
package kz.gamma.certex.cms.web.services.common.entities;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.gamma.kz/webra/xsd}PkiDocument">
 *       &lt;sequence>
 *         &lt;element name="personId" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE"/>
 *         &lt;element name="personFIO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "personId",
    "personFIO"
})
@XmlRootElement(name = "docRemovePersonOut", namespace = "http://www.gamma.kz/webra/xsd")
public class DocRemovePersonOut
    extends PkiDocument
{

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger personId;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected String personFIO;

    /**
     * Gets the value of the personId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPersonId() {
        return personId;
    }

    /**
     * Sets the value of the personId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPersonId(BigInteger value) {
        this.personId = value;
    }

    /**
     * Gets the value of the personFIO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonFIO() {
        return personFIO;
    }

    /**
     * Sets the value of the personFIO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonFIO(String value) {
        this.personFIO = value;
    }

}
