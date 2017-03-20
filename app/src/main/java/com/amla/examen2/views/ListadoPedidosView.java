package com.amla.examen2.views;

import com.amla.examen2.model.vo.Pedido;

import java.util.List;

public interface ListadoPedidosView {
    void onResume();
    void setPedidos(List<Pedido> pedidos);
    void setTotalDias(String totalDias);
    void abrirDialogFecha(int diaDelMes, int mesDelAno, int ano);
    void updateFechaFiltro(String fechaFiltro);
    void updateListado();
}
