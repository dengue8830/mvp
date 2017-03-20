package com.amla.examen2.presenter.impl;

import com.amla.examen2.model.service.ArticuloService;
import com.amla.examen2.model.service.impl.ArticuloServiceImpl;
import com.amla.examen2.presenter.NuevoArticuloPresenter;
import com.amla.examen2.views.NuevoArticuloView;
import com.amla.examen2.views.impl.NuevoArticuloFragment;

public class NuevoArticuloPresenterImpl implements NuevoArticuloPresenter {
    private NuevoArticuloView mView;
    private ArticuloService articuloService;

    public NuevoArticuloPresenterImpl(NuevoArticuloFragment view){
        mView = view;
        articuloService = new ArticuloServiceImpl();
    }

    @Override
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
            articuloService.addArticulo(nombre, precio);
        } catch (Exception e) {
            mView.errorAlCrearArticulo();
            return;
        }

        mView.articuloCreado();
    }
}
