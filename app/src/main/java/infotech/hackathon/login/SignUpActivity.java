package infotech.hackathon.login;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.blankj.utilcode.utils.RegexUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import infotech.hackathon.MainActivity;
import infotech.hackathon.R;

public class SignUpActivity extends BaseActivity {

    private EditText inputEmail, inputPassword;
    private Button btnSignIn, btnSignUp;
    private FirebaseAuth auth;
    private DatabaseReference mDatabase;

    private EditText username;
    private EditText name;
    private EditText contactNo;
    private RadioButton guideradiobutton;
    private RadioButton userradiobutton;
    int userType;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup1);
        btnSignIn = (Button) findViewById(R.id.btn_sign_in);
        btnSignUp = (Button) findViewById(R.id.btn_register);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        guideradiobutton = (RadioButton) findViewById(R.id.radiobuttonguide);
        userradiobutton = (RadioButton) findViewById(R.id.radiobuttonuser);
        username = (EditText)findViewById( R.id.username );
        name = (EditText)findViewById( R.id.name );
        contactNo = (EditText)findViewById( R.id.phone );
//usertype 1 guide



        mDatabase = FirebaseDatabase.getInstance().getReference();

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent i=new Intent(SignUpActivity.this,SignInActivity.class);
                startActivity(i);
                finish();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radiobuttonguide:
                        userType=1;
                        break;
                    case R.id.radiobuttonuser:
                        userType=2;
                        break;

                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                String stName = username.getText().toString().trim();
                String stCompanyName = name.getText().toString().trim();
                String stContactNo = contactNo.getText().toString().trim();

                if (!RegexUtils.isEmail(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(stName)) {
                    Toast.makeText(getApplicationContext(), "Enter name!", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(stCompanyName)) {
                    Toast.makeText(getApplicationContext(), "Enter company name!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(stContactNo)) {
                    Toast.makeText(getApplicationContext(), "Enter contact no.!", Toast.LENGTH_SHORT).show();
                    return;
                }


                if(!isInternetAvailable(SignUpActivity.this)){
                    return;
                }

                showProgressDialog();

                final UserProfile userProfile = new UserProfile();

                userProfile.setUsername(stName);
                userProfile.setEmail(email);
                userProfile.setName(stCompanyName);
                userProfile.setMobileNo(stContactNo);
                userProfile.setUserType(userType);

    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                Toast.makeText(SignUpActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    hideProgressDialog();
                                    Toast.makeText(SignUpActivity.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    getUserDetails(auth, userProfile);
                                }
                            }
                        });

            }
        });
    }

    public void getUserDetails(FirebaseAuth auth, final UserProfile userProfile) {

        auth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull final FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    String mUserId = user.getUid();

                    mDatabase.child("users").child(mUserId).child("userProfile").setValue(userProfile)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    hideProgressDialog();
                                    if(task.isSuccessful()){
                                        startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                                        finish();
                                        Log.i("AuthStateChanged", "User is signed in with uid: " + user.getUid());

                                        // The user's ID, unique to the Firebase project. Do NOT use this value to
                                        // authenticate with your backend server, if you have one. Use
                                        // FirebaseUser.getToken() instead.
                                    }else {
                                    }
                                }
                            });



                } else {
                    Log.i("AuthStateChanged", "No user is signed in.");
                    hideProgressDialog();
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        hideProgressDialog();
    }

}