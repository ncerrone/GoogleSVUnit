package com.example.googlesvunit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{

    public EditText editTextUser;
    public EditText editTextPassword;
    public Button confirmLogin;
    public Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUser = findViewById(R.id.editTextUser);
        editTextPassword = findViewById(R.id.editTextPassword);

        confirmLogin = findViewById(R.id.buttonConfirmLogin);
        register = findViewById(R.id.buttonRegister);

        /*confirmLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do login
            }
        });*/

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterActivity();
            }
        });


    }

    public void openRegisterActivity(){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);

        //Intent intent = new Intent(this, SignUpActivity.class);
        //startActivity(intent);
    }

}
