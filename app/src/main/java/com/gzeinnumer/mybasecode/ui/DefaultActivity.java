package com.gzeinnumer.mybasecode.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.gzeinnumer.mybasecode.R;
import com.gzeinnumer.mybasecode.base.baseActivity.BaseActivityWhiteBlackNavigation;

public class DefaultActivity extends BaseActivityWhiteBlackNavigation {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);
    }
}