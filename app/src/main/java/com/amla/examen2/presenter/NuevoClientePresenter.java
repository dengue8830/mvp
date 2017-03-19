package com.amla.examen2.presenter;

import com.amla.examen2.model.service.ClienteService;
import com.amla.examen2.views.fragments.NuevoClienteFragment;

public class NuevoClientePresenter {
    private NuevoClienteFragment mView;

    public NuevoClientePresenter(NuevoClienteFragment view){
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
