package no.carbonara.parserdemo.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import no.carbonara.parserdemo.R;
import no.carbonara.parserdemo.business.SAX.YrParserService;

public class SaxParserActivity extends Activity {

    private int numberOfElements = 0;
    private ArrayList<String> foreCastArrayList = new ArrayList<String>();

    private TextView saxParserResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saxparser_activity);

        saxParserResult = (TextView)findViewById(R.id.saxResultText);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sax_parser, menu);
        return true;
    }

    public void numberOfElementsClick(View target){
        NumberOfElementsTask task = new NumberOfElementsTask();
        task.execute();
    }


    private class NumberOfElementsTask extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... params) {
            YrParserService service = new YrParserService();
            try {
               numberOfElements =  service.getNumberOfForecastXmlElements();
               foreCastArrayList = service.getForecastTextArrayList();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Log.d("Testing", numberOfElements +"");
            Log.d("Testing", foreCastArrayList.size() +"");
            saxParserResult.setText(foreCastArrayList.toString());
        }
    }
}
