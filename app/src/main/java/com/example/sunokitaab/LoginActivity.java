package com.example.sunokitaab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.sunokitaab.MESSAGE email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void forgotPass() {
        Intent intent = new Intent(this, ForgotPasswordActivity.class);
        EditText editText = (EditText) findViewById(R.id.user_email);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void signUp() {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

}
