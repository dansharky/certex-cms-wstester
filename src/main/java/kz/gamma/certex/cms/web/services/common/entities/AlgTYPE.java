
package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for algTYPE.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="algTYPE">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GOST"/>
 *     &lt;enumeration value="RSA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "algTYPE", namespace = "http://www.gamma.kz/webra/xsd")
@XmlEnum
public enum AlgTYPE {


    /**
     * ������ ��������� �� XSD. ��� ������� ����������� �������������� xml ���������.
     * 
     */
    GOST,

    /**
     * ������ �������. ��� ������� ������������ � �������.
     * 
     */
    RSA;

    public String value() {
        return name();
    }

    public static AlgTYPE fromValue(String v) {
        return valueOf(v);
    }

}
