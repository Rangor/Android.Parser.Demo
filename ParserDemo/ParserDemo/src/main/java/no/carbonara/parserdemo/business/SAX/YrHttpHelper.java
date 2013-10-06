package no.carbonara.parserdemo.business.SAX;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by martinmi on 06.10.13.
 */
public class YrHttpHelper {

    private static final String trondheimUrlString = "http://www.yr.no/sted/Norge/S%C3%B8r-Tr%C3%B8ndelag/Trondheim/Trondheim/varsel.xml";

    private URL trondheimUrl;

    public YrHttpHelper() throws MalformedURLException {

        trondheimUrl = new URL(trondheimUrlString);

    }
}
