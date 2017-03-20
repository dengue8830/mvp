package com.amla.examen2.model.dao;

import com.amla.examen2.model.vo.Articulo;

import java.util.List;

public interface ArticuloDao {
    List<Articulo> getArticulos();
    void addArticulo(String nombre, double precio);
}
