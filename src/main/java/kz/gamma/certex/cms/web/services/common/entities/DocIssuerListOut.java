
package kz.gamma.certex.cms.web.services.common.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="issuerList" type="{http://www.gamma.kz/webra/xsd}Issuer" maxOccurs="unbounded" minOccurs="0"/>
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
    "issuerList"
})
@XmlRootElement(name = "docIssuerListOut", namespace = "http://www.gamma.kz/webra/xsd")
public class DocIssuerListOut
    extends PkiDocument
{

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected List<Issuer> issuerList;

    /**
     * Gets the value of the issuerList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the issuerList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIssuerList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Issuer }
     * 
     * 
     */
    public List<Issuer> getIssuerList() {
        if (issuerList == null) {
            issuerList = new ArrayList<Issuer>();
        }
        return this.issuerList;
    }

}
