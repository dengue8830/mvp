package com.amla.examen2.presenter;

import com.amla.examen2.dto.DatePickerDTO;
import com.amla.examen2.model.service.PedidoService;
import com.amla.examen2.model.vo.Pedido;
import com.amla.examen2.views.fragments.ListadoPedidosFragment;
import com.codetroopers.betterpickers.datepicker.DatePickerDialogFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ListadoPedidosPresenter implements DatePickerDialogFragment.DatePickerDialogHandler {
    private ListadoPedidosFragment mView;
    private List<Pedido> mPedidos;

    public ListadoPedidosPresenter(ListadoPedidosFragment view){
        mView = view;
        mPedidos = new ArrayList<>();

        loadPedidos();
    }

    public void loadPedidos(){
        mPedidos.clear();
        mPedidos.addAll(PedidoService.getPedidos());
    }

    public List<Pedido> getPedidos(){
        loadPedidos();

        return mPedidos;
    }

    @Override
    public void onDialogDateSet(int reference, int year, int monthOfYear, int dayOfMonth) {
        Calendar fecha = Calendar.getInstance();
        fecha.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        fecha.set(Calendar.MONTH, monthOfYear);
        fecha.set(Calendar.YEAR, year);

        mPedidos.clear();
        List<Pedido> pedidosFiltrados = PedidoService.getPedidos(fecha);

        for (Pedido pedido : pedidosFiltrados) {
            mPedidos.add(pedido);
        }

        mView.updateListado();

        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        mView.updateFechaFiltroTextView(sdf.format(fecha.getTime()));
    }

    public void filtroFechaSeleccionado() {
        Calendar hoy = Calendar.getInstance();
        DatePickerDTO dto = new DatePickerDTO(hoy.get(Calendar.DAY_OF_MONTH), hoy.get(Calendar.MONTH), hoy.get(Calendar.YEAR));
        mView.abrirDialogFecha(dto);
    }
}
