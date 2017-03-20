package com.amla.examen2.presenter.impl;

import com.amla.examen2.model.service.ClienteService;
import com.amla.examen2.presenter.NuevoClientePresenter;
import com.amla.examen2.views.NuevoClienteView;
import com.amla.examen2.views.impl.NuevoClienteFragment;

public class NuevoClientePresenterImpl implements NuevoClientePresenter {
    private NuevoClienteView mView;

    public NuevoClientePresenterImpl(NuevoClienteFragment view){
        mView = view;
    }

    public void crearCliente(String nombre, String direccion){
        if(direccion == null || direccion.isEmpty()){
            mView.mostrarErrorDireccionVacia();
            return;
        }

        if(nombre == null || nombre.isEmpty()){
            mView.mostrarErrorNombreVacio();
            return;
        }

        try {
            ClienteService.addCliente(nombre, direccion);
        } catch (Exception e) {
            mView.errorAlCrearCliente();
            return;
        }

        mView.clienteCreado();
    }
}
