package com.amla.examen2.model.service;

import com.amla.examen2.model.vo.LineaPedido;
import com.amla.examen2.model.vo.Pedido;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dengue8830 on 3/16/17.
 */

public class PedidoService {
    private static List<Pedido> pedidos = new ArrayList<>();

    static {
        LineaPedido lineaPedido = new LineaPedido();
        lineaPedido.setArticulo(ArticuloService.getArticulos().get(0));
        lineaPedido.setCantidad(12);
        lineaPedido.setId(1);

        List<LineaPedido> lineaPedidos = new ArrayList<>();
        lineaPedidos.add(lineaPedido);
        pedidos.add(new Pedido(1, lineaPedidos));
    }

    public static List<Pedido> getPedidos(){

        return pedidos;
    }

    public static void addPedido(List<LineaPedido> lineasPedido) {
        pedidos.add(new Pedido(pedidos.size()+1, lineasPedido));
    }
}
