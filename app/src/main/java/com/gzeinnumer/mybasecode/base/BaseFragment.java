package com.gzeinnumer.mybasecode.base;

import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.gzeinnumer.mybasecode.utils.BaseConstant;
import com.gzeinnumer.mylibdialog.dialog.confirmDialog.ConfirmDialog;
import com.gzeinnumer.mylibdialog.dialog.infoDialog.InfoDialog;
import com.gzeinnumer.mylibdialog.dialog.loadingDialog.LoadingDialog;

import static maes.tech.intentanim.CustomIntent.customType;

public class BaseFragment extends Fragment {
    private LoadingDialog loadingDialog;

    protected void intentTo(Class<?> clss) {
        startActivity(new Intent(requireContext(), clss));
        customType(requireContext(), BaseConstant.INTENT_ANIM_TYPE);
        requireActivity().finish();
    }

    protected void intentToPut(Intent intent) {
        startActivity(intent);
        customType(requireContext(), BaseConstant.INTENT_ANIM_TYPE);
        requireActivity().finish();
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
}
