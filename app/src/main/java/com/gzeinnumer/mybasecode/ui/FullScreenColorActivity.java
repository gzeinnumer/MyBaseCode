package com.gzeinnumer.mybasecode.ui;

import android.os.Bundle;

import com.gzeinnumer.mybasecode.R;
import com.gzeinnumer.mybasecode.base.activity.BaseActivityFullScreenWhiteWhite;

public class FullScreenColorActivity extends BaseActivityFullScreenWhiteWhite {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_color);

//        setPaddingToTopParentView(findViewById(R.id.parent));
    }
}