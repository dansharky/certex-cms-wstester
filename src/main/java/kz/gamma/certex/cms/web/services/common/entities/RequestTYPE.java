package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for requestTYPE.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="requestTYPE">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="registration"/>
 *     &lt;enumeration value="initialization"/>
 *     &lt;enumeration value="revocation"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "requestTYPE", namespace = "http://www.gamma.kz/webra/xsd")
@XmlEnum
public enum RequestTYPE {


    /**
     * Регистрация сертификата
     */
    @XmlEnumValue("registration")
    REGISTRATION("registration"),
    @XmlEnumValue("initialization")
    INITIALIZATION("initialization"),

    /**
     * Отзыв сертификата
     */
    @XmlEnumValue("revocation")
    REVOCATION("revocation");
    private final String value;

    RequestTYPE(String v) {
        value = v;
    }

    public static RequestTYPE fromValue(String v) {
        for (RequestTYPE c : RequestTYPE.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    public String value() {
        return value;
    }

}
