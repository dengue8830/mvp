package com.amla.examen2.model.db;

import com.amla.examen2.model.service.ClienteService;
import com.amla.examen2.model.vo.Articulo;
import com.amla.examen2.model.vo.Cliente;
import com.amla.examen2.model.vo.Empleado;
import com.amla.examen2.model.vo.Pedido;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BD {
    private static Empleado empleadoLogueado = new Empleado(1, "David", "Rearte");
    private static List<Pedido> pedidos = new ArrayList<>();
    private static List<Articulo> articulos = new ArrayList<>();

    static {
        articulos.add(new Articulo(1, "Coca Cola 1.25lts", 20d));
        articulos.add(new Articulo(2, "Gatorade 250ml", 10d));

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 10);
        pedidos.add(new Pedido(pedidos.size()+1, articulos.get(0), ClienteService.getClientes().get(0), 2, cal, empleadoLogueado));

        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.DAY_OF_MONTH, 11);
        pedidos.add(new Pedido(pedidos.size()+1, articulos.get(1), ClienteService.getClientes().get(1), 3, cal2, empleadoLogueado));
    }

    public static List<Pedido> getPedidos(){
        List<Pedido> cloned = new ArrayList<>();
        cloned.addAll(pedidos);
        return cloned;
    }

    public static List<Articulo> getArticulos(){
        return articulos;
    }

    public static void insertPedido(Articulo articulo, Cliente cliente, int cantidad) {
        pedidos.add(new Pedido(pedidos.size()+1, articulo, cliente, cantidad, Calendar.getInstance(), empleadoLogueado));
    }

    public static void insertArticulo(String nombre, double precio) {
        articulos.add(new Articulo(articulos.size()+1, nombre, precio));
    }

    public static Empleado getEmpleadoLogueado(){
        return empleadoLogueado;
    }
}
