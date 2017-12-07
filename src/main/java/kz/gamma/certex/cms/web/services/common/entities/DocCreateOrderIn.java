package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;
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
 *         &lt;element name="clientId" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE"/>
 *         &lt;element name="fxOrderDetails" type="{http://www.gamma.kz/webra/xsd}OrderDetail" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "clientId",
        "fxOrderDetails"
})
@XmlRootElement(name = "docCreateOrderIn", namespace = "http://www.gamma.kz/webra/xsd")
public class DocCreateOrderIn
        extends PkiDocument {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger clientId;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected List<OrderDetail> fxOrderDetails;

    /**
     * Gets the value of the clientId property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getClientId() {
        return clientId;
    }

    /**
     * Sets the value of the clientId property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setClientId(BigInteger value) {
        this.clientId = value;
    }

    /**
     * Gets the value of the fxOrderDetails property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fxOrderDetails property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFxOrderDetails().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrderDetail }
     */
    public List<OrderDetail> getFxOrderDetails() {
        if (fxOrderDetails == null) {
            fxOrderDetails = new ArrayList<OrderDetail>();
        }
        return this.fxOrderDetails;
    }

}
