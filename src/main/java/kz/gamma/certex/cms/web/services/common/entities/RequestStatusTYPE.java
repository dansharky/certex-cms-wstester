package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for requestStatusTYPE.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="requestStatusTYPE">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="novel"/>
 *     &lt;enumeration value="approved1"/>
 *     &lt;enumeration value="approved2"/>
 *     &lt;enumeration value="rejected"/>
 *     &lt;enumeration value="processed"/>
 *     &lt;enumeration value="error"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "requestStatusTYPE", namespace = "http://www.gamma.kz/webra/xsd")
@XmlEnum
public enum RequestStatusTYPE {


    /**
     * новый
     */
    @XmlEnumValue("novel")
    NOVEL("novel"),

    /**
     * Подтвержден менеджером
     */
    @XmlEnumValue("approved1")
    APPROVED_1("approved1"),

    /**
     * Подтвержден офицером безопасности
     */
    @XmlEnumValue("approved2")
    APPROVED_2("approved2"),

    /**
     * отменен
     */
    @XmlEnumValue("rejected")
    REJECTED("rejected"),

    /**
     * обработан
     */
    @XmlEnumValue("processed")
    PROCESSED("processed"),

    /**
     * содержит ошибки
     */
    @XmlEnumValue("error")
    ERROR("error");
    private final String value;

    RequestStatusTYPE(String v) {
        value = v;
    }

    public static RequestStatusTYPE fromValue(String v) {
        for (RequestStatusTYPE c : RequestStatusTYPE.values()) {
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
