package com.amla.examen2.presenter;

import com.amla.examen2.views.activities.MainActivity;

/**
 * Created by dengue8830 on 3/17/17.
 */

public class MainPresenter {
    private MainActivity mMainActivity;

    public MainPresenter(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    public void opcionClickeada(int itemId, final int nuevoPedidoOption, int listaPedidosOption, int nuevoArticuloOption){
        if (itemId == listaPedidosOption){
            mMainActivity.navegarListaPedidos();
        } else if (itemId == nuevoPedidoOption) {
            mMainActivity.navegarNuevoPedido();
        } else  if (itemId == nuevoArticuloOption) {
            mMainActivity.navegarNuevoArticulo();
        }
    }
}
