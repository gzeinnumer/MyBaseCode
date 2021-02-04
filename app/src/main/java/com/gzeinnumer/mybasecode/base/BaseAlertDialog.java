package com.gzeinnumer.mybasecode.base;

import android.content.Context;
import android.view.Gravity;
import android.view.View;

import androidx.fragment.app.FragmentManager;

import com.gzeinnumer.mybasecode.R;
import com.gzeinnumer.mybasecode.utils.BaseConstant;
import com.gzeinnumer.mylibdialog.constant.ButtonStyle;
import com.gzeinnumer.mylibdialog.constant.DialogType;
import com.gzeinnumer.mylibdialog.dialog.confirmDialog.ConfirmDialog;
import com.gzeinnumer.mylibdialog.dialog.infoDialog.InfoDialog;
import com.gzeinnumer.mylibdialog.dialog.loadingDialog.LoadingDialog;

public class BaseAlertDialog {

    public static ConfirmDialog ConfirmDialog(FragmentManager supportFragmentManager, Context context) {
        return new ConfirmDialog(supportFragmentManager)
                .setAnimationStyle(R.style.CustomDialogStyle)
                .setButtonAllCaps(false)
                .setButtonGravity(Gravity.CENTER)
                .setContentAlignment(View.TEXT_ALIGNMENT_CENTER)
                .setButtonStyle(ButtonStyle.ButtonContained)
                .setButtonColor(context.getResources().getColor(R.color.colorPrimary))
                .setBtnOkTitle("Ya")
                .setBtnCancelTitle("Tidak");
    }

    public static InfoDialog InfoDialog(FragmentManager supportFragmentManager, Context context) {
        return new InfoDialog(supportFragmentManager)
                .setAnimationStyle(R.style.CustomDialogStyle)
                .setTitle(BaseConstant.MSG_INFO)
                .autoDismisOnSecond(5)
                .setButtonAllCaps(false)
                .setButtonGravity(Gravity.CENTER)
                .setContentAlignment(View.TEXT_ALIGNMENT_CENTER)
                .setTitleColor(context.getResources().getColor(R.color.black))
                .setButtonStyle(ButtonStyle.ButtonContained)
                .setButtonColor(context.getResources().getColor(R.color.colorPrimary))
                .setDialogType(DialogType.DialogSuccess);
    }

    public static LoadingDialog LoadingDialog(FragmentManager supportFragmentManager, Context context) {
        return new LoadingDialog(supportFragmentManager).setContent("Loading ...");
    }
}
