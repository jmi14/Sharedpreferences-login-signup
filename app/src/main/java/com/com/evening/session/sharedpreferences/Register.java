package com.com.evening.session.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hpfolio.classcodes.R;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    private EditText etName, etEmail, etPassword, etConfirmPassword;
    private Button btnRegister;
    private SharedPreferences sharedPreferences;
    private TextView tvLinkForLogin;
    private String nameInput, emailInput, passwordInput, confirmPasswordInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initializeWidgets();
        initialize();

    }

    public void initializeWidgets() {

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
        tvLinkForLogin = (TextView) findViewById(R.id.tvLinkForLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);


    }

    public void initialize() {
        tvLinkForLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emailInput = etEmail.getText().toString();
                nameInput = etName.getText().toString();
                passwordInput = etPassword.getText().toString();
                confirmPasswordInput = etConfirmPassword.getText().toString();

                if (isAllFieldsFilled(nameInput, emailInput, passwordInput, confirmPasswordInput)) {
                    if (isEmailValid(emailInput)) {
                        if (isPasswordMatches(passwordInput, confirmPasswordInput)) {
                            sharedPreferences = getSharedPreferences("com.com.evening.session.sharedpreferences", Context.MODE_PRIVATE);
                            sharedPreferences.edit().putString("name", etName.getText().toString()).apply();
                            sharedPreferences.edit().putString("email", etEmail.getText().toString()).apply();
                            sharedPreferences.edit().putString("password", etPassword.getText().toString()).apply();
                            sharedPreferences.edit().putString("confirm password", etConfirmPassword.getText().toString()).apply();
                            Toast.makeText(Register.this, "Data inserted", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(Register.this, "Please enter correct password", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Register.this, "Please enter correct email address", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(Register.this, "Please enter your all information", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    public boolean isEmailValid(String email) {

        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

            return true;
        } else {
            return false;
        }
    }

    public boolean isAllFieldsFilled(String name, String email, String password, String confirmPassword) {

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isPasswordMatches(String password, String confirmPassword) {

        if (password.equals(confirmPassword)) {

            return true;

        } else {

            return false;
        }

    }
}






