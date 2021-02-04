package com.gzeinnumer.mybasecode.base;

import android.content.Intent;

import com.gzeinnumer.mybasecode.R;
import com.gzeinnumer.mybasecode.utils.BaseConstant;
import com.gzeinnumer.mylibdialog.dialog.confirmDialog.ConfirmDialog;
import com.gzeinnumer.mylibdialog.dialog.infoDialog.InfoDialog;
import com.gzeinnumer.mylibdialog.dialog.loadingDialog.LoadingDialog;
import com.gzeinnumer.mylibdialogfragment.MyLibDialog;

import static maes.tech.intentanim.CustomIntent.customType;

public class BaseDialogFragment extends MyLibDialog {
    private LoadingDialog loadingDialog;

    public BaseDialogFragment() {
        super(R.style.CustomDialogStyle);
    }

    protected void onShowLoading() {
        loadingDialog = BaseAlertDialog.LoadingDialog(requireActivity().getSupportFragmentManager(), requireContext());
        loadingDialog.show();
    }

    protected void onHideLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismis();
        }
    }

    protected ConfirmDialog onShowConfirmDialog() {
        return BaseAlertDialog.ConfirmDialog(requireActivity().getSupportFragmentManager(), requireContext());
    }

    protected InfoDialog onShowInfoDialog() {
        return BaseAlertDialog.InfoDialog(requireActivity().getSupportFragmentManager(), requireContext());
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
