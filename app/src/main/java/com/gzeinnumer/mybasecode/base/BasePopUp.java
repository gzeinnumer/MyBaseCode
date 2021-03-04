package com.gzeinnumer.mybasecode.base;

import android.view.Gravity;
import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.gzeinnumer.da.constant.ButtonStyle;
import com.gzeinnumer.da.constant.DialogType;
import com.gzeinnumer.da.dialog.confirmDialog.ConfirmDialog;
import com.gzeinnumer.da.dialog.datePickerDialog.multi.MultiDatePickerDialog;
import com.gzeinnumer.da.dialog.datePickerDialog.single.SingleDatePickerDialog;
import com.gzeinnumer.da.dialog.infoDialog.InfoDialog;
import com.gzeinnumer.da.dialog.loadingDialog.LoadingDialog;
import com.gzeinnumer.mybasecode.R;

public class BasePopUp {

    public static LoadingDialog onShowLoading(FragmentManager supportFragmentManager, FragmentActivity fragmentActivity) {
        return new LoadingDialog(supportFragmentManager).setContent("Loading ...");
    }

    public static ConfirmDialog onShowConfirmDialog(FragmentManager supportFragmentManager, FragmentActivity fragmentActivity) {
        return new ConfirmDialog(supportFragmentManager)
                .setAnimationStyle(R.style.CustomDialogStyle)
                .setButtonAllCaps(false)
                .setButtonCancelColor(fragmentActivity.getResources().getColor(R.color.grey_500))
                .setButtonGravity(Gravity.CENTER)
                .setContentAlignment(View.TEXT_ALIGNMENT_CENTER)
                .setButtonStyle(ButtonStyle.ButtonContained)
                .setButtonColor(R.color.colorPrimary)
                .setBtnOkTitle("Ya")
                .setBtnCancelTitle("Tidak");
    }

    public static InfoDialog onShowInfoDialog(FragmentManager supportFragmentManager, FragmentActivity fragmentActivity) {
        return new InfoDialog(supportFragmentManager)
                .setAnimationStyle(R.style.CustomDialogStyle)
                .setButtonAllCaps(false)
                .autoDismisOnSecond(5)
                .setButtonGravity(Gravity.CENTER)
                .setContentAlignment(View.TEXT_ALIGNMENT_CENTER)
                .setTitleColor(fragmentActivity.getResources().getColor(R.color.black))
                .setButtonStyle(ButtonStyle.ButtonContained)
                .setButtonColor(R.color.colorPrimary)
                .setDialogType(DialogType.DialogSuccess);
    }

    public static SingleDatePickerDialog datePickerSingle(FragmentManager supportFragmentManager, FragmentActivity fragmentActivity) {
        return new SingleDatePickerDialog(supportFragmentManager)
                .setTimeZone("GMT")
                .setTitle("Pilih tanggal")
                .setSelectedToday(true)
                .setTimeFormat("dd/MM/yyyy");
    }

    public static MultiDatePickerDialog datePickerMulti(FragmentManager supportFragmentManager, FragmentActivity fragmentActivity) {
        return new MultiDatePickerDialog(supportFragmentManager)
                .setTimeZone("GMT")
                .setTitle("Pilih tanggal")
                .setTimeFormat("dd/MM/yyyy");
    }
}
