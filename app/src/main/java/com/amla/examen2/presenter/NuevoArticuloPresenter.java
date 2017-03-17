package com.amla.examen2.presenter;

import com.amla.examen2.model.service.ArticuloService;
import com.amla.examen2.views.fragments.NuevoArticuloFragment;

public class NuevoArticuloPresenter {
    private NuevoArticuloFragment mView;

    public NuevoArticuloPresenter(NuevoArticuloFragment view){
        mView = view;
    }

    public void crearArticulo(String nombre, Double precio){
        try {
            ArticuloService.addArticulo(nombre, precio);
        } catch (Exception e) {
            mView.errorAlCrearArticulo();
            return;
        }

        mView.articuloCreado();
    }
}
