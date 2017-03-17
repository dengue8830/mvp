package com.amla.examen2.model.vo;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private Calendar fecha;
    private List<LineaPedido> lineasPedido;

    public Pedido(int id, List<LineaPedido> lineasPedido) {
        this.id = id;
        this.lineasPedido = lineasPedido;
        this.fecha = Calendar.getInstance();
//        this.fecha.set(Calendar.HOUR_OF_DAY, 0);
//        this.fe
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

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
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
