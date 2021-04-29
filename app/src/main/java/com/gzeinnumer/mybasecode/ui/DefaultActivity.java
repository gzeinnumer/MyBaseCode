package com.gzeinnumer.mybasecode.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.gzeinnumer.mybasecode.R;

public class DefaultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);
    }
}