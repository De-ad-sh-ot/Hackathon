package infotech.hackathon;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WriteReviewActivity extends AppCompatActivity {
    String review;
    String hotel_name;
    ProgressDialog pd;
    JSONParser jsonparser;
    String url;


    private EditText et_review;

    private Button btn_review;

    private TextView et_hotelname;


    ArrayList<String> listItems=new ArrayList<>();
    ArrayAdapter<String> adapter;
    Spinner spinner;
    private TextView tvuserinfo;
    private String code;

    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("REVIEW");
        setContentView(R.layout.activity_write_review);
        spinner=(Spinner)findViewById(R.id.spinner);
        adapter=new ArrayAdapter<String>(this,R.layout.spinner_layout,R.id.txt,listItems);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinner.setSelection(i);
                String e= (String) spinner.getSelectedItem();
                et_hotelname.setText(e);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        et_review = (EditText) findViewById(R.id.et_review);
        btn_review = (Button) findViewById(R.id.btn_review);
        tvuserinfo = (TextView) findViewById(R.id.tvuserinfo);
        Intent i=getIntent();
        code = i.getStringExtra("userinformation");
        tvuserinfo.setText(code);
        et_hotelname=(TextView) findViewById(R.id.et_hotelname);

        jsonparser = new JSONParser();

        url = "http://dargalaxy.com/VolleyUpload/review.php";


        btn_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                review = et_review.getText().toString();

                hotel_name = et_hotelname.getText().toString();
                if(review.isEmpty()){
                    Toast.makeText(WriteReviewActivity.this, "Please enter Something", Toast.LENGTH_LONG).show();
                }
                else {

                    new Jadu().execute();//creating object of jadu class and calling the executing method....

                    Intent i = new Intent(WriteReviewActivity.this, ShowReview.class);
                    startActivity(i);


                }
            }
        });

    }

    public void onStart(){
        super.onStart();
        BackTask bt=new BackTask();
        bt.execute();
    }
    private class BackTask extends AsyncTask<Void,Void,Void> {
        ArrayList<String> list;
        protected void onPreExecute(){
            super.onPreExecute();
            list=new ArrayList<>();
        }
        protected Void doInBackground(Void...params){
            InputStream is=null;
            String result="";
            try{
                HttpClient httpclient=new DefaultHttpClient();
                HttpPost httppost= new HttpPost("http://dargalaxy.com/VolleyUpload/hotel.php");
                HttpResponse response=httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                // Get our response as a String.
                is = entity.getContent();
            }catch(IOException e){
                e.printStackTrace();
            }

            //convert response to string
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(is,"utf-8"));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    result+=line;
                }
                is.close();
                //result=sb.toString();
            }catch(Exception e){
                e.printStackTrace();
            }
            // parse json data
            try{
                JSONArray jArray =new JSONArray(result);
                for(int i=0;i<jArray.length();i++){
                    JSONObject jsonObject=jArray.getJSONObject(i);
                    // add interviewee name to arraylist
                    list.add(jsonObject.getString("hotel_name"));
                }
            }
            catch(JSONException e){
                e.printStackTrace();
            }
            return null;
        }
        protected void onPostExecute(Void result){
            listItems.addAll(list);
            adapter.notifyDataSetChanged();
        }
    }
    public class Jadu extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... arg0) {

            List<NameValuePair> parms = new ArrayList<NameValuePair>();
            parms.add(new BasicNameValuePair("review", review));
            parms.add(new BasicNameValuePair("hotel_name", hotel_name));
            parms.add(new BasicNameValuePair("email", code));

            JSONObject obj = jsonparser.makeHttpRequest(url, "POST", parms);
            Log.d("CREATE REPONSE", obj.toString());
            try {
                int success = obj.getInt("TAG SUCCESSFULLY");

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            pd.dismiss();
            // et.setText("");
            Toast.makeText(getApplicationContext(), "DATA SAVED", Toast.LENGTH_LONG).show();

        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            pd = new ProgressDialog(WriteReviewActivity.this);
            pd.setMessage("SAVING DATA");
            pd.show();
        }
    }
    public void onBackPressed()
    {

        Intent j=new Intent(WriteReviewActivity.this,MainActivity.class);
        startActivity(j);
    }
}


