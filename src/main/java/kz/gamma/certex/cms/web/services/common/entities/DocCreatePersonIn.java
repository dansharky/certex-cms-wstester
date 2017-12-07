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
 *         &lt;element name="person" type="{http://www.gamma.kz/webra/xsd}Person"/>
 *         &lt;element name="login" type="{http://www.gamma.kz/webra/xsd}Login" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.gamma.kz/webra/xsd}Password" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "person",
        "login",
        "password"
})
@XmlRootElement(name = "docCreatePersonIn", namespace = "http://www.gamma.kz/webra/xsd")
public class DocCreatePersonIn
        extends PkiDocument {

    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd", required = true)
    protected Person person;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String login;
    @XmlElement(namespace = "http://www.gamma.kz/webra/xsd")
    protected String password;

    /**
     * Gets the value of the person property.
     *
     * @return possible object is
     * {@link Person }
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Sets the value of the person property.
     *
     * @param value allowed object is
     *              {@link Person }
     */
    public void setPerson(Person value) {
        this.person = value;
    }

    /**
     * Gets the value of the login property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the value of the login property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLogin(String value) {
        this.login = value;
    }

    /**
     * Gets the value of the password property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPassword(String value) {
        this.password = value;
    }

}
