package com.example.meditation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class ProfileActivity extends AppCompatActivity {

    ImageView img;
    TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        img = findViewById(R.id.Avatar);
        txtName = findViewById(R.id.NameProfile);

        txtName.setText(LoginActivity.User.getNickName());
        new AdapterQuete.DownloadImageTask((ImageView) img)
                .execute(LoginActivity.User.getAvatar());
    }
    public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
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