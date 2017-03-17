package com.amla.examen2.model.service;

import com.amla.examen2.model.dao.ArticuloDAO;
import com.amla.examen2.model.vo.Articulo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dengue8830 on 3/16/17.
 */

public class ArticuloService {

    public static List<Articulo> getArticulos(){
        return ArticuloDAO.getArticulos();
    }

    public static void addArticulo(String nombre, double precio) {
        ArticuloDAO.addArticulo(nombre, precio);
    }
}
