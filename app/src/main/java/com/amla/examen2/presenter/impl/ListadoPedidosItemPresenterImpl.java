package com.amla.examen2.presenter.impl;

import com.amla.examen2.model.vo.Pedido;
import com.amla.examen2.presenter.ListadoPedidosItemPresenter;
import com.amla.examen2.views.ListadoPedidosItemView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class ListadoPedidosItemPresenterImpl implements ListadoPedidosItemPresenter{
    private ListadoPedidosItemView mView;

    public ListadoPedidosItemPresenterImpl(ListadoPedidosItemView view){
        mView = view;
    }

    @Override
    public void onBindViewHolder(Pedido pedido) {
        mView.setCliente(pedido.getCliente().getNombre());
        mView.setTotal(" total: $" + pedido.getTotal());
        mView.setDetalle(pedido.getCantidad()+" x " + pedido.getArticulo().getNombre() + " (c/u $" + pedido.getArticulo().getPrecio()+")");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        mView.setLog(pedido.getEmpleado().getNombre() + " " + pedido.getEmpleado().getApellido()+  " - " + sdf.format(pedido.getFecha().getTime()));
    }
}
