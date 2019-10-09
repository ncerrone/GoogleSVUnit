package com.example.googlesvunit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    public EditText editTextUser;
    public EditText editTextPassword;
    public Button confirmReigster;
    public Button login;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Intent intent = getIntent();

        editTextUser = findViewById(R.id.editTextUser);
        editTextPassword = findViewById(R.id.editTextPassword);

        confirmReigster = findViewById(R.id.buttonConfirmLogin);
        login = findViewById(R.id.buttonRegister);

        mAuth = FirebaseAuth.getInstance();



        confirmReigster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void registerUser(){
        String username = editTextUser.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(username.isEmpty()){
            editTextUser.setError("Email username required");
            editTextUser.requestFocus();
            return;
        }

        if(Patterns.EMAIL_ADDRESS.matcher(username).matches()){
            editTextUser.setError("Email username invalid");
            editTextUser.requestFocus();
            return;
        }

        if(password.isEmpty()){
            editTextPassword.setError("Password username required");
            editTextPassword.requestFocus();
            return;
        }

        if(password.length()<6){
            editTextPassword.setError("Password username too short");
            editTextPassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "User registered Successfull", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
