package com.amla.examen2.model.vo;

/**
 * Created by dengue8830 on 3/16/17.
 */

public class LineaPedido {
    private int id;
    private Articulo articulo;
    private int cantidad;

    public LineaPedido() {
    }

    public LineaPedido(int id, Articulo articulo, int cantidad) {
        this.id = id;
        this.articulo = articulo;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
