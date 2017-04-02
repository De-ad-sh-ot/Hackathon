package infotech.hackathon;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import infotech.hackathon.login.BaseActivity;
import infotech.hackathon.login.SignInActivity;
import infotech.hackathon.login.SignUpActivity;
import infotech.hackathon.login.UserProfile;

public class ContactUs extends BaseActivity {
Button btnsubmit;
    private FirebaseAuth auth;
    private DatabaseReference mDatabase;

    EditText et_name,et_query,et_contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        auth = FirebaseAuth.getInstance();
       btnsubmit = (Button) findViewById(R.id.btnsubmit);
        et_name = (EditText)findViewById( R.id.et_name );
        et_contact = (EditText)findViewById( R.id.et_contact );
        et_query = (EditText)findViewById( R.id.et_query);



        mDatabase = FirebaseDatabase.getInstance().getReference();

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stName = et_name.getText().toString().trim();
                String stCompanyName = et_query.getText().toString().trim();
                String stContactNo = et_contact.getText().toString().trim();

                
                if (TextUtils.isEmpty(stName)) {
                    Toast.makeText(getApplicationContext(), "Enter name!", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(stCompanyName)) {
                    Toast.makeText(getApplicationContext(), "Enter query!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(stContactNo)) {
                    Toast.makeText(getApplicationContext(), "Enter contact no.!", Toast.LENGTH_SHORT).show();
                    return;
                }


                if(!isInternetAvailable(ContactUs.this)){
                    return;
                }
                showProgressDialog();

                final UserProfile userProfile = new UserProfile();

                userProfile.setUsername(stName);
                userProfile.setName(stCompanyName);
                userProfile.setMobileNo(stContactNo);
                
                auth.createUserWithEmailAndPassword(stName,stCompanyName )
                        .addOnCompleteListener(ContactUs.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                Toast.makeText(SignUpActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    hideProgressDialog();
                                    Toast.makeText(ContactUs.this, "Authentication failed." + task.getException(),
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
                                        startActivity(new Intent(ContactUs.this, MainActivity.class));
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