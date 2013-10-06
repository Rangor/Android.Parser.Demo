package no.carbonara.parserdemo.business.JSON;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by martinmi on 06.10.13.
 */
public class NtnuJsonFetcher {
    private static final String GET_CLASS_URL = "http://www.ime.ntnu.no/api/emne/";
    private static final String GET_ALL_CLASSES_URL = "http://www.ime.ntnu.no/api/emne/-";

    public static JSONObject getClassObject(String fagkode){

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(GET_CLASS_URL+fagkode);
        HttpResponse response;
        JSONObject object;
        try {
            response = client.execute(post);

            // Get hold of the response entity
            HttpEntity entity = response.getEntity();

            if (entity != null){
                InputStream instream = entity.getContent();
                String result = convertStreamToString(instream);

                //Henter ut JSON array
                object = new JSONObject(result);


                return object;
            }
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return null;
    }

    public static JSONObject getAllClasses(){

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(GET_ALL_CLASSES_URL);
        HttpResponse response;
        JSONArray array;
        JSONObject object;
        ArrayList<JSONObject> classInfoList = new ArrayList();
        try {
            response = client.execute(post);

            // Get hold of the response entity
            HttpEntity entity = response.getEntity();

            if (entity != null){
                InputStream instream = entity.getContent();
                String result = convertStreamToString(instream);

                //Henter ut JSON array
                object = new JSONObject(result);


                return object;
            }
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return null;
    }

    private static String convertStreamToString(InputStream is) {
	    /*
	     * To convert the InputStream to String we use the BufferedReader.readLine()
	     * method. We iterate until the BufferedReader return null which means
	     * there's no more data to read. Each line will appended to a StringBuilder
	     * and returned as String.
	     */

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
