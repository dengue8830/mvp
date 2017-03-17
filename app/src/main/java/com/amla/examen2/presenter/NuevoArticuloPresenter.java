package com.amla.examen2.presenter;

import com.amla.examen2.model.service.ArticuloService;
import com.amla.examen2.views.fragments.NuevoArticuloFragment;

public class NuevoArticuloPresenter {
    private NuevoArticuloFragment mView;

    public NuevoArticuloPresenter(NuevoArticuloFragment view){
        mView = view;
    }

    public void crearArticulo(String nombre, Double precio){
        if(nombre == null || nombre.isEmpty()){
            mView.mostrarErrorNombreVacio();
            return;
        }

        if(precio == null || precio.equals(0d)){
            mView.mostrarErrorPrecioCero();
            return;
        }

        if(precio == null || precio.compareTo(0d) < 0){
            mView.mostrarErrorPrecioNegativo();
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
