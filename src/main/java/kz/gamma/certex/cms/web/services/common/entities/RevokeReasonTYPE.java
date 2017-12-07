package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for revokeReasonTYPE.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="revokeReasonTYPE">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="revRUnknown"/>
 *     &lt;enumeration value="revRKey"/>
 *     &lt;enumeration value="revRCA"/>
 *     &lt;enumeration value="revRChangedInfo"/>
 *     &lt;enumeration value="revRChanged"/>
 *     &lt;enumeration value="revRStoped"/>
 *     &lt;enumeration value="revRHold"/>
 *     &lt;enumeration value="revRRemoveFromCRL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "revokeReasonTYPE", namespace = "http://www.gamma.kz/webra/xsd")
@XmlEnum
public enum RevokeReasonTYPE {


    /**
     * Неизвестная причина
     */
    @XmlEnumValue("revRUnknown")
    REV_R_UNKNOWN("revRUnknown"),

    /**
     * Компрометация ключа
     */
    @XmlEnumValue("revRKey")
    REV_R_KEY("revRKey"),

    /**
     * Компрометация Центра Сертификации
     */
    @XmlEnumValue("revRCA")
    REV_RCA("revRCA"),

    /**
     * Изменена информация о владельце сертификата
     */
    @XmlEnumValue("revRChangedInfo")
    REV_R_CHANGED_INFO("revRChangedInfo"),

    /**
     * Замена ключа
     */
    @XmlEnumValue("revRChanged")
    REV_R_CHANGED("revRChanged"),

    /**
     * Действие сертификата приостановлено
     */
    @XmlEnumValue("revRStoped")
    REV_R_STOPED("revRStoped"),

    /**
     * Возобновление действия сертификата
     */
    @XmlEnumValue("revRHold")
    REV_R_HOLD("revRHold"),

    /**
     * Удален из списка отозванных
     */
    @XmlEnumValue("revRRemoveFromCRL")
    REV_R_REMOVE_FROM_CRL("revRRemoveFromCRL");
    private final String value;

    RevokeReasonTYPE(String v) {
        value = v;
    }

    public static RevokeReasonTYPE fromValue(String v) {
        for (RevokeReasonTYPE c : RevokeReasonTYPE.values()) {
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
