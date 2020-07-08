package com.example.runrun;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EntryActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mDatabase;


    private EditText KTemail;
    private EditText KTpassword;

    private TextView TV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        mAuth = FirebaseAuth.getInstance();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){

                } else {

                }
            }
        };

        KTemail = (EditText) findViewById(R.id.et_email);
        KTpassword = (EditText) findViewById(R.id.et_password);

        findViewById(R.id.btn_sign_in).setOnClickListener(this);
        findViewById(R.id.btn_registration).setOnClickListener(this);

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_sign_in) {
            signin(KTemail.getText().toString(), KTpassword.getText().toString());
        } else if (v.getId() == R.id.btn_registration) {
            registration(KTemail.getText().toString(), KTpassword.getText().toString());
        }
    }

    public void signin(String email, String password) {
        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(EntryActivity.this, "Авторизация успешна", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(EntryActivity.this, MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            } else
                                Toast.makeText(EntryActivity.this, "Авторизация не успешна", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

    public  void registration(final String email, final String password){
        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                String user_id = mAuth.getCurrentUser().getUid();
                                DatabaseReference current_user_db = mDatabase.child(user_id);
                                current_user_db.child("email").setValue(email);
                                current_user_db.child("plan").setValue("no");
                                Toast.makeText(EntryActivity.this, "Регистрация успешна", Toast.LENGTH_SHORT).show();
                            } else
                                Toast.makeText(EntryActivity.this, "Регистрация не успешна", Toast.LENGTH_SHORT).show();
                        }
                    });

        }
    }
}

