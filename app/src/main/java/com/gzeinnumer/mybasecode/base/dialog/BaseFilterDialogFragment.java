package com.gzeinnumer.mybasecode.base.dialog;

import android.view.Gravity;

import com.gzeinnumer.mybasecode.R;
import com.gzeinnumer.mybasecode.base.BaseDialogFragment;

public class BaseFilterDialogFragment extends BaseDialogFragment {
    public BaseFilterDialogFragment() {
        super();
    }

    public BaseFilterDialogFragment(int style) {
        super(R.style.CustomDialogStyleFilter);
    }

    @Override
    public void onStart() {
        super.onStart();
        setGravity(Gravity.BOTTOM);
        setCanvasWidth(0.95);
    }
}
