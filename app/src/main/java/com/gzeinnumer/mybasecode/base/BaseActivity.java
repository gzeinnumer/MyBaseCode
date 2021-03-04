package com.gzeinnumer.mybasecode.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gzeinnumer.da.dialog.confirmDialog.ConfirmDialog;
import com.gzeinnumer.da.dialog.infoDialog.InfoDialog;
import com.gzeinnumer.da.dialog.loadingDialog.LoadingDialog;
import com.gzeinnumer.mybasecode.utils.BaseConstant;
import com.gzeinnumer.mybasecode.utils.GblFunction;

import static maes.tech.intentanim.CustomIntent.customType;

public class BaseActivity extends AppCompatActivity {

    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    protected void debugLocationActivity(View v, String TAG){
        v.setOnClickListener(view -> {
            GblFunction.debugLocationActivity(getApplicationContext(), TAG);
        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        customType(this, BaseConstant.INTENT_ANIM_TYPE);
    }

    protected void intentTo(Class<?> clss) {
        startActivity(new Intent(getApplicationContext(), clss));
        customType(this, BaseConstant.INTENT_ANIM_TYPE);
        finish();
    }

    protected void intentToPut(Intent intent) {
        startActivity(intent);
        customType(this, BaseConstant.INTENT_ANIM_TYPE);
        finish();
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

    protected void dummyAction(Class<?> clas) {
        onShowLoading();
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(4000);
                    onHideLoading();
                    onShowInfoDialog().setTitle(BaseConstant.MSG_INFO).onOkPressedCallBack(() -> {
                        intentTo(clas);
                        finish();
                    }).setContent("Dummy Message").show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timer.start();
    }

    protected void dummyActionConfirm(Class<?> clas) {
        onShowConfirmDialog()
                .setTitle(BaseConstant.MSG_INFO)
                .setContent("Dummy Message")
                .onOkPressedCallBack(new ConfirmDialog.OnOkPressed() {
                    @Override
                    public void onOkPressed() {
                        intentTo(clas);
                    }
                })
                .show();
    }

}
