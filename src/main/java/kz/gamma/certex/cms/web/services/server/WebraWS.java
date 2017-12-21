package kz.gamma.certex.cms.web.services.server;

import kz.gamma.certex.cms.web.services.common.entities.RequestPkiService;
import kz.gamma.certex.cms.web.services.common.entities.ResponsePkiService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;


@WebService()
public interface WebraWS {

    @WebMethod(operationName = "pkiService")
    ResponsePkiService pkiService(@WebParam(name = "request") RequestPkiService request);

    @WebMethod(operationName = "echo")
    String echo(@WebParam(name = "testParam") String text);

    @WebMethod(operationName = "getVersion")
    List<String> getVersion();

    @WebMethod(operationName = "getDocumentXSD")
    String getDocumentXSD();

    @WebMethod(operationName = "getTypeXSD")
    String getTypeXSD();

    @WebMethod(operationName = "getTumarAdditional")
    byte[] getTumarAdditional(@WebParam(name = "isManager") boolean isManager,
                              @WebParam(name = "isWithJCE") boolean isWithJCE);


}
