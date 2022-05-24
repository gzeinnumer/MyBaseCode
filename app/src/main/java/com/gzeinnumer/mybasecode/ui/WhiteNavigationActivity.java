package com.gzeinnumer.mybasecode.ui;

import android.os.Bundle;

import com.gzeinnumer.mybasecode.R;
import com.gzeinnumer.mybasecode.base.activity.BaseActivityBlackBlackNavigation;

//android:theme="@style/Theme.MyBaseCode.White"
public class WhiteNavigationActivity extends BaseActivityBlackBlackNavigation {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_white_navigation);
    }
}