package com.example.meditation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void NextMenu(View view) {
        startActivity(new Intent(this, MenuActivity.class));
    }

    public void NextLogin(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void NextListen(View view) {
        startActivity(new Intent(this, ListenActivity.class));
    }

    public void NextFeeling(View view) {
        startActivity(new Intent(this, MainMenuActivity.class));
    }
}