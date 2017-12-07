package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


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
 *         &lt;element name="pesonId" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "pesonId"
})
@XmlRootElement(name = "docGetCertListIn", namespace = "http://www.gamma.kz/webra/xsd")
public class DocGetCertListIn
        extends PkiDocument {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger pesonId;

    /**
     * Gets the value of the pesonId property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getPesonId() {
        return pesonId;
    }

    /**
     * Sets the value of the pesonId property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setPesonId(BigInteger value) {
        this.pesonId = value;
    }

}
