package com.example.soc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.soc.models.UserDto;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String BASE_URL = "http://192.168.31.107:5002/api";
    EditText emailTextField;
    EditText passwordTextField;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailTextField = findViewById(R.id.emailTextField);
        linearLayout = findViewById(R.id.linearLayout);
        passwordTextField = findViewById(R.id.passwordTextField);
    }

    public void onTapLogin(View view) {
        String email = emailTextField.getText().toString();
        String password = passwordTextField.getText().toString();

        if (!isValidEmail(email)) {
            UserDto user = new UserDto(email, password, email, password);
            Gson gson = new Gson();
            String userData = gson.toJson(user);

            HTTP h = new HTTP(new HTTP.OnRequestCompletedListener() {
                @Override
                public void onRequestCompleted(String response) {
                    Log.e(TAG, "Response: " + response);
                    Token t = new Token();
                    t.setToken(response);
                    Snackbar.make(linearLayout, "Запрос успешно выполнен", Snackbar.LENGTH_SHORT).show();
                }

                @Override
                public void onRequestError(Exception e) {
                    Log.e(TAG, "Error: " + e.toString());
                    Snackbar.make(linearLayout, "Произошла ошибка: " + e.getMessage(), Snackbar.LENGTH_LONG).show();
                }
            });

            h.makeHttpRequestInBackground(BASE_URL + "/auth/login", userData);
        }
    }

    public void onTapRegister(View view) {
        Intent intent = new Intent(this, RegisterScreen.class);
        startActivity(intent);
    }

    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private class Token {
        private String TokenKey = "com.example.app.token";
        private SharedPreferences sharedPref;
        private String token;
        private String tokenType = "Bearer";
        private String result = tokenType + " " + token;

        public Token() {
            sharedPref = getApplication().getSharedPreferences(TokenKey, Context.MODE_PRIVATE);
            result = sharedPref.getString(TokenKey, "");
        }

        public void setToken(String token) {
            this.token = token;
            sharedPref.edit().putString(TokenKey, getResult()).apply();
        }

        public String getResult() {
            return result;
        }
    }
}
