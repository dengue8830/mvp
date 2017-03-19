package com.amla.examen2.model.service;

import com.amla.examen2.model.dao.ArticuloDAO;
import com.amla.examen2.model.vo.Articulo;

import java.util.ArrayList;
import java.util.List;

public class ArticuloService {

    public static List<Articulo> getArticulos(){
        List<Articulo> articulos = new ArrayList<>();
        articulos.addAll(ArticuloDAO.getArticulos());
        return articulos;
    }

    public static void addArticulo(String nombre, double precio) {
        ArticuloDAO.addArticulo(nombre, precio);
    }
}
