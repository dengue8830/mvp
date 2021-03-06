package com.amla.examen2.model.service;

import com.amla.examen2.model.vo.Articulo;
import com.amla.examen2.model.vo.Cliente;
import com.amla.examen2.model.vo.Pedido;

import java.util.Calendar;
import java.util.List;

public interface PedidoService {
    List<Pedido> getPedidos();
    List<Pedido> getPedidos(Calendar fecha);
    void addPedido(Articulo articulo, Cliente cliente, int cantidad);
}
