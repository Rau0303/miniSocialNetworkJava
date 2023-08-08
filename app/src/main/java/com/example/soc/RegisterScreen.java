package com.example.soc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.soc.HomeScreen;
import com.example.soc.MainActivity;
import com.example.soc.models.UserDto;
import com.example.soc.HTTP;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import java.io.IOException;

public class RegisterScreen extends AppCompatActivity {
    private static final String url = "http://192.168.31.107:5002/api"; // Поменяйте на свой URL
    EditText usernameTextField;
    EditText emailTextField;
    EditText passwordTextField;
    EditText rePasswordTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        usernameTextField = findViewById(R.id.usernameTextField);
        emailTextField = findViewById(R.id.emailTextField);
        passwordTextField = findViewById(R.id.passwordTextField);
        rePasswordTextField = findViewById(R.id.rePasswordTextField);
    }

    public void onTapRegister(View view) {
        String username = usernameTextField.getText().toString();
        String email = emailTextField.getText().toString();
        String password = passwordTextField.getText().toString();
        String repeatPassword = rePasswordTextField.getText().toString();


        if (!checkPasswordEquality(password, repeatPassword)) {
            Snackbar.make(view, "Пароли не совпадают", Snackbar.LENGTH_SHORT).show();
            return;
        }

        UserDto user = new UserDto(username, password, email);
        Gson gson = new Gson();
        String userData = gson.toJson(user);

        HTTP h = new HTTP();
        h.makeHttpRequestInBackground(url + "/auth/register", userData, new HTTP.OnRequestCompletedListener() {
            @Override
            public void onRequestCompleted(String response) {
                // тут еще не дописал
                Intent intent = new Intent(RegisterScreen.this, HomeScreen.class);
                startActivity(intent);
            }

            @Override
            public void onRequestError(Exception e) {
                Snackbar.make(view, "Ошибка регистрации", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    public void onTapLogin(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private boolean checkPasswordEquality(String password, String repeatPassword) {
        return password.equals(repeatPassword);
    }
}
