
package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for codeTYPE.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="codeTYPE">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="xsdValidationError"/>
 *     &lt;enumeration value="signError"/>
 *     &lt;enumeration value="serverError"/>
 *     &lt;enumeration value="uniqueError"/>
 *     &lt;enumeration value="entityNotFound"/>
 *     &lt;enumeration value="payError"/>
 *     &lt;enumeration value="incorrectDataError"/>
 *     &lt;enumeration value="commonError"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "codeTYPE", namespace = "http://www.gamma.kz/webra/xsd")
@XmlEnum
public enum CodeTYPE {


    /**
     * ������ ��������� �� XSD. ��� ������� ����������� �������������� xml ���������.
     * 
     */
    @XmlEnumValue("xsdValidationError")
    XSD_VALIDATION_ERROR("xsdValidationError"),

    /**
     * ������ �������. ��� ������� ������������ � �������.
     * 
     */
    @XmlEnumValue("signError")
    SIGN_ERROR("signError"),

    /**
     * ������ �������. ��� ������������� �� ������������ ������ �� �������.
     * 
     */
    @XmlEnumValue("serverError")
    SERVER_ERROR("serverError"),

    /**
     * ������ ������������. ��������� ��� �������� ������������ �������� � �������.
     * 
     */
    @XmlEnumValue("uniqueError")
    UNIQUE_ERROR("uniqueError"),

    /**
     * ���������� ��������� ��������. ��� �������� �������� � �������.
     * 
     */
    @XmlEnumValue("entityNotFound")
    ENTITY_NOT_FOUND("entityNotFound"),

    /**
     * ������, ��������� � �������.
     * 
     */
    @XmlEnumValue("payError")
    PAY_ERROR("payError"),

    /**
     * ������������ ������.
     * 
     */
    @XmlEnumValue("incorrectDataError")
    INCORRECT_DATA_ERROR("incorrectDataError"),

    /**
     * ����� ������. ������ �� ���������� �� ��� ���� ���������.
     * 
     */
    @XmlEnumValue("commonError")
    COMMON_ERROR("commonError");
    private final String value;

    CodeTYPE(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CodeTYPE fromValue(String v) {
        for (CodeTYPE c: CodeTYPE.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
