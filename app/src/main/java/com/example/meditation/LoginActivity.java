package com.example.meditation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    public static MaskUsers User;
    EditText txtEmail, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail = findViewById(R.id.txtEmailAddress);
        txtPassword = findViewById(R.id.txtPassword);
    }

    public void onReg(View view) {
        startActivity(new Intent(this, RegActivity.class));
    }

    public void NextMain(View view) {

        if(txtEmail.getText().toString().equals("") ||  txtPassword.getText().toString().equals(""))
        {
            Toast.makeText(LoginActivity.this, "Все обязательные поля должны быть заполнены!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Pattern p = Pattern.compile("@", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(txtEmail.getText().toString());
            boolean b = m.find();
            if(b)
            {
                Login();
            }
            else
            {
                Toast.makeText(LoginActivity.this, "Поле для Email должно обязательно содержать в себе символ '@'!", Toast.LENGTH_SHORT).show();
            }
        }
        //startActivity(new Intent(this, MainMenuActivity.class));
    }
    public void Login()
    {
        /*String email = String.valueOf(txtEmail.getText());
        String pass = String.valueOf(txtPassword.getText());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mskko2021.mad.hakta.pro/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiRetrofit retrofitAPI = retrofit.create(RetrofitAPI.class);
        MaskUsers modal = new MaskUsers(null, title, genre, producer, image);
        Call<MaskUsers> call = retrofitAPI.createPost(modal);
        call.enqueue(new Callback<MaskUsers>() {*/
    }
}