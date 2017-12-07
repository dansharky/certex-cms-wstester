package kz.gamma.certex.cms.web.services;

import kz.gamma.certex.cms.web.services.common.entities.*;

/**
 * Created by dansharky on 11/16/17.
 */
public class MessageResolver {

    public static PkiDocument getDoc(PkiDocument docIn, String method) {
        PkiDocument result = null;
        switch (method) {
            case "createPerson":
                result = docIn;
                break;
            case "getCertList":
                result = docIn;
                break;
            case "revokeCert":
                result = docIn;
                break;
            case "requestCert":
                result = docIn;
                break;
            case "changePassword":
                result = docIn;
                break;
            case "findPerson":
                result = docIn;
                break;
            case "getCityList":
                result = new DocCityListIn();
                break;
            case "getBankList":
                result = docIn;
                break;
            case "getCountryList":
                result = new DocCountryListIn();
                break;
            case "loadPerson":
                result = docIn;
                break;
            case "getIssuerList":
                result = new DocIssuerListIn();
                break;
            case "removePerson":
                result = docIn;
                break;
            case "getRoleList":
                result = new DocGetRolesIn();
                break;
            case "createOrder":
                result = docIn;
                break;
            case "getPositionList":
                result = new DocPositionListIn();
                break;
            case "getRegionList":
                result = new DocRegionListIn();
                break;
            case "getPersonList":
                result = new DocGetPersonListIn();
                break;
            case "getTariffList":
                result = new DocTariffListIn();
                break;
            case "updatePerson":
                result = docIn;
                break;
            case "getTumar":
                result = new DocGetTumarIn();
                break;
            case "setDN":
                result = docIn;
                break;
            case "getOrganization":
                result = new DocGetOrganizationIn();
                break;
            case "updateCUser":
                result = docIn;
                break;
            case "generateSnList":
                result = docIn;
                break;
            case "confirmOrder":
                result = docIn;
                break;
            case "getOrderList":
                result = docIn;
                break;
            case "getRequestList":
                result = docIn;
                break;
            case "getDelayedRequestList":
                result = docIn;
                break;
        }

        return result;
    }
}
