package com.amla.examen2.model.dao;

import com.amla.examen2.model.vo.Articulo;
import com.amla.examen2.model.vo.Cliente;
import com.amla.examen2.model.vo.Pedido;

import java.util.List;

public interface PedidoDao {
    List<Pedido> getPedidos();
    void addPedido(Articulo articulo, Cliente cliente, int cantidad);
}
