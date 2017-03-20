package com.amla.examen2.presenter.impl;

import com.amla.examen2.model.service.ArticuloService;
import com.amla.examen2.views.impl.NuevoArticuloFragment;

public class NuevoArticuloPresenter {
    private NuevoArticuloFragment mView;

    public NuevoArticuloPresenter(NuevoArticuloFragment view){
        mView = view;
    }

    public void crearArticulo(String nombre, String stringPrecio){
        if(stringPrecio == null || stringPrecio.isEmpty()){
            mView.mostrarErrorPrecioVacio();
            return;
        }

        String[] split = stringPrecio.split("\\.");

        if(split.length == 2 && split[1].length() > 2){
            mView.mostrarErrorSoloDosDecimales();
            return;
        }

        double precio;

        try {
            precio = Double.parseDouble(stringPrecio.toString());
        } catch (Exception e) {
            mView.mostrarErrorPrecioInvalido();
            return;
        }

        if(precio == 0d){
            mView.mostrarErrorPrecioCero();
            return;
        }

        if(precio < 0d){
            mView.mostrarErrorPrecioNegativo();
            return;
        }

        if(nombre == null || nombre.isEmpty()){
            mView.mostrarErrorNombreVacio();
            return;
        }

        try {
            ArticuloService.addArticulo(nombre, precio);
        } catch (Exception e) {
            mView.errorAlCrearArticulo();
            return;
        }

        mView.articuloCreado();
    }
}