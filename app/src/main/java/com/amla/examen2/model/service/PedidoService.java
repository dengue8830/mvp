package com.amla.examen2.model.service;

import com.amla.examen2.model.vo.Articulo;
import com.amla.examen2.model.vo.Cliente;
import com.amla.examen2.model.vo.Pedido;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PedidoService {
    private static List<Pedido> pedidos = new ArrayList<>();

    static {
        pedidos.add(new Pedido(pedidos.size()+1, ArticuloService.getArticulos().get(0), ClienteService.getClientes().get(0), 2));
    }

    public static List<Pedido> getPedidos(){
        List<Pedido> cloned = new ArrayList<>();
        cloned.addAll(pedidos);
        return cloned;
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

    public static void addPedido(Articulo articulo, Cliente cliente, int cantidad) {
        pedidos.add(new Pedido(pedidos.size()+1, articulo, cliente, cantidad));
    }
}
