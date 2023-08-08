package com.example.soc;

import static java.lang.System.out;

import androidx.annotation.NonNull;
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

import com.example.soc.models.User;
import com.example.soc.models.UserDto;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private  static  String url ="http://192.168.31.107:5002/api";
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



    public void onTapLogin(View view){
        String email = emailTextField.getText().toString();
        String password = passwordTextField.getText().toString();
        try {
            /*if(!isValidEmail(emailTextField.toString())){*/
                /*Intent intent = new Intent(this, HomeScreen.class);
                startActivity(intent);*/
                UserDto user = new UserDto(email,password);
                Gson gson = new Gson();
                String userData = gson.toJson(user);

                HTTP h = new HTTP();
                h.makeHttpRequestInBackground(url + "/auth/login", userData, new HTTP.OnRequestCompletedListener() {
                    @Override
                    public void onRequestCompleted(String response) {
                        Log.e("Response",response);
                        Token t= new Token();
                        t.setToken(response);


                    }

                    @Override
                    public void onRequestError(Exception e) {
                        Log.e("error",e.toString());
                    }
                });

           /* }*/
        }
        catch (Error e){
            Log.e("Error",e.toString());
            Snackbar snackbar = Snackbar.make(linearLayout,"Что то пошло не так!", Snackbar.LENGTH_INDEFINITE);
            snackbar.show();

        }

    }

    public void onTapRegister(View view){
        Intent intent = new Intent(this, RegisterScreen.class);
        startActivity(intent);
    }

    //валидация почты
    private boolean isValidEmail(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    // Deserialize JSON data into a Java class using Gson
    private  <T> T deserializeJson(String jsonData, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(jsonData, clazz);
    }
    public  class  Token{
        private  String TokenKey = "com.example.app.token";
        private  SharedPreferences sharedPref;
        private  String token;
        private  String tokenType="Berear";
        private  String result=tokenType+" "+token;
        public  Token(){
            result=sharedPref.getString(TokenKey,"");
             sharedPref = getApplication().getSharedPreferences(
                    TokenKey, Context.MODE_PRIVATE);
        }

        public String getResult() {
            return result;
        }

        public void setToken(String token) {

            this.token = token;
            sharedPref.edit().putString(TokenKey,getResult());
        }
    }
}