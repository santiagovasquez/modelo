package info.androidhive.olarteEsteematorlite.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.mobsandgeeks.saripaar.Rule;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Required;
import com.mobsandgeeks.saripaar.annotation.TextRule;

import java.util.HashMap;
import java.util.Map;

import info.androidhive.olarteEsteematorlite.Config.Config;
import info.androidhive.olarteEsteematorlite.R;

public class RegisterActivity extends AppCompatActivity implements Validator.ValidationListener{

    Button mSave;
    FirebaseAuth mAuth;
    Firebase users;
    FirebaseAuth.AuthStateListener mAuthListener;

    protected Validator validator;
    protected boolean validated;

    @Required(order = 1,messageResId = R.string.name_required)
    @TextRule(order = 2,minLength = 4,messageResId = R.string.min_4_caracteres )
    private EditText mName;

    @Required(order = 3,messageResId = R.string.pais_required)
    @TextRule(order = 4,minLength = 4,messageResId = R.string.min_4_caracteres)
    private EditText mCountry;

    @Required(order = 5,messageResId = R.string.email_invald)
    @Email(order =6,messageResId = R.string.email_invald)
    private EditText mEmail;

    @Required(order = 7,messageResId = R.string.password_required)
    @TextRule(order = 8,minLength = 6,messageResId = R.string.min_6_carateres)
    private EditText mPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth=FirebaseAuth.getInstance();
        setTitle(R.string.register);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                } else {
                }
            }
        };
        setContentView(R.layout.activity_register);
        iniciarVariables();
    }

    private void iniciarVariables() {
        validator = new Validator(this);
        validator.setValidationListener(this);
        mName=(EditText) findViewById(R.id.name);
        mName.findFocus();
        mCountry=(EditText) findViewById(R.id.country);
        mEmail=(EditText) findViewById(R.id.email);
        mPassword=(EditText) findViewById(R.id.password);
        mSave=(Button) findViewById(R.id.btnsave);
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validator.validate();
            }
        });

        compruebaConexion(this);
        if (!compruebaConexion(this)) {
            Toast.makeText(this,R.string.sin_internet, Toast.LENGTH_SHORT).show();
        }

    }

    public static boolean compruebaConexion(Context context) {
        boolean connected = false;
        ConnectivityManager connec = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // Recupera todas las redes (tanto móviles como wifi)
        NetworkInfo[] redes = connec.getAllNetworkInfo();
        for (int i = 0; i < redes.length; i++) {
            // Si alguna red tiene conexión, se devuelve true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                connected = true;
            }
        }
        return connected;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onValidationSucceeded() {
        validated= true;
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Toast.makeText(RegisterActivity.this, R.string.email_exist, Toast.LENGTH_SHORT).show();
                            }


                        }else{
                            Config config = new Config();
                            //Guardar usuario registrado
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            users = new Firebase(config.getFirebaseURL()).child("Users").child(user.getUid().toString());
                            Map<String, Object> userData = new HashMap<String, Object>();

                            userData.put("name", mName.getText().toString());
                            userData.put("country", mCountry.getText().toString());
                            userData.put("email", mEmail.getText().toString());
                            userData.put("uid", user.getUid().toString());
                            users.setValue(userData);
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            intent.putExtra("name", mName.getText().toString());
                            intent.putExtra("country", mCountry.getText().toString());
                            intent.putExtra("email", mEmail.getText().toString());
                            intent.putExtra("uid", user.getUid().toString());
                            Toast.makeText(RegisterActivity.this, R.string.save_user,
                                    Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }
                        // ...
                    }
                });
    }

    @Override
    public void onValidationFailed(View failedView, Rule<?> failedRule) {
        final String failureMessage = failedRule.getFailureMessage();
        if (failedView instanceof EditText) {
            EditText failed = (EditText) failedView;
            failed.requestFocus();
            failed.setError(failureMessage);
        }else{
            Toast.makeText(getApplicationContext(), failureMessage, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
