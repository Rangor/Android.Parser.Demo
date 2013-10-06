package no.carbonara.parserdemo.business;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;

/**
 * Created by martinmi on 06.10.13.
 */
public class YrParserController {
    public XMLReader xmlReader;
    public DefaultHandler handler;

    public YrParserController(SAXParser parser, DefaultHandler handler) throws SAXException {

        this.handler = handler;
        xmlReader = parser.getXMLReader();
        xmlReader.setContentHandler(this.handler);
    }
}
