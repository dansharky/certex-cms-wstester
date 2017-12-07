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
 *         &lt;element name="tariffList" type="{http://www.gamma.kz/webra/xsd}Tariff" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "tariffList"
})
@XmlRootElement(name = "docTariffListOut", namespace = "http://www.gamma.kz/webra/xsd")
public class DocTariffListOut
        extends PkiDocument {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected List<Tariff> tariffList;

    /**
     * Gets the value of the tariffList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tariffList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTariffList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Tariff }
     */
    public List<Tariff> getTariffList() {
        if (tariffList == null) {
            tariffList = new ArrayList<Tariff>();
        }
        return this.tariffList;
    }

}
