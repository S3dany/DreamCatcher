package com.tosp.dreamcatcher;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    EditText username, email, password, confirmPassword;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email =  findViewById(R.id.emailEditText);
        username = findViewById(R.id.usernameEditText);
        password  =  findViewById(R.id.passwordEditText);
        confirmPassword =  findViewById(R.id.confirmPWeditText);
        mAuth = FirebaseAuth.getInstance();


        //User signed in
        if (mAuth.getCurrentUser() != null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void signUpClicked(View view){
        //Sign up
        mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String user_id = mAuth.getCurrentUser().getUid();
                    DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id);

                    String new_email = email.getText().toString();
                    String new_username = username.getText().toString();

                    Map newUser = new HashMap();
                    newUser.put("email", new_email);
                    newUser.put("username", new_username);

                    current_user_db.setValue(newUser);

                    Toast.makeText(RegisterActivity.this, "Sign up successful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);

                } else {
                    Log.w("ERROR-----------ERROR", task.getException());
                    Toast.makeText(RegisterActivity.this, "Sign up failed. Try Again", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void signInTextViewClicked(View view){
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}