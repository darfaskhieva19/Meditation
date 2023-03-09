package com.example.meditation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import java.util.List;

public class AdapterQuete extends AppCompatActivity {

    protected Context mContext;
    List<MaskQuete> queteList;

    public AdapterQuete(Context mContext, List<MaskQuete> queteList) {
        this.mContext = mContext;
        this.queteList = queteList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_quete);
    }
}