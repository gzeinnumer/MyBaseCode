package com.gzeinnumer.mybasecode.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.gzeinnumer.da.dialog.confirmDialog.ConfirmDialog;
import com.gzeinnumer.da.dialog.datePickerDialog.multi.MultiDatePickerDialog;
import com.gzeinnumer.da.dialog.datePickerDialog.single.SingleDatePickerDialog;
import com.gzeinnumer.da.dialog.infoDialog.InfoDialog;
import com.gzeinnumer.da.dialog.loadingDialog.LoadingDialog;
import com.gzeinnumer.mybasecode.base.activity.BasePermissionActivity;
import com.gzeinnumer.mybasecode.utils.GblFunction;

import static maes.tech.intentanim.CustomIntent.customType;

public class BaseActivity extends BasePermissionActivity {

    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            customType(this, BaseConstant.INTENT_ANIM_TYPE);
        }
    }

    protected void debugLocationActivity(View v, String TAG) {
        v.setOnClickListener(view -> {
            GblFunction.debugLocationActivity(getApplicationContext(), TAG);
        });
    }

    protected void intentTo(Class<?> clss) {
        startActivity(new Intent(getApplicationContext(), clss));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            customType(this, BaseConstant.INTENT_ANIM_TYPE);
        }
    }

    protected void intentToPut(Intent intent) {
        startActivity(intent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            customType(this, BaseConstant.INTENT_ANIM_TYPE);
        }
    }

    protected void onToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected void onToastLong(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    protected void onToastLongCenter(String msg) {
        BasePopUp.onToastLongCenter(getApplicationContext(), msg);
    }

    protected void onShowCustomToast(String msg) {
        BasePopUp.onShowCustomToast(this, getApplicationContext(), msg);
    }

    protected void onShowLoading() {
        loadingDialog = BasePopUp.onShowLoading(getSupportFragmentManager(), this);
        loadingDialog.show();
    }

    protected void onHideLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismis();
        }
    }

    protected ConfirmDialog onShowConfirmDialog() {
        return BasePopUp.onShowConfirmDialog(getSupportFragmentManager(), this);
    }

    protected InfoDialog onShowInfoDialog() {
        return BasePopUp.onShowInfoDialog(getSupportFragmentManager(), this);
    }

    protected SingleDatePickerDialog datePickerSingle() {
        return BasePopUp.datePickerSingle(getSupportFragmentManager(), this);
    }

    protected MultiDatePickerDialog datePickerMulti() {
        return BasePopUp.datePickerMulti(getSupportFragmentManager(), this);
    }

    protected void debugDialog(String smg) {
        onShowInfoDialog().setTitle("Debug").setContent(smg).setCanceledOnTouchOutside(true).autoDismisOnSecond(-1).show();
    }

    protected void enableEditText(EditText... editTexts) {
        for (EditText ed : editTexts) {
            ed.setFocusableInTouchMode(true);
            ed.setFocusable(true);
            ed.setEnabled(true);
        }
    }

    protected void disableEditText(EditText... editTexts) {
        for (EditText ed : editTexts) {
            ed.setFocusableInTouchMode(false);
            ed.setFocusable(false);
            ed.setEnabled(false);
        }
    }
}
