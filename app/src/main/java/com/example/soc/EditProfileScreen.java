package com.example.soc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.soc.models.UpdateProfile;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

public class EditProfileScreen extends AppCompatActivity {

    private EditText firstNameTextField;
    private EditText lastNameTextField;
    private ConstraintLayout constraintLayout;
    private static final String url = "http://192.168.31.107:5002/api"; // Change this to your API URL

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_screen);
        firstNameTextField = findViewById(R.id.firstNameTextField);
        lastNameTextField = findViewById(R.id.lastNameTextField);
        constraintLayout = findViewById(R.id.constraintLayout);

    }

    public void onTapBack(View view) {
        finish();
    }

    public void updateProfile(View view) {
        String firstName = firstNameTextField.getText().toString();
        String lastName = lastNameTextField.getText().toString();
        try {
            UpdateProfile profile = new UpdateProfile(firstName, lastName);
            Gson gson = new Gson();
            String userData = gson.toJson(profile);

            HTTP http = new HTTP(new HTTP.OnRequestCompletedListener() {
                @Override
                public void onRequestCompleted(String response) {
                    Log.e("Response", response);
                    Snackbar.make(constraintLayout, "Запрос успешно выполнен", Snackbar.LENGTH_SHORT).show();
                }

                @Override
                public void onRequestError(Exception e) {
                    Log.e("error", e.toString());
                    Snackbar.make(constraintLayout, "Произошла ошибка: " + e.getMessage(), Snackbar.LENGTH_LONG).show();
                }
            });

            http.makeHttpRequestInBackground(url + "/profile/update", userData);

        } catch (Exception e) {
            Log.e("Error", e.toString());
        }

    }
}
