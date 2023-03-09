package com.example.meditation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import java.util.List;

public class AdapterFeelings extends AppCompatActivity {

    protected Context mContext;
    List<MaskFeelings> feelingsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_feelings);
    }
}