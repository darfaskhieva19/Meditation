package com.example.meditation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    public static MaskUsers User;
    EditText txtEmail, txtPassword;

    final static String EmailU = "Email";
    final static String PasswordU = "Password";
    SharedPreferences SharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail = findViewById(R.id.txtEmailAddress);
        txtPassword = findViewById(R.id.txtPassword);

        getData();
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
    }
    public void Login()
    {
        String email = String.valueOf(txtEmail.getText());
        String pass = String.valueOf(txtPassword.getText());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mskko2021.mad.hakta.pro/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        ModelUser modelUser = new ModelUser(email, pass);
        Call<MaskUsers> call = retrofitAPI.createUser(modelUser);
        call.enqueue(new Callback<MaskUsers>() {
            @Override
            public void onResponse(Call<MaskUsers> call, Response<MaskUsers> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Пользователь с такой почтой и паролем не найден", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(response.body() != null)
                {
                    if(response.body().getToken() != null)
                    {
                        saveData();
                        User = response.body();
                        Intent intent = new Intent(LoginActivity.this, MainMenuActivity.class);
                        Bundle b = new Bundle();
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                }
            }
            @Override
            public void onFailure(Call<MaskUsers> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "При авторизации возникла ошибка: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void saveData() {

        // получаем введенные данные

        SharedPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = SharedPref.edit();
        ed.putString(EmailU,txtEmail.getText().toString());
        ed.putString(PasswordU,txtPassword.getText().toString());
        ed.commit();
    }
    public void getData()
    {
        // получаем сохраненные данные
        SharedPref = getPreferences(MODE_PRIVATE);
        String emailUser = SharedPref.getString(EmailU,"");
        String passwordUser = SharedPref.getString(PasswordU,"");
        txtEmail.setText(emailUser);
        txtPassword.setText(passwordUser);

    }

}