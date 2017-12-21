package kz.gamma.certex.cms.web.services;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import kz.gamma.certex.cms.web.services.client.WebServiceClient;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MiscRequestsUtil {

    private static class Args {
        @Parameter(names = "-wsdl", description = "wsdl url", required = true)
        String wsdlUrl;

        @Parameter(names = "-download-dir", description = "Download dir", required = true)
        String downloadDir;
    }

    public static void main(String[] args) throws Exception {

        final Args as = new Args();
        try {
            JCommander.newBuilder()
                    .addObject(as)
                    .build()
                    .parse(args);
        } catch (ParameterException e) {
            System.err.println(e.getMessage());
            return;
        }

        final WebServiceClient ws = new WebServiceClient(as.wsdlUrl);

        System.out.println("Testing echo: ");
        for (int i = 0; i < 10; i++) {
            String request = "text " + i;
            String response = ws.webraWS.echo(request);
            System.out.println("request = " + request);
            System.out.println("response = " + response);
        }

        System.out.println();
        System.out.println("Testing versions: ");
        List<String> versions = ws.webraWS.getVersion();
        versions.forEach(System.out::println);

        System.out.println();
        byte[] tumarBytes = ws.webraWS.getTumarAdditional(true, false);
        Files.write(Paths.get(as.downloadDir + "/tumarcsp.zip"), tumarBytes);
    }

}
