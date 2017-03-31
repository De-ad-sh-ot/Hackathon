package infotech.hackathon;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RegisterUser extends AppCompatActivity {
    private EditText name;
    private EditText username;
    private EditText email;
    private EditText phone;
    private EditText password;
    private Button btnRegister;
    private Button btnLinkToLoginScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register_user);

        name = (EditText) findViewById(R.id.name);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLinkToLoginScreen = (Button) findViewById(R.id.btnLinkToLoginScreen);


        btnRegister.setOnClickListener(this);
        btnLinkToLoginScreen.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if ( v == btnRegister ) {
            // Handle clicks for btnRegister
        } else if ( v == btnLinkToLoginScreen ) {
            // Handle clicks for btnLinkToLoginScreen
        }
    }

        public class Jadu extends AsyncTask<String, String, String> {


        @Override


        protected String doInBackground(String... arg0) {


            List<NameValuePair> parms = new ArrayList<NameValuePair>();
            parms.add(new BasicNameValuePair("name", name));
            parms.add(new BasicNameValuePair("phone", phone));
            parms.add(new BasicNameValuePair("password", password));
            parms.add(new BasicNameValuePair("confirm", confirm));
            parms.add(new BasicNameValuePair("email", email));
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
            sessionlog();
            pd.dismiss();


        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            pd = new ProgressDialog(signup.this);
            pd.setMessage("SAVING DATA");
            pd.show();
        }
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private boolean validateName() {
        if (et_name.getText().toString().isEmpty()) {
            inputlayoutname.setError("Enter Your Full Name");
            requestFocus(et_name);

            return false;
        } else {
            inputlayoutname.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateEmail() {


        if (et_email.getText().toString().isEmpty() || !isValidEmail(et_email.getText().toString())) {
            inputlayoutemail.setError("Enter valid email address");
            requestFocus(et_email);

            return false;
        } else {
            inputlayoutemail.setErrorEnabled(false);
        }


        return true;
    }

    private boolean validatePassword() {
        if (et_pass.getText().toString().isEmpty()) {
            inputlayoutpass.setError("Password");
            requestFocus(et_pass);

            return false;
        } else {
            inputlayoutpass.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateconfirmPassword() {

        if (et_pass.getText().toString().equals(et_cpass.getText().toString())) {

            inputlayoutconfirm.setError("Password Matched");
            return true;
        } else {
            inputlayoutconfirm.setErrorEnabled(false);
            inputlayoutconfirm.setError("Password not matched");
            return false;
        }
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.et_name:
                    validateName();
                    break;
                case R.id.et_email:
                    validateEmail();
                    break;
                case R.id.et_pass:
                    validatePassword();
                    break;
                case R.id.et_cpass:
                    validateconfirmPassword();
                    break;
            }
        }
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }

    public void setupUI(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(signup.this);
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }

    public Boolean check() {
        if (et_name.getText().toString().isEmpty() || et_phone.getText().toString().isEmpty() || et_pass.getText().toString().isEmpty() || et_cpass.getText().toString().isEmpty() || et_email.getText().toString().isEmpty()) {
            Toast.makeText(signup.this, " fields are empty", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            if (et_phone.getText().toString().isEmpty() || et_phone.getText().toString().length() != 10 ) {
                Toast.makeText(getApplicationContext(), "Phone Number Not Valid", Toast.LENGTH_LONG).show();
                return false;
            }  else {

                if (validateEmail() && validateconfirmPassword()) {
                    Toast.makeText(getApplicationContext(), "DATA SAVED", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(signup.this, MainNav.class);
                    startActivity(i);
                    return true;
                } else {
                    Toast.makeText(getApplicationContext(), "Password not matched", Toast.LENGTH_LONG).show();
                    return false;
                }
            }
        }
    }

           }




