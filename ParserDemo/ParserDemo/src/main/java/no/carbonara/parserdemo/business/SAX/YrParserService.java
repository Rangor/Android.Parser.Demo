package no.carbonara.parserdemo.business.SAX;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import no.carbonara.parserdemo.business.SAX.YrParserController;
import no.carbonara.parserdemo.business.SAX.YrParserSax;

/**
 * Created by martinmi on 06.10.13.
 */
public class YrParserService {

    private static final String trondheimUrlString = "http://www.yr.no/sted/Norge/S%C3%B8r-Tr%C3%B8ndelag/Trondheim/Trondheim/varsel.xml";

    public int getNumberOfForecastXmlElements() throws IOException, URISyntaxException, SAXException, ParserConfigurationException {

        SAXParserFactory saxParserFactory;
        URL newUrl = null;
        YrParserSax xmlHandler;
        saxParserFactory = SAXParserFactory.newInstance();
        xmlHandler = new YrParserSax();
        newUrl = new URL(trondheimUrlString);
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(newUrl.toString());
        HttpResponse response = null;
        response = httpClient.execute(httpGet);


        if (response.getStatusLine().getStatusCode() == 200) {
            YrParserController parseController;

            parseController = new YrParserController(saxParserFactory.newSAXParser(), xmlHandler);
            parseController.xmlReader.parse(new InputSource(response.getEntity().getContent()));

            YrParserSax data = (YrParserSax) parseController.handler;

            return data.NumberOfElements();

        }

        return 0;
    }

    public ArrayList<String> getForecastTextArrayList() throws IOException, URISyntaxException, SAXException, ParserConfigurationException {

        SAXParserFactory saxParserFactory;
        URL newUrl = null;
        YrParserSax xmlHandler;
        saxParserFactory = SAXParserFactory.newInstance();
        xmlHandler = new YrParserSax();
        newUrl = new URL(trondheimUrlString);
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(newUrl.toString());
        HttpResponse response = null;
        response = httpClient.execute(httpGet);


        if (response.getStatusLine().getStatusCode() == 200) {
            YrParserController parseController;

            parseController = new YrParserController(saxParserFactory.newSAXParser(), xmlHandler);
            parseController.xmlReader.parse(new InputSource(response.getEntity().getContent()));

            YrParserSax data = (YrParserSax) parseController.handler;

            return data.getForecastTextList();

        }

        return null;
    }
}
