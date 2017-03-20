package com.amla.examen2.presenter;

import java.util.List;

public interface NuevoPedidoPresenter {
    void addPedido(int posicionClienteSelecionado, int posicionArticuloSeleccionado, String stringCantidad);
    void onResume();
}
