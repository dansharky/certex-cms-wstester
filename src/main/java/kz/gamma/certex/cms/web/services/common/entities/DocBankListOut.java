
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
 *         &lt;element name="bankList" type="{http://www.gamma.kz/webra/xsd}Bank" maxOccurs="unbounded" minOccurs="0"/>
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
    "bankList"
})
@XmlRootElement(name = "docBankListOut", namespace = "http://www.gamma.kz/webra/xsd")
public class DocBankListOut
    extends PkiDocument
{

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected List<Bank> bankList;

    /**
     * Gets the value of the bankList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bankList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBankList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Bank }
     * 
     * 
     */
    public List<Bank> getBankList() {
        if (bankList == null) {
            bankList = new ArrayList<Bank>();
        }
        return this.bankList;
    }

}
