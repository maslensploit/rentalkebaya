package com.example.rentalkebaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class registerActivity extends AppCompatActivity {
    TextInputEditText textInputEditFullName, textInputEditEmail, textinputUsername, textInputPassword;
    Button buttonSignup;
    TextView textViewLogin;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textInputEditFullName= findViewById(R.id.fullname);
        textInputEditEmail = findViewById(R.id.email);
        textinputUsername = findViewById(R.id.username);
        textInputPassword = findViewById(R.id.password);
        buttonSignup = findViewById(R.id.buttonSignUp);
        textViewLogin = findViewById(R.id.loginText);
        progressBar = findViewById(R.id.progress);

        textViewLogin.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), loginActivity.class);
            startActivity(intent);
            finish();
        });


        buttonSignup.setOnClickListener(v -> {
            final String fullname, email, username, password;
            fullname = String.valueOf(textInputEditFullName.getText());
            email = String.valueOf(textInputEditEmail.getText());
            username = String.valueOf(textinputUsername.getText());
            password = String.valueOf(textInputPassword.getText());

            if(!fullname.equals("") && !email.equals("") && !username.equals("") && !password.equals("")) {
                progressBar.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        String[] field = new String[4];
                        field[0] = "fullname";
                        field[1] = "username";
                        field[2] = "password";
                        field[3] = "email";

                        //Creating array for data
                        String[] data = new String[4];
                        data[0] = fullname;
                        data[1] = username;
                        data[2] = password;
                        data[3] = email;
                        PutData putData = new PutData("http://192.168.1.11/AGPakTo/LoginRegister/signup.php", "POST", field, data);
                        if (putData.startPut()) {
                            Intent intent1 = new Intent(registerActivity.this, loginActivity.class);
                            startActivity(intent1);
                            finish();
                            if (putData.onComplete()) {
                                progressBar.setVisibility(View.GONE);
                                String result = putData.getResult();
                                if (result.equals("Sign up Succes")) {
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                });
            }
            else {
                Toast.makeText(getApplicationContext(), "All fields required", Toast.LENGTH_SHORT).show();
            }
        });


    }
}