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
 *         &lt;element name="organization" type="{http://www.gamma.kz/webra/xsd}Organization"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "organization"
})
@XmlRootElement(name = "docGetOrganizationOut", namespace = "http://www.gamma.kz/webra/xsd")
public class DocGetOrganizationOut
        extends PkiDocument {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected Organization organization;

    /**
     * Gets the value of the organization property.
     *
     * @return possible object is
     * {@link Organization }
     */
    public Organization getOrganization() {
        return organization;
    }

    /**
     * Sets the value of the organization property.
     *
     * @param value allowed object is
     *              {@link Organization }
     */
    public void setOrganization(Organization value) {
        this.organization = value;
    }

}
