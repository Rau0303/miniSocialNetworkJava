package com.example.soc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserNotes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_notes);
    }

    public void onTapAddNotes(View view) {
        Intent intent = new Intent(this,AddNote.class);
        startActivity(intent);
    }

    public void onTapBack(View view) {
        finish();
    }
}