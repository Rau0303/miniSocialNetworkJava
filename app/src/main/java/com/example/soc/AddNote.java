package com.example.soc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.soc.models.CreatePostDto;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

public class AddNote extends AppCompatActivity {

    private EditText descriptionTextField;
    private EditText titleTextField;
    private ConstraintLayout constraintLayout;
    private String titleText;
    private String descriptionText;
    private static final String url = "http://192.168.31.107:5002/api"; // Change this to your API URL

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        titleTextField = findViewById(R.id.titleTextField);
        descriptionTextField = findViewById(R.id.descriptionTextField);
        constraintLayout = findViewById(R.id.constraintLayout);
    }

    public void onTapBack(View view) {
        finish();
    }

    public void onTapPublish(View view) {
        try {
            titleText = titleTextField.getText().toString();
            descriptionText = descriptionTextField.getText().toString();

            CreatePostDto postDto = new CreatePostDto(titleText, descriptionText, "");
            Gson gson = new Gson();
            String postData = gson.toJson(postDto);

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

            http.makeHttpRequestInBackground(url + "/post/createPost", postData);

        } catch (Exception e) {
            Log.e("error", e.toString());
        }
    }
}
