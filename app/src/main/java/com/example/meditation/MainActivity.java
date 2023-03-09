package com.example.meditation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onEnter(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void onRegister(View view) {
        Intent regIntent = new Intent(this,RegActivity.class);
        startActivity(regIntent);
    }
}