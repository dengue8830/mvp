package com.amla.examen2.model.service;

import com.amla.examen2.model.vo.LineaPedido;
import com.amla.examen2.model.vo.Pedido;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by dengue8830 on 3/16/17.
 */

public class PedidoService {
    private static List<Pedido> pedidos = new ArrayList<>();

    static {
        List<LineaPedido> lineasPedido = new ArrayList<>();
        LineaPedido lineaPedido = new LineaPedido();
        lineaPedido.setArticulo(ArticuloService.getArticulos().get(0));
        lineaPedido.setCantidad(12);
        lineaPedido.setId(lineasPedido.size()+1);
        lineasPedido.add(lineaPedido);
        pedidos.add(new Pedido(pedidos.size()+1, lineasPedido));
    }

    public static List<Pedido> getPedidos(){
        return pedidos;
    }

    public static List<Pedido> getPedidos(Calendar fecha){
        List<Pedido> pedidosFiltrados = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            if(sonDelMismoDia(pedido.getFecha(), fecha)){
                pedidosFiltrados.add(pedido);
            }
        }

        return pedidosFiltrados;
    }

    private static boolean sonDelMismoDia(Calendar fecha1, Calendar fecha2) {
        return fecha1.get(Calendar.DAY_OF_MONTH) == fecha2.get(Calendar.DAY_OF_MONTH) && fecha1.get(Calendar.MONTH) == fecha2.get(Calendar.MONTH) && fecha1.get(Calendar.YEAR) == fecha2.get(Calendar.YEAR);
    }

    public static void addPedido(List<LineaPedido> lineasPedido) {
        Pedido ped= new Pedido(pedidos.size()+1, lineasPedido);
        pedidos.add(ped);
        int a = 1;
        int b = a+1;
    }
}
