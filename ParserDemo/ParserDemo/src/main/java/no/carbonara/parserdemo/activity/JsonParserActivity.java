package no.carbonara.parserdemo.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import no.carbonara.parserdemo.R;
import no.carbonara.parserdemo.business.JSON.NtnuJsonFetcher;

public class JsonParserActivity extends Activity {

    private JSONObject allClassesObject;
    private JSONArray allClassesArray;

    private TextView jsonAnswerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jasonparser_activity);

        jsonAnswerText = (TextView)findViewById(R.id.jsonResultText);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.json_parser, menu);
        return true;
    }

    public void getAllClassesClick(View target){
        GetAllClassesTask task = new GetAllClassesTask();
        task.execute();
    }
    public void formatAllClassesClick(View target) throws JSONException {
        String allClassesFormatedString = "";
        int length = allClassesArray.length();
        for(int i = 0; i < allClassesArray.length(); i++){
            JSONObject courseObj = allClassesArray.getJSONObject(i);
            String code = courseObj.getString("code");
            String name = courseObj.getString("name");
            allClassesFormatedString = allClassesFormatedString + code + " " + name + "\n";
        }
        jsonAnswerText.setText(allClassesFormatedString);
    }


    private class GetAllClassesTask extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... params) {
            allClassesObject = NtnuJsonFetcher.getAllClasses();
            try {
                allClassesArray = allClassesObject.getJSONArray("course");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            String ans = "" + allClassesArray.length();
            Log.d("Testing", ans);
            jsonAnswerText.setText(allClassesArray.toString());
        }
    }
    
}
