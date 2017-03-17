package com.amla.examen2.presenter;

import com.amla.examen2.model.service.PedidoService;
import com.amla.examen2.model.vo.Pedido;

import java.util.List;

public class ListadoPedidosPresenter {

    public List<Pedido> getPedidos(){
        return PedidoService.getPedidos();
    }

//    interface ListadoPedidosView {
//
//    }
}
