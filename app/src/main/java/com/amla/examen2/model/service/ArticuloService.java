package com.amla.examen2.model.service;

import com.amla.examen2.model.vo.Articulo;

import java.util.List;

public interface ArticuloService {
    List<Articulo> getArticulos();
    void addArticulo(String nombre, double precio);
}
