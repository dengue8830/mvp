package com.amla.examen2.model.service.impl;

import com.amla.examen2.model.dao.PedidoDao;
import com.amla.examen2.model.dao.impl.PedidoDaoImpl;
import com.amla.examen2.model.service.PedidoService;
import com.amla.examen2.model.vo.Articulo;
import com.amla.examen2.model.vo.Cliente;
import com.amla.examen2.model.vo.Pedido;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PedidoServiceImpl implements PedidoService{
    private PedidoDao pedidoDao;

    public PedidoServiceImpl(){
        pedidoDao = new PedidoDaoImpl();
    }

    @Override
    public List<Pedido> getPedidos(){
        return pedidoDao.getPedidos();
    }

    @Override
    public void addPedido(Articulo articulo, Cliente cliente, int cantidad) {
        pedidoDao.addPedido(articulo, cliente, cantidad);
    }

    @Override
    public List<Pedido> getPedidos(Calendar fecha){
        List<Pedido> pedidosFiltrados = new ArrayList<>();

        for (Pedido pedido : pedidoDao.getPedidos()) {
            if(sonDelMismoDia(pedido.getFecha(), fecha)){
                pedidosFiltrados.add(pedido);
            }
        }

        return pedidosFiltrados;
    }

    private static boolean sonDelMismoDia(Calendar fecha1, Calendar fecha2) {
        return fecha1.get(Calendar.DAY_OF_MONTH) == fecha2.get(Calendar.DAY_OF_MONTH) && fecha1.get(Calendar.MONTH) == fecha2.get(Calendar.MONTH) && fecha1.get(Calendar.YEAR) == fecha2.get(Calendar.YEAR);
    }
}
