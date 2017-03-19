package com.amla.examen2.model.dao;

import com.amla.examen2.model.vo.Articulo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dengue8830 on 3/17/17.
 */

public class ArticuloDAO {
    private static List<Articulo> articulos = new ArrayList<>();
    static {
        articulos.add(new Articulo(1, "Coca Cola 1.25lts", 200d));
        articulos.add(new Articulo(2, "Gatorade 250ml", 1200d));
    }
    public static List<Articulo> getArticulos(){
        return articulos;
    }
    public static void addArticulo(String nombre, double precio) {
        articulos.add(new Articulo(articulos.size()+1, nombre, precio));
    }
}
