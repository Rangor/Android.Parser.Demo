package no.carbonara.parserdemo.business.SAX;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by martinmi on 06.10.13.
 */
public class YrParserSax extends DefaultHandler {

    private static final String REMOVE_TAGS_PATTERN = "(<[^>]+>)";
    private Pattern pattern;

    //TAGS
    private final static String TITLE = "title";
    private final static String BODY = "body";
//    private final static String TAG = "";
//    private final static String TAG = "";
//    private final static String TAG = "";
//    private final static String TAG = "";
//    private final static String TAG = "";
//    private final static String TAG = "";

    //Objects
    private int numberOfElements = 0;
    private ArrayList<String> forecastsArrayList;
    private String tempForecastString;
    private String elementString;

    public YrParserSax() {
        pattern = Pattern.compile(REMOVE_TAGS_PATTERN, Pattern.CASE_INSENSITIVE);
        forecastsArrayList = new ArrayList<String>();
        tempForecastString = "";
        elementString = "";
    }

    public int NumberOfElements() {
        return numberOfElements;
    }

    public ArrayList<String> getForecastTextList() {
        return forecastsArrayList;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        numberOfElements++;

//        if (localName.equals(TITLE)) {
//            Log.d("TITLE", elementString);
//            tempForecastString = elementString;
//        }
//
//        if (localName.equals(BODY)) {
//            Log.d("BODY", elementString);
//            tempForecastString = tempForecastString + elementString;
//        }

        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        elementString += new String(chars, i, i1);
        super.characters(chars, i, i1);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(localName.equals(BODY)){
            forecastsArrayList.add(removeHTMLTags(elementString));
        }
        if (localName.equals(TITLE)) {
            forecastsArrayList.add(removeHTMLTags(elementString));
//            tempForecastString = "";
        }
        Log.d("Testing", elementString);
        elementString = "";
        super.endElement(uri, localName, qName);
    }

    private String removeHTMLTags(String elementString) {
        Matcher matcher = pattern.matcher(elementString);
        return matcher.replaceAll("");
    }

}
