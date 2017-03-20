package com.amla.examen2.presenter;

import com.codetroopers.betterpickers.datepicker.DatePickerDialogFragment;

public interface ListadoPedidosPresenter extends DatePickerDialogFragment.DatePickerDialogHandler{
    void filtroFechaSeleccionado();
    void onResume();
}
