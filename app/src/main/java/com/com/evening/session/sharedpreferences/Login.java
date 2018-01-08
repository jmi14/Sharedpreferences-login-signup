package com.com.evening.session.sharedpreferences;

import android.content.Context;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hpfolio.classcodes.R;

public class Login extends AppCompatActivity {


    private EditText etEmail, etPassword;
    private Button btnLogin;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeWidgets();
        initialize();
    }

    public void initializeWidgets() {

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btn_Login);

    }

    public void initialize() {
        sharedPreferences = getSharedPreferences("com.com.evening.session.sharedpreferences", Context.MODE_PRIVATE);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final String email = sharedPreferences.getString("email", "");
                final String pass = sharedPreferences.getString("password", "");
                if (etEmail.getText().toString().equals(email) & etPassword.getText().toString().equals(pass)) {

                    Toast.makeText(getApplicationContext(), "login ", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}

