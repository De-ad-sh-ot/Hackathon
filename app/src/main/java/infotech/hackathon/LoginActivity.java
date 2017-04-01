package infotech.hackathon;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.AsyncTask;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class LoginActivity extends AppCompatActivity  {

    String myJSON;
    private static final String TAG_RESULTS = "result";

    private static final String TAG_email = "email";//here username and password we are getting from the server...
    private static final String TAG_password = "password";


    JSONArray peoples = null;


    ArrayList<HashMap<String, String>> personList;

    JSONParser jsonparser;
    String url;
    private EditText email;
ProgressDialog pd;
    private Button btnlogin;
    private Button btnreg;
 EditText password;

    String myemail,mypassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        btnlogin = (Button) findViewById(R.id.btn_login);
        jsonparser = new JSONParser();
        url = "http://192.168.43.112/Hackathon/Login.php";
        btnreg = (Button) findViewById(R.id.btnLinkToRegisterScreen);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Jadu().execute();
                myemail = email.getText().toString();
                mypassword = password.getText().toString();
                           }
        });

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this,RegisterUser.class);
                startActivity(i);
            }
        });
    }
//
//    protected void showList() {
//        try {
//            JSONObject jsonObj = new JSONObject(myJSON);
//            peoples = jsonObj.getJSONArray(TAG_RESULTS);
//            if (email.getText().toString() != null && password.getText().toString() != null) {
//
//                for (int i = 0; i < peoples.length(); i++) {
//                    JSONObject c = peoples.getJSONObject(i);
//                   String myemail = c.getString(TAG_email);
//                  String  mypassword = c.getString(TAG_password);
//
//                    if (email.getText().toString().equals(myemail) && password.getText().toString().equals(mypassword)) {
//                        Intent k=new Intent(LoginActivity.this,MainActivity.class);
//                        startActivity(k);
//                    }
//
//
//                }
//
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }}
//
//    public void getData() {
//        class GetDataJSON extends AsyncTask<String, Void, String> {
//
//            @Override
//            protected String doInBackground(String... params) {
//                DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
//                HttpPost httppost = new HttpPost("http://192.168.43.112/Hackathon/login1.php");
//
//                // Depends on your web service
//                httppost.setHeader("Content-type", "application/json");
//
//                InputStream inputStream = null;
//                String result = null;
//                try {
//                    HttpResponse response = httpclient.execute(httppost);
//                    HttpEntity entity = response.getEntity();
//
//                    inputStream = entity.getContent();
//                    // json is UTF-8 by default
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
//                    StringBuilder sb = new StringBuilder();
//
//                    String line = null;
//                    while ((line = reader.readLine()) != null) {
//                        sb.append(line + "\n");
//                    }
//                    result = sb.toString();
//                } catch (Exception e) {
//                    // Oops
//                } finally {
//                    try {
//                        if (inputStream != null) inputStream.close();
//                    } catch (Exception squish) {
//                    }
//                }
//                return result;
//            }
//
//            @Override
//            protected void onPostExecute(String result) {
//                myJSON = result;
//                showList();
//            }
//        }
//        GetDataJSON g = new GetDataJSON();
//        g.execute();
//    }

    public class Jadu extends AsyncTask<Object, Object, JSONObject> {


        @Override


        protected JSONObject doInBackground(Object... arg0) {

            JSONObject data = null;
            List<NameValuePair> parms = new ArrayList<NameValuePair>();
            parms.add(new BasicNameValuePair("myemail", myemail));
            parms.add(new BasicNameValuePair("mypassword", mypassword));
            JSONObject obj = jsonparser.makeHttpRequest(url, "POST", parms);
            Log.d("CREATE REPONSE", obj.toString());
            try {

                String success =
                        obj
                            .getJSONObject("result")
                            .getJSONObject("status")
                            .getString("success");

                if(success.equalsIgnoreCase("success")){
                    data = obj
                        .getJSONObject("result")
                        .getJSONObject("data");

                }else {
                    data = obj
                        .getJSONObject("result");
                }

            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return data;
        }

        @Override
        protected void onPostExecute(JSONObject result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);

            pd.dismiss();

            try {
                if(result != null && !result.getString("status").equalsIgnoreCase("failure") ) {
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(getApplicationContext(), "Login unsuccessful", Toast.LENGTH_LONG);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }



        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            pd = new ProgressDialog(LoginActivity.this);
            pd.setMessage("Loading...");
            pd.show();
        }
    }


    }


