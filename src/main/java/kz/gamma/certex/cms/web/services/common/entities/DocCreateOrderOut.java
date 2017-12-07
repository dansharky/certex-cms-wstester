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
 *         &lt;element name="order" type="{http://www.gamma.kz/webra/xsd}Order"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "order"
})
@XmlRootElement(name = "docCreateOrderOut", namespace = "http://www.gamma.kz/webra/xsd")
public class DocCreateOrderOut
        extends PkiDocument {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected Order order;

    /**
     * Gets the value of the order property.
     *
     * @return possible object is
     * {@link Order }
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     *
     * @param value allowed object is
     *              {@link Order }
     */
    public void setOrder(Order value) {
        this.order = value;
    }

}
