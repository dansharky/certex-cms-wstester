
package kz.gamma.certex.cms.web.services.common.entities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Tariff
 * 
 * <p>Java class for Tariff complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tariff">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE"/>
 *         &lt;element name="name" type="{http://www.gamma.kz/webra/xsd}string255TYPE"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="fxTariffDetails" type="{http://www.gamma.kz/webra/xsd}TariffDetail" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tariff", namespace = "http://www.gamma.kz/webra/xsd", propOrder = {
    "id",
    "name",
    "price",
    "fxTariffDetails"
})
public class Tariff {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger id;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected String name;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected BigDecimal price;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected List<TariffDetail> fxTariffDetails;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the fxTariffDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fxTariffDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFxTariffDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TariffDetail }
     * 
     * 
     */
    public List<TariffDetail> getFxTariffDetails() {
        if (fxTariffDetails == null) {
            fxTariffDetails = new ArrayList<TariffDetail>();
        }
        return this.fxTariffDetails;
    }

}
