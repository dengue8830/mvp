package com.amla.examen2.presenter.impl;

import com.amla.examen2.model.service.PedidoService;
import com.amla.examen2.model.service.impl.PedidoServiceImpl;
import com.amla.examen2.model.vo.Pedido;
import com.amla.examen2.presenter.ListadoPedidosPresenter;
import com.amla.examen2.views.ListadoPedidosView;
import com.amla.examen2.views.impl.ListadoPedidosFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ListadoPedidosPresenterImpl implements ListadoPedidosPresenter {
    private ListadoPedidosView mView;
    private List<Pedido> mPedidos;
    private PedidoService pedidoService;

    public ListadoPedidosPresenterImpl(ListadoPedidosFragment view){
        mView = view;
        mPedidos = new ArrayList<>();
        pedidoService = new PedidoServiceImpl();

        loadPedidos();
    }

    private void loadPedidos(){
        mPedidos.clear();
        mPedidos.addAll(pedidoService.getPedidos());
    }

    private List<Pedido> getPedidos(){
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
        List<Pedido> pedidosFiltrados = pedidoService.getPedidos(fecha);
        mPedidos.addAll(pedidosFiltrados);

        mView.updateListado();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

        mView.updateFechaFiltro(sdf.format(fecha.getTime()));

        mView.setTotalDias(getTotalDias());
    }

    @Override
    public void filtroFechaSeleccionado() {
        Calendar hoy = Calendar.getInstance();
        mView.abrirDialogFecha(hoy.get(Calendar.DAY_OF_MONTH), hoy.get(Calendar.MONTH), hoy.get(Calendar.YEAR));
    }

    private String getTotalDias() {
        double total = 0d;

        for (Pedido pedido : mPedidos) {
            total += pedido.getArticulo().getPrecio() * pedido.getCantidad();
        }

        return "$"+total;
    }

    @Override
    public void onResume(){
        mView.setPedidos(getPedidos());
        mView.setTotalDias(getTotalDias());
    }
}
