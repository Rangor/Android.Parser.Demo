package no.carbonara.parserdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

import no.carbonara.parserdemo.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void startSaxParserButtonClick(View target){
        startActivity(new Intent(this, SaxParserActivity.class));
    }

    public void startJsonParserButtonClick(View target){
        startActivity(new Intent(this, JsonParserActivity.class));
    }
}
