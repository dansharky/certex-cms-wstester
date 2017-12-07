package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Город
 * <p>
 * <p>Java class for City complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="City">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.gamma.kz/webra/xsd}string255TYPE"/>
 *         &lt;element name="region" type="{http://www.gamma.kz/webra/xsd}Region" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "City", namespace = "http://www.gamma.kz/webra/xsd", propOrder = {
        "name",
        "region"
})
public class City {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected String name;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected Region region;

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the region property.
     *
     * @return possible object is
     * {@link Region }
     */
    public Region getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     *
     * @param value allowed object is
     *              {@link Region }
     */
    public void setRegion(Region value) {
        this.region = value;
    }

}
