package kz.gamma.certex.cms.web.services.client;


import kz.gamma.certex.cms.web.services.server.WebraWS;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class WebServiceClient {

    public WebraWS webraWS;

    public WebServiceClient(String wsdlUrl) throws MalformedURLException {
        URL url = new URL(wsdlUrl);
        QName qname = new QName("http://www.gamma.kz/webra/xsd", "WebraWS");
        Service service = Service.create(url, qname);
        this.webraWS = service.getPort(WebraWS.class);
    }
}
