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
 *     &lt;extension base="{http://www.gamma.kz/webra/xsd}PkiMessageResponse">
 *       &lt;sequence>
 *         &lt;element name="pkcs7" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "pkcs7"
})
@XmlRootElement(name = "responsePkiService", namespace = "http://www.gamma.kz/webra/xsd")
public class ResponsePkiService
        extends PkiMessageResponse {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected byte[] pkcs7;

    /**
     * Gets the value of the pkcs7 property.
     *
     * @return possible object is
     * byte[]
     */
    public byte[] getPkcs7() {
        return pkcs7;
    }

    /**
     * Sets the value of the pkcs7 property.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setPkcs7(byte[] value) {
        this.pkcs7 = value;
    }

}
