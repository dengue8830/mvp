package com.amla.examen2.presenter;

import com.amla.examen2.views.activities.MainActivity;

public class MainPresenter {
    private MainActivity mMainActivity;

    public MainPresenter(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

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
