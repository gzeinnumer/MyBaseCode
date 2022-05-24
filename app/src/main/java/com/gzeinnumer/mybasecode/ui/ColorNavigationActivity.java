package com.gzeinnumer.mybasecode.ui;

import android.os.Bundle;

import com.gzeinnumer.mybasecode.R;
import com.gzeinnumer.mybasecode.base.activity.BaseActivityBlackWhiteNavigation;

//android:theme="@style/Theme.MyBaseCode.Primary"
public class ColorNavigationActivity extends BaseActivityBlackWhiteNavigation {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_navigation);
    }
}