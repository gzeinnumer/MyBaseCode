package com.gzeinnumer.mybasecode.base;

import static maes.tech.intentanim.CustomIntent.customType;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.gzeinnumer.da.dialog.confirmDialog.ConfirmDialog;
import com.gzeinnumer.da.dialog.datePickerDialog.multi.MultiDatePickerDialog;
import com.gzeinnumer.da.dialog.datePickerDialog.single.SingleDatePickerDialog;
import com.gzeinnumer.da.dialog.infoDialog.InfoDialog;
import com.gzeinnumer.da.dialog.loadingDialog.LoadingDialog;
import com.gzeinnumer.edf.MyLibDialog;
import com.gzeinnumer.mybasecode.R;
import com.gzeinnumer.mybasecode.base.dialog.BasePopUp;
import com.gzeinnumer.mybasecode.base.interfaceMethod.IBaseActivity;
import com.gzeinnumer.mybasecode.base.interfaceMethod.IBaseFragment;
import com.gzeinnumer.mybasecode.utils.GblFunction;

public class BaseDialogFragment extends MyLibDialog implements IBaseActivity, IBaseFragment {
    private LoadingDialog loadingDialog;

    public BaseDialogFragment() {
        super(R.style.CustomDialogStyle);
    }

    public BaseDialogFragment(int style) {
        super(style);
    }

    @Override
    public void debugLocationActivity(View v, String TAG) {
        v.setOnClickListener(view -> {
            GblFunction.debugLocationActivity(requireContext(), TAG);
        });
    }

    @Override
    public void debugDialog(String smg) {
        onShowInfoDialog().setTitle("Debug").setContent(smg).setCanceledOnTouchOutside(true).autoDismisOnSecond(-1).show();
    }

    @Override
    public void intentTo(Class<?> clss) {
        startActivity(new Intent(requireContext(), clss));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            customType(requireContext(), BaseConstant.INTENT_ANIM_TYPE);
        }
    }

    @Override
    public void intentToPut(Intent intent) {
        startActivity(intent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            customType(requireContext(), BaseConstant.INTENT_ANIM_TYPE);
        }
    }

    @Override
    public void onToast(String msg) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onToastLong(String msg) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onToastLongCenter(String msg) {
        BasePopUp.onToastLongCenter(getContext(), msg);
    }

    @Override
    public void onShowCustomToast(String msg) {
        BasePopUp.onShowCustomToast(requireActivity(), requireContext(), msg);
    }

    @Override
    public void onShowCustomToastTop(String msg) {
        BasePopUp.onShowCustomToastTop(requireActivity(), requireContext(), msg);
    }

    @Override
    public void onShowLoading() {
        loadingDialog = BasePopUp.onShowLoading(getChildFragmentManager(), requireActivity());
        loadingDialog.show();
    }

    @Override
    public void onShowLoadingChild() {
        loadingDialog = BasePopUp.onShowLoading(getChildFragmentManager(), requireActivity());
        loadingDialog.show();
    }

    @Override
    public void onHideLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismis();
        }
    }

    @Override
    public ConfirmDialog onShowConfirmDialog() {
        return BasePopUp.onShowConfirmDialog(getChildFragmentManager(), requireActivity());
    }

    @Override
    public ConfirmDialog onShowConfirmDialogChild() {
        return BasePopUp.onShowConfirmDialog(getChildFragmentManager(), requireActivity());
    }

    @Override
    public InfoDialog onShowInfoDialog() {
        return BasePopUp.onShowInfoDialog(getChildFragmentManager(), requireActivity());
    }

    @Override
    public InfoDialog onShowInfoDialogChild() {
        return BasePopUp.onShowInfoDialog(getChildFragmentManager(), requireActivity());
    }

    @Override
    public SingleDatePickerDialog datePickerSingle() {
        return BasePopUp.datePickerSingle(requireActivity().getSupportFragmentManager(), requireActivity());
    }

    @Override
    public SingleDatePickerDialog datePickerSingleChild() {
        return BasePopUp.datePickerSingle(getChildFragmentManager(), requireActivity());
    }

    @Override
    public MultiDatePickerDialog datePickerMulti() {
        return BasePopUp.datePickerMulti(requireActivity().getSupportFragmentManager(), requireActivity());
    }

    @Override
    public MultiDatePickerDialog datePickerMultiChild() {
        return BasePopUp.datePickerMulti(getChildFragmentManager(), requireActivity());
    }

    @Override
    public void enableEditText(EditText... editTexts) {
        for (EditText ed : editTexts) {
            ed.setFocusableInTouchMode(true);
            ed.setFocusable(true);
            ed.setEnabled(true);
        }
    }

    @Override
    public void disableEditText(EditText... editTexts) {
        for (EditText ed : editTexts) {
            ed.setFocusableInTouchMode(false);
            ed.setFocusable(false);
            ed.setEnabled(false);
        }
    }

    @Override
    public void onShowView(View view) {
        view.setVisibility(View.VISIBLE);
    }

    @Override
    public void onHideView(View view) {
        view.setVisibility(View.GONE);
    }

    @Override
    public void emptyState(int size, RecyclerView rv, View imgEmpty) {
        rv.setVisibility(View.GONE);
        imgEmpty.setVisibility(View.GONE);

        rv.setVisibility(size==0 ? View.GONE : View.VISIBLE);
        imgEmpty.setVisibility(size==0 ? View.VISIBLE : View.GONE);
    }

    @Override
    public void swipe(SwipeRefreshLayout swipeRefreshLayout, boolean swipe){
        swipeRefreshLayout.setRefreshing(swipe);
    }

    @Override
    public String xmlString(int idString) {
        return getResources().getString(idString);
    }

    @Override
    public int xmlColor(int idColor) {
        return ContextCompat.getColor(requireContext(), idColor);
    }

    @Override
    public void onShowInfoDialogError(String title, String message) {

    }

    @Override
    public void fabDebug(LinearLayout llFab, String... tables) {

    }
}
