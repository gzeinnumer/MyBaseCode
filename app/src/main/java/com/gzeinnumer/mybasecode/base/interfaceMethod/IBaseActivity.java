package com.gzeinnumer.mybasecode.base.interfaceMethod;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.gzeinnumer.da.dialog.confirmDialog.ConfirmDialog;
import com.gzeinnumer.da.dialog.datePickerDialog.multi.MultiDatePickerDialog;
import com.gzeinnumer.da.dialog.datePickerDialog.single.SingleDatePickerDialog;
import com.gzeinnumer.da.dialog.infoDialog.InfoDialog;

public interface IBaseActivity {
    void debugLocationActivity(View v, String TAG);
    void debugDialog(String smg);

    void intentTo(Class<?> clss);
    void intentToPut(Intent intent);

    void onToast(String msg);
    void onToastLong(String msg);
    void onToastLongCenter(String msg);
    void onShowCustomToast(String msg);
    void onShowCustomToastTop(String msg);

    void onShowLoading();
    void onHideLoading();

    ConfirmDialog onShowConfirmDialog();
    InfoDialog onShowInfoDialog();

    SingleDatePickerDialog datePickerSingle();
    MultiDatePickerDialog datePickerMulti();

    void enableEditText(EditText... editTexts);
    void disableEditText(EditText... editTexts);

    void onShowView(View view);
    void onHideView(View view);

    void emptyState(int size, RecyclerView rv, View imgEmpty);
    void swipe(SwipeRefreshLayout swipeRefreshLayout, boolean swipe);

    String xmlString(int idString);
    int xmlColor(int idColor);
}
