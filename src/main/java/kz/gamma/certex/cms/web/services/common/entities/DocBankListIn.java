package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="name" type="{http://www.gamma.kz/webra/xsd}string255TYPE" minOccurs="0"/>
 *         &lt;element name="bik" type="{http://www.gamma.kz/webra/xsd}string255TYPE" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "name",
        "bik"
})
@XmlRootElement(name = "docBankListIn", namespace = "http://www.gamma.kz/webra/xsd")
public class DocBankListIn
        extends PkiDocument {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String name;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String bik;

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
     * Gets the value of the bik property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBik() {
        return bik;
    }

    /**
     * Sets the value of the bik property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBik(String value) {
        this.bik = value;
    }

}
