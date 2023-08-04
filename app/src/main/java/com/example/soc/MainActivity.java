package com.example.soc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText emailTextField;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailTextField = findViewById(R.id.emailTextField);
        linearLayout = findViewById(R.id.linearLayout);

    }

    public void onTapLogin(View view){

        try {
            if(!isValidEmail(emailTextField.toString())){
                Intent intent = new Intent(this, HomeScreen.class);
                startActivity(intent);
            }
        }
        catch (Error e){
            Snackbar snackbar = Snackbar.make(linearLayout,"Что то пошло не так!", Snackbar.LENGTH_INDEFINITE);
            snackbar.show();

        }

    }

    public void onTapRegister(View view){
        Intent intent = new Intent(this, RegisterScreen.class);
        startActivity(intent);







    }

    private boolean isValidEmail(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


}