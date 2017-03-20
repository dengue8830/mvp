package com.amla.examen2.views;

public interface NuevoPedidoVIew {
    void setCantidad(int cantidad);
    void errorAlGuardarPedido();
    void pedidoGuardado();
    void mostrarErrorSinArticulo();
    void mostrarErrorCantidadDebeSerMayorAcero();
    void mostrarErrorIngresarCantidad();
    void mostrarErrorSinCliente();
}
