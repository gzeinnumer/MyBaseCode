package com.gzeinnumer.mybasecode.ui;

import android.os.Bundle;

import com.gzeinnumer.mybasecode.R;
import com.gzeinnumer.mybasecode.base.baseActivity.BaseActivityFullScreen;

public class FullScreenActivity extends BaseActivityFullScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        //add this
//        setPaddingToTopParentView(findViewById(R.id.parent));
    }
}