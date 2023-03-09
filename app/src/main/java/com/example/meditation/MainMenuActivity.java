package com.example.meditation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
    }

    public void NextProfile(View view) {
        startActivity(new Intent(this, ProfileActivity.class));
    }

    public void NextListen(View view) {
        startActivity(new Intent(this, ListenActivity.class));
    }

    public void NextMenu(View view) {
        startActivity(new Intent(this, MenuActivity.class));
    }
}