package com.gzeinnumer.mybasecode;

import android.os.Bundle;

import com.gzeinnumer.mybasecode.base.activity.BaseActivityWhiteBlackNavigation;
import com.gzeinnumer.mybasecode.ui.ColorNavigationActivity;
import com.gzeinnumer.mybasecode.ui.DefaultActivity;
import com.gzeinnumer.mybasecode.ui.FullScreenActivity;
import com.gzeinnumer.mybasecode.ui.FullScreenColorActivity;
import com.gzeinnumer.mybasecode.ui.WhiteNavigationActivity;

public class MainActivity extends BaseActivityWhiteBlackNavigation {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(v -> intentTo(WhiteNavigationActivity.class));
        findViewById(R.id.btn2).setOnClickListener(v -> intentTo(ColorNavigationActivity.class));
        findViewById(R.id.btn3).setOnClickListener(v -> intentTo(FullScreenActivity.class));
        findViewById(R.id.btn4).setOnClickListener(v -> intentTo(FullScreenColorActivity.class));
        findViewById(R.id.btn5).setOnClickListener(v -> intentTo(DefaultActivity.class));
        findViewById(R.id.btn6).setOnClickListener(v -> debugDialog("{name:zein}"));
    }
}