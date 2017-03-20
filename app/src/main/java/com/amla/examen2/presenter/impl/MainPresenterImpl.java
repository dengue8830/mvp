package com.amla.examen2.presenter.impl;

import com.amla.examen2.presenter.MainPresenter;
import com.amla.examen2.views.MainView;
import com.amla.examen2.views.impl.MainActivity;

public class MainPresenterImpl implements MainPresenter{
    private MainView mMainActivity;

    public MainPresenterImpl(MainView mainActivity) {
        mMainActivity = mainActivity;
    }

    @Override
    public void opcionClickeada(int itemId, final int nuevoPedidoOption, int listaPedidosOption, int nuevoArticuloOption, int nuevoClienteOption){
        if (itemId == listaPedidosOption){
            mMainActivity.navegarListaPedidos();
        } else if (itemId == nuevoPedidoOption) {
            mMainActivity.navegarNuevoPedido();
        } else  if (itemId == nuevoArticuloOption) {
            mMainActivity.navegarNuevoArticulo();
        } else if(itemId == nuevoClienteOption) {
            mMainActivity.navegarNuevoCliente();
        }
    }
}
