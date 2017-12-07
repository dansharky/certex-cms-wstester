package kz.gamma.certex.cms.web.services.common.entities;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Abstract Document
 * <p>
 * <p>Java class for PkiDocument complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="PkiDocument">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="dateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PkiDocument", namespace = "http://www.gamma.kz/webra/xsd")
@XmlSeeAlso({
        DocCityListIn.class,
        DocLoadPersonIn.class,
        DocFindPersonOut.class,
        DocGetRolesOut.class,
        DocGenerateSANListOut.class,
        DocChangePasswordIn.class,
        DocRevokeCertOut.class,
        DocRegionListOut.class,
        DocGenerateSANListIn.class,
        DocFindPersonIn.class,
        DocCreatePersonIn.class,
        DocIssuerListIn.class,
        DocCreateOrderIn.class,
        DocRequestListOut.class,
        DocRemovePersonOut.class,
        DocLoadPersonOut.class,
        DocRequestListIn.class,
        DocConfirmOrderOut.class,
        DocCreatePersonOut.class,
        DocCreateOrderOut.class,
        DocGetTumarOut.class,
        DocRevokeCertIn.class,
        DocCountryListIn.class,
        DocIssuerListOut.class,
        DocRemovePersonIn.class,
        DocUpdatePersonOut.class,
        DocGetOrganizationIn.class,
        DocOrderListIn.class,
        DocSetDNOut.class,
        DocRegionListIn.class,
        DocUpdateCUserIn.class,
        DocOrderListOut.class,
        DocUpdateCUserOut.class,
        DocGetPersonListOut.class,
        DocBankListIn.class,
        DocGetOrganizationOut.class,
        DocCountryListOut.class,
        DocGetRolesIn.class,
        DocPositionListOut.class,
        DocCityListOut.class,
        DocSetDNIn.class,
        DocGetCertListIn.class,
        DocRequestCertOut.class,
        DocGetCertListOut.class,
        DocTariffListIn.class,
        DocBankListOut.class,
        DocUpdatePersonIn.class,
        DocGetTumarIn.class,
        DocConfirmOrderIn.class,
        DocRequestCertIn.class,
        DocChangePasswordOut.class,
        DocGetPersonListIn.class,
        DocPositionListIn.class,
        DocTariffListOut.class
})
public class PkiDocument {

    @XmlAttribute(name = "dateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTime;

    /**
     * Gets the value of the dateTime property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDateTime(XMLGregorianCalendar value) {
        this.dateTime = value;
    }

}
