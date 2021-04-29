package com.gzeinnumer.mybasecode;

import android.os.Bundle;

import com.gzeinnumer.mybasecode.base.baseActivity.BaseActivityDefault;
import com.gzeinnumer.mybasecode.ui.ColorActivity;
import com.gzeinnumer.mybasecode.ui.DefaultActivity;
import com.gzeinnumer.mybasecode.ui.FullScreenActivity;
import com.gzeinnumer.mybasecode.ui.FullScreenColorActivity;
import com.gzeinnumer.mybasecode.ui.WhiteActivity;

public class MainActivity extends BaseActivityDefault {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(v -> intentTo(WhiteActivity.class));
        findViewById(R.id.btn2).setOnClickListener(v -> intentTo(ColorActivity.class));
        findViewById(R.id.btn3).setOnClickListener(v -> intentTo(FullScreenActivity.class));
        findViewById(R.id.btn4).setOnClickListener(v -> intentTo(FullScreenColorActivity.class));
        findViewById(R.id.btn5).setOnClickListener(v -> intentTo(DefaultActivity.class));
    }
}