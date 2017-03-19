package com.amla.examen2.model.vo;

import com.amla.examen2.model.service.EmpleadoService;

import java.util.Calendar;

public class Pedido {
    private int id;
    private Calendar fecha;
    private Articulo articulo;
    private Cliente cliente;
    private Empleado empleado;
    private int cantidad;

    public Pedido(int id, Articulo articulo, Cliente cliente, int cantidad) {
        this.id = id;
        this.articulo = articulo;
        this.fecha = Calendar.getInstance();
        this.cantidad = cantidad;
        this.cliente = cliente;
        this.empleado = EmpleadoService.getEmpleadoLogueado();
    }

    public Pedido(int id, Articulo articulo, Cliente cliente, int cantidad, Calendar fecha) {
        this.id = id;
        this.articulo = articulo;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.cliente = cliente;
        this.empleado = EmpleadoService.getEmpleadoLogueado();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public double getTotal(){
        return articulo.getPrecio() * cantidad;
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

    public Cliente getCliente(){
        return this.cliente;
    }

    public Empleado getEmpleado(){
        return this.empleado;
    }
}
