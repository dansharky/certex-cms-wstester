package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for orderTYPE.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="orderTYPE">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="novel"/>
 *     &lt;enumeration value="invoiced"/>
 *     &lt;enumeration value="confirmed"/>
 *     &lt;enumeration value="paymented"/>
 *     &lt;enumeration value="rejected"/>
 *     &lt;enumeration value="finished"/>
 *     &lt;enumeration value="accounted"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "orderTYPE", namespace = "http://www.gamma.kz/webra/xsd")
@XmlEnum
public enum OrderTYPE {


    /**
     * Оформлен заказ
     */
    @XmlEnumValue("novel")
    NOVEL("novel"),

    /**
     * Сформирован счет
     */
    @XmlEnumValue("invoiced")
    INVOICED("invoiced"),

    /**
     * Подтвержден
     */
    @XmlEnumValue("confirmed")
    CONFIRMED("confirmed"),

    /**
     * Оплачен по счету
     */
    @XmlEnumValue("paymented")
    PAYMENTED("paymented"),

    /**
     * Отменен
     */
    @XmlEnumValue("rejected")
    REJECTED("rejected"),

    /**
     * Завершен
     */
    @XmlEnumValue("finished")
    FINISHED("finished"),

    /**
     * Сформирован счет-фактура
     */
    @XmlEnumValue("accounted")
    ACCOUNTED("accounted");
    private final String value;

    OrderTYPE(String v) {
        value = v;
    }

    public static OrderTYPE fromValue(String v) {
        for (OrderTYPE c : OrderTYPE.values()) {
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
