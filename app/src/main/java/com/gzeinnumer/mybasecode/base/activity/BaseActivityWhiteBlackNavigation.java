package com.gzeinnumer.mybasecode.base.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.gzeinnumer.mybasecode.base.BaseActivity;

//android:theme="@style/Theme.MyBaseCode.Primary.White"
public class BaseActivityWhiteBlackNavigation extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                //enable this tho maker icon Navigation bar become black
                int decore = View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
                getWindow().getDecorView().setSystemUiVisibility(decore);
            }
        }
    }
}
