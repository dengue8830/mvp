package com.amla.examen2.views;

import java.util.List;

public interface NuevoPedidoVIew {
    void setCantidad(int cantidad);
    void errorAlGuardarPedido();
    void pedidoGuardado();
    void mostrarErrorSinArticulo();
    void mostrarErrorCantidadDebeSerMayorAcero();
    void mostrarErrorIngresarCantidad();
    void mostrarErrorSinCliente();
    void setArticulos(List<String> articulos);
    void setClientes(List<String> clientes);
}
