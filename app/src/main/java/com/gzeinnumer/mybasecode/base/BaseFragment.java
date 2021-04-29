package com.gzeinnumer.mybasecode.base;

import android.content.Intent;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.gzeinnumer.da.dialog.confirmDialog.ConfirmDialog;
import com.gzeinnumer.da.dialog.datePickerDialog.multi.MultiDatePickerDialog;
import com.gzeinnumer.da.dialog.datePickerDialog.single.SingleDatePickerDialog;
import com.gzeinnumer.da.dialog.infoDialog.InfoDialog;
import com.gzeinnumer.da.dialog.loadingDialog.LoadingDialog;

public class BaseFragment extends Fragment {
    private LoadingDialog loadingDialog;

    protected void intentTo(Class<?> clss) {
        startActivity(new Intent(requireContext(), clss));
//        customType(requireContext(), BaseConstant.INTENT_ANIM_TYPE);
    }

    protected void intentToPut(Intent intent) {
        startActivity(intent);
//        customType(requireContext(), BaseConstant.INTENT_ANIM_TYPE);
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

    protected void onShowLoading() {
        loadingDialog = BasePopUp.onShowLoading(getChildFragmentManager(), requireActivity());
        loadingDialog.show();
    }

    protected void onShowLoadingChild() {
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

    protected ConfirmDialog onShowConfirmDialogChild() {
        return BasePopUp.onShowConfirmDialog(getChildFragmentManager(), requireActivity());
    }

    protected InfoDialog onShowInfoDialog() {
        return BasePopUp.onShowInfoDialog(getChildFragmentManager(), requireActivity());
    }

    protected InfoDialog onShowInfoDialogChild() {
        return BasePopUp.onShowInfoDialog(getChildFragmentManager(), requireActivity());
    }

    protected SingleDatePickerDialog datePickerSingle() {
        return BasePopUp.datePickerSingle(getChildFragmentManager(), requireActivity());
    }

    protected SingleDatePickerDialog datePickerSingleChild() {
        return BasePopUp.datePickerSingle(getChildFragmentManager(), requireActivity());
    }

    protected MultiDatePickerDialog datePickerMulti() {
        return BasePopUp.datePickerMulti(getChildFragmentManager(), requireActivity());
    }

    protected MultiDatePickerDialog datePickerMultiChild() {
        return BasePopUp.datePickerMulti(getChildFragmentManager(), requireActivity());
    }
}
