package com.amla.examen2.model.dao.impl;

import com.amla.examen2.model.dao.PedidoDao;
import com.amla.examen2.model.db.BD;
import com.amla.examen2.model.vo.Articulo;
import com.amla.examen2.model.vo.Cliente;
import com.amla.examen2.model.vo.Pedido;

import java.util.List;

public class PedidoDaoImpl implements PedidoDao{

    public PedidoDaoImpl(){

    }

    public List<Pedido> getPedidos(){
        return BD.getPedidos();
    }

    public void addPedido(Articulo articulo, Cliente cliente, int cantidad) {
        BD.insertPedido(articulo, cliente, cantidad);
    }
}
