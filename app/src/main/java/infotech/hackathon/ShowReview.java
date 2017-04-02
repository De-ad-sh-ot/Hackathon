package infotech.hackathon;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


public class ShowReview extends ActionBarActivity {
    String myJSON;
    private static final String TAG_RESULTS = "result";
    private static final String TAG_REVIEW = "review";
    private static final String TAG_HOTEL = "hotel_name";
    private static final String TAG_email = "email";


    JSONArray peoples = null;


    ArrayList<HashMap<String, String>> personList;


    ListView list;
    private Button button;


    @Override


    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Show Review");
        setContentView(R.layout.activity_show_review);

        list = (ListView) findViewById(R.id.listView);
        personList = new ArrayList<HashMap<String, String>>();
        getData();
    }

    protected void showList() {
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);
            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);
                String review = c.getString(TAG_REVIEW);
                String hotel_name = c.getString(TAG_HOTEL);

                String email = c.getString(TAG_email);

                HashMap<String, String> persons = new HashMap<String, String>();

                persons.put(TAG_REVIEW, review);
                persons.put(TAG_HOTEL, hotel_name);
                persons.put(TAG_email, email);

                personList.add(persons);
            }
            ListAdapter adapter = new SimpleAdapter(
                    ShowReview.this, personList, R.layout.review_list,
                    new String[]{TAG_REVIEW, TAG_HOTEL,TAG_email},
                    new int[]{R.id.review, R.id.hotel_name,R.id.tvemail});

            list.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void getData() {
        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {
                DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
                HttpPost httppost = new HttpPost("http://dargalaxy.com/VolleyUpload/fetch5.php");

                // Depends on your web service
                httppost.setHeader("Content-type", "application/json");

                InputStream inputStream = null;
                String result = null;
                try {
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();

                    inputStream = entity.getContent();
                    // json is UTF-8 by default
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (Exception e) {
                    // Oops
                } finally {
                    try {
                        if (inputStream != null) inputStream.close();
                    } catch (Exception squish) {
                    }
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result) {
                myJSON = result;
                showList();
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
    }
    public void onBackPressed()
    {
        Intent j=new Intent(ShowReview.this,WriteReviewActivity.class);
        startActivity(j);
    }
}

