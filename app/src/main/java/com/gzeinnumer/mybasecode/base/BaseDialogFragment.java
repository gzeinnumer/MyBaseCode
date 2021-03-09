package com.gzeinnumer.mybasecode.base;

import android.content.Intent;
import android.widget.Toast;

import com.gzeinnumer.da.dialog.confirmDialog.ConfirmDialog;
import com.gzeinnumer.da.dialog.infoDialog.InfoDialog;
import com.gzeinnumer.da.dialog.loadingDialog.LoadingDialog;
import com.gzeinnumer.mybasecode.R;
import com.gzeinnumer.mybasecode.utils.BaseConstant;
import com.gzeinnumer.mylibdialogfragment.MyLibDialog;

import static maes.tech.intentanim.CustomIntent.customType;

public class BaseDialogFragment extends MyLibDialog {
    private LoadingDialog loadingDialog;

    public BaseDialogFragment() {
        super(R.style.CustomDialogStyle);
    }

    protected void onShowLoading() {
        loadingDialog = BasePopUp.onShowLoading(requireActivity().getSupportFragmentManager(), requireActivity());
        loadingDialog.show();
    }

    protected void onHideLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismis();
        }
    }

    protected void onToast(String msg) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show();
    }

    protected void onToastLong(String msg) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show();
    }

    protected ConfirmDialog onShowConfirmDialog() {
        return BasePopUp.onShowConfirmDialog(requireActivity().getSupportFragmentManager(), requireActivity());
    }

    protected InfoDialog onShowInfoDialog() {
        return BasePopUp.onShowInfoDialog(requireActivity().getSupportFragmentManager(), requireActivity());
    }

    protected void intentTo(Class<?> clss) {
        startActivity(new Intent(requireContext(), clss));
        customType(requireActivity(), BaseConstant.INTENT_ANIM_TYPE);
        requireActivity().finish();
    }

    protected void intentToPut(Intent intent) {
        startActivity(intent);
        customType(requireActivity(), BaseConstant.INTENT_ANIM_TYPE);
        requireActivity().finish();
    }
}
