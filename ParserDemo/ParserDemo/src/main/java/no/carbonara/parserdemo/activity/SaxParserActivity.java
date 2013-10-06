package no.carbonara.parserdemo.activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import no.carbonara.parserdemo.R;

public class SaxParserActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saxparser_activity);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sax_parser, menu);
        return true;
    }
    
}
