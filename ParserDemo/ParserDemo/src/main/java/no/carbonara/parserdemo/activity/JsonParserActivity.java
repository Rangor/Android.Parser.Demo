package no.carbonara.parserdemo.activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class JsonParserActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jasonparser_activity);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.json_parser, menu);
        return true;
    }
    
}
