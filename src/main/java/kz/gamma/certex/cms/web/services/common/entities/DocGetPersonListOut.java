
package kz.gamma.certex.cms.web.services.common.entities;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="personList" type="{http://www.gamma.kz/webra/xsd}uLong20TYPE" maxOccurs="unbounded" minOccurs="0"/>
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
    "personList"
})
@XmlRootElement(name = "docGetPersonListOut", namespace = "http://www.gamma.kz/webra/xsd")
public class DocGetPersonListOut
    extends PkiDocument
{

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    @XmlSchemaType(name = "unsignedLong")
    protected List<BigInteger> personList;

    /**
     * Gets the value of the personList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BigInteger }
     * 
     * 
     */
    public List<BigInteger> getPersonList() {
        if (personList == null) {
            personList = new ArrayList<BigInteger>();
        }
        return this.personList;
    }

}
