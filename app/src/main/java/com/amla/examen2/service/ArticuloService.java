package com.amla.examen2.service;

import android.text.Editable;

import com.amla.examen2.vo.Articulo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dengue8830 on 3/16/17.
 */

public class ArticuloService {

    private static List<Articulo> articulos = new ArrayList<>();

    static {
        articulos.add(new Articulo(1, "ventilador", 200d));
        articulos.add(new Articulo(2, "monitor", 1200d));
    }

    public static List<Articulo> getArticulos(){
        return articulos;
    }

    public static void addArticulo(String nombre, Double precio) {
        articulos.add(new Articulo(articulos.size()+1, nombre, precio));
    }
}
