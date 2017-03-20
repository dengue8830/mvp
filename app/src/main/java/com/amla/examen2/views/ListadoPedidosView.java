package com.amla.examen2.views;

import com.amla.examen2.dto.DatePickerDTO;
import com.amla.examen2.model.vo.Pedido;

import java.util.List;

public interface ListadoPedidosView {
    void setPedidos(List<Pedido> pedidos);
    void setTotalDias(String totalDias);
    void abrirDialogFecha(DatePickerDTO dto);
    void updateFechaFiltro(String fechaFiltro);
    void updateListado();
}
