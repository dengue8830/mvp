package com.amla.examen2.model.dao.impl;

import com.amla.examen2.model.dao.ArticuloDao;
import com.amla.examen2.model.db.BD;
import com.amla.examen2.model.vo.Articulo;

import java.util.List;

public class ArticuloDaoImpl implements ArticuloDao {
    @Override
    public List<Articulo> getArticulos(){
        return BD.getArticulos();
    }

    @Override
    public void addArticulo(String nombre, double precio) {
        BD.insertArticulo(nombre, precio);
    }
}
