package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element name="issuerList" type="{http://www.gamma.kz/webra/xsd}Issuer" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "issuerList"
})
@XmlRootElement(name = "docIssuerListOut", namespace = "http://www.gamma.kz/webra/xsd")
public class DocIssuerListOut
        extends PkiDocument {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected List<Issuer> issuerList;

    /**
     * Gets the value of the issuerList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the issuerList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIssuerList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Issuer }
     */
    public List<Issuer> getIssuerList() {
        if (issuerList == null) {
            issuerList = new ArrayList<Issuer>();
        }
        return this.issuerList;
    }

}
