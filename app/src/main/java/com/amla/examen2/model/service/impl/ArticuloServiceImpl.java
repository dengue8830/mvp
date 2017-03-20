package com.amla.examen2.model.service.impl;

import com.amla.examen2.model.dao.ArticuloDao;
import com.amla.examen2.model.dao.impl.ArticuloDaoImpl;
import com.amla.examen2.model.service.ArticuloService;
import com.amla.examen2.model.vo.Articulo;

import java.util.ArrayList;
import java.util.List;

public class ArticuloServiceImpl implements ArticuloService{
    private ArticuloDao articuloDao;

    public ArticuloServiceImpl(){
        articuloDao = new ArticuloDaoImpl();
    }

    public List<Articulo> getArticulos(){
        List<Articulo> articulos = new ArrayList<>();
        articulos.addAll(articuloDao.getArticulos());
        return articulos;
    }

    public void addArticulo(String nombre, double precio) {
        articuloDao.addArticulo(nombre, precio);
    }
}
