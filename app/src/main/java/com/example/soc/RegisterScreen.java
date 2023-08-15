package com.example.soc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.soc.models.UserDto;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

public class RegisterScreen extends AppCompatActivity {

    private static final String url = "http://192.168.31.107:5002/api"; // Change this to your API URL
    private EditText firstNameTextField;
    private EditText lastNameTextField;
    private EditText emailTextField;
    private EditText passwordTextField;
    private EditText rePasswordTextField;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        firstNameTextField = findViewById(R.id.firstNameTextField);
        lastNameTextField = findViewById(R.id.lastNameTextField);
        emailTextField = findViewById(R.id.emailTextField);
        passwordTextField = findViewById(R.id.passwordTextField);
        rePasswordTextField = findViewById(R.id.rePasswordTextField);
        linearLayout = findViewById(R.id.linearLayout);
    }

    public void onTapRegister(View view) {
        String firstName = firstNameTextField.getText().toString();
        String lastName = lastNameTextField.getText().toString();
        String email = emailTextField.getText().toString();
        String password = passwordTextField.getText().toString();
        String repeatPassword = rePasswordTextField.getText().toString();

        if (!checkPasswordEquality(password, repeatPassword)) {
            Snackbar.make(view, "Пароли не совпадают", Snackbar.LENGTH_SHORT).show();
            return;
        }

        UserDto user = new UserDto(firstName, lastName, email, password);
        Gson gson = new Gson();
        String userData = gson.toJson(user);

        HTTP http = new HTTP(new HTTP.OnRequestCompletedListener() {
            @Override
            public void onRequestCompleted(String response) {
                Snackbar.make(linearLayout, "Запрос успешно выполнен", Snackbar.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterScreen.this, HomeScreen.class);
                startActivity(intent);
            }

            @Override
            public void onRequestError(Exception e) {
                Snackbar.make(view, "Ошибка регистрации", Snackbar.LENGTH_SHORT).show();
            }
        });

        http.makeHttpRequestInBackground(url + "/auth/register", userData);
    }

    public void onTapLogin(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private boolean checkPasswordEquality(String password, String repeatPassword) {
        return password.equals(repeatPassword);
    }
}
