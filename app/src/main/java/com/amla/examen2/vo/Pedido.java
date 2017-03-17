package com.amla.examen2.vo;

import java.util.List;

/**
 * Created by dengue8830 on 3/16/17.
 */

public class Pedido {
    private int id;
    private List<LineaPedido> lineasPedido;

    public Pedido(int id, List<LineaPedido> lineasPedido) {
        this.id = id;
        this.lineasPedido = lineasPedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<LineaPedido> getLineasPedido() {
        return lineasPedido;
    }

    public void setLineasPedido(List<LineaPedido> lineasPedido) {
        this.lineasPedido = lineasPedido;
    }

    public double getTotal(){
        if(lineasPedido == null || lineasPedido.isEmpty())
            return 0;

        double total = 0;

        for (LineaPedido lineaPedido : lineasPedido) {
            total += lineaPedido.getCantidad() * lineaPedido.getArticulo().getPrecio();
        }

        return total;
    }
}
