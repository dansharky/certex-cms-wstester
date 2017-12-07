package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for userTYPE.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="userTYPE">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="adminType"/>
 *     &lt;enumeration value="managerType"/>
 *     &lt;enumeration value="clientType"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "userTYPE", namespace = "http://www.gamma.kz/webra/xsd")
@XmlEnum
public enum UserTYPE {


    /**
     * Регистрация сертификата
     */
    @XmlEnumValue("adminType")
    ADMIN_TYPE("adminType"),
    @XmlEnumValue("managerType")
    MANAGER_TYPE("managerType"),

    /**
     * Отзыв сертификата
     */
    @XmlEnumValue("clientType")
    CLIENT_TYPE("clientType");
    private final String value;

    UserTYPE(String v) {
        value = v;
    }

    public static UserTYPE fromValue(String v) {
        for (UserTYPE c : UserTYPE.values()) {
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
