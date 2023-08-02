package com.example.soc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfileScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);
    }

    public void onTapEditProfile(View view) {
        Intent intent = new Intent(this,EditProfileScreen.class);
        startActivity(intent);
    }

    public void onTapUserNotes(View view) {
        Intent intent = new Intent(this,UserNotes.class);
        startActivity(intent);
    }

    public void onTapChangePassword(View view) {
        Intent intent = new Intent(this,ChangePasswordScreen.class);
        startActivity(intent);
    }
}