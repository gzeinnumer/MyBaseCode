package com.gzeinnumer.mybasecode.base.interfaceMethod;

import com.gzeinnumer.da.dialog.confirmDialog.ConfirmDialog;
import com.gzeinnumer.da.dialog.datePickerDialog.multi.MultiDatePickerDialog;
import com.gzeinnumer.da.dialog.datePickerDialog.single.SingleDatePickerDialog;
import com.gzeinnumer.da.dialog.infoDialog.InfoDialog;

public interface IBaseFragment {
    void onShowLoadingChild();
    ConfirmDialog onShowConfirmDialogChild();
    InfoDialog onShowInfoDialogChild();
    SingleDatePickerDialog datePickerSingleChild();
    MultiDatePickerDialog datePickerMultiChild();
}
