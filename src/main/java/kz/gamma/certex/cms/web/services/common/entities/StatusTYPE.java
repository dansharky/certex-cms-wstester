
package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for statusTYPE.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="statusTYPE">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OK"/>
 *     &lt;enumeration value="ERROR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "statusTYPE", namespace = "http://www.gamma.kz/webra/xsd")
@XmlEnum
public enum StatusTYPE {


    /**
     * Успешный результат выполнения
     * 
     */
    OK,

    /**
     * Ошибка выполнения
     * 
     */
    ERROR;

    public String value() {
        return name();
    }

    public static StatusTYPE fromValue(String v) {
        return valueOf(v);
    }

}
