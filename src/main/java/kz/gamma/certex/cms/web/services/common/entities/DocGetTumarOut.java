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
 *         &lt;element name="body" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "body"
})
@XmlRootElement(name = "docGetTumarOut", namespace = "http://www.gamma.kz/webra/xsd")
public class DocGetTumarOut
        extends PkiDocument {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected byte[] body;

    /**
     * Gets the value of the body property.
     *
     * @return possible object is
     * byte[]
     */
    public byte[] getBody() {
        return body;
    }

    /**
     * Sets the value of the body property.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setBody(byte[] value) {
        this.body = value;
    }

}
