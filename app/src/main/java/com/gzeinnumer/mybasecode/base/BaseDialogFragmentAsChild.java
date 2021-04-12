package com.gzeinnumer.mybasecode.base;

import android.content.Intent;
import android.widget.Toast;

import com.gzeinnumer.da.dialog.confirmDialog.ConfirmDialog;
import com.gzeinnumer.da.dialog.datePickerDialog.multi.MultiDatePickerDialog;
import com.gzeinnumer.da.dialog.datePickerDialog.single.SingleDatePickerDialog;
import com.gzeinnumer.da.dialog.infoDialog.InfoDialog;
import com.gzeinnumer.da.dialog.loadingDialog.LoadingDialog;
import com.gzeinnumer.mybasecode.R;
import com.gzeinnumer.mybasecode.utils.BaseConstant;
import com.gzeinnumer.mylibdialogfragment.MyLibDialog;

import static maes.tech.intentanim.CustomIntent.customType;

public class BaseDialogFragmentAsChild extends MyLibDialog {
    private LoadingDialog loadingDialog;

    public BaseDialogFragmentAsChild() {
        super(R.style.CustomDialogStyle);
    }

    protected void intentTo(Class<?> clss) {
        startActivity(new Intent(requireContext(), clss));
        customType(requireActivity(), BaseConstant.INTENT_ANIM_TYPE);
    }

    protected void intentToPut(Intent intent) {
        startActivity(intent);
        customType(requireActivity(), BaseConstant.INTENT_ANIM_TYPE);
    }

    protected void onShowLoading() {
        loadingDialog = BasePopUp.onShowLoading(getChildFragmentManager(), requireActivity());
        loadingDialog.show();
    }

    protected void onHideLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismis();
        }
    }

    protected ConfirmDialog onShowConfirmDialog() {
        return BasePopUp.onShowConfirmDialog(getChildFragmentManager(), requireActivity());
    }

    protected InfoDialog onShowInfoDialog() {
        return BasePopUp.onShowInfoDialog(getChildFragmentManager(), requireActivity());
    }

    protected void onToast(String msg) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show();
    }

    protected void onToastLong(String msg) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show();
    }

    protected void onToastLongCenter(String msg) {
        BasePopUp.onToastLongCenter(getContext(), msg);
    }

    protected void onShowCustomToast(String msg) {
        BasePopUp.onShowCustomToast(requireActivity(), requireContext(), msg);
    }

    protected SingleDatePickerDialog datePickerSingle() {
        return BasePopUp.datePickerSingle(getChildFragmentManager(), requireActivity());
    }

    protected MultiDatePickerDialog datePickerMulti() {
        return BasePopUp.datePickerMulti(getChildFragmentManager(), requireActivity());
    }
}
