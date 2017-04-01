
package infotech.hackathon;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RegisterUser extends Activity implements View.OnClickListener {

    private Button btnRegister;
    private Button btnLinkToLoginScreen;
    ProgressDialog pd;
    JSONParser jsonparser;
    String url;
    EditText phone;
    EditText name;
    EditText email;
    EditText password;
    EditText username;
String myname,myusername,myemail,myphone,mypassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        name = (EditText) findViewById(R.id.name);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
        btnRegister = (Button) findViewById(R.id.btn_register);
        btnLinkToLoginScreen = (Button) findViewById(R.id.btnLinkToLoginScreen);

        btnRegister.setOnClickListener(this);
        btnLinkToLoginScreen.setOnClickListener(this);
        jsonparser = new JSONParser();
        url = "http://192.168.43.112/Hackathon/Register.php";
}
    @Override
    public void onClick(View v) {
        if (v == btnRegister) {
            myname = name.getText().toString();
            myusername = username.getText().toString();
            myemail = email.getText().toString();
            myphone = phone.getText().toString();
            mypassword = password.getText().toString();
      if(validateEmail()==true && validateName()==true && validatePhone()==true ) {
          new Jadu().execute();
      Intent intent=new Intent(RegisterUser.this,MainActivity.class);
          startActivity(intent);
      }
            else{
          Toast.makeText(this, "Invalid Details", Toast.LENGTH_SHORT).show();
      }
        } else if (v == btnLinkToLoginScreen) {
       Intent intent=new Intent(RegisterUser.this,LoginActivity.class);
            startActivity(intent);
        }
    }

    public class Jadu extends AsyncTask<String, String, String> {


        @Override


        protected String doInBackground(String... arg0) {


            List<NameValuePair> parms = new ArrayList<NameValuePair>();
            parms.add(new BasicNameValuePair("myname", myname));
            parms.add(new BasicNameValuePair("myusername", myusername));
            parms.add(new BasicNameValuePair("myemail", myemail));
            parms.add(new BasicNameValuePair("myphone", myphone));
            parms.add(new BasicNameValuePair("mypassword", mypassword));
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


        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            pd = new ProgressDialog(RegisterUser.this);
            pd.setMessage("Registering ...");
            pd.show();
        }
    }

    private boolean validateEmail() {


        if (email.getText().toString().isEmpty() || !isValidEmail(email.getText().toString()))
        {
            return false;
        } else
        {
        return true;
        }
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    private boolean validateName() {
        if (name.getText().toString().isEmpty()) {
            return false;
        } else {
              return true;
        }
    }
    private boolean validatePhone() {
        if ( phone.length()==10) {
            return true;
        } else {
            return false;
        }
}
}