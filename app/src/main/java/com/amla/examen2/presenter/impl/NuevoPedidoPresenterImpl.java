package com.amla.examen2.presenter.impl;

import com.amla.examen2.model.service.ArticuloService;
import com.amla.examen2.model.service.ClienteService;
import com.amla.examen2.model.service.PedidoService;
import com.amla.examen2.model.vo.Articulo;
import com.amla.examen2.model.vo.Cliente;
import com.amla.examen2.presenter.NuevoPedidoPresenter;
import com.amla.examen2.views.impl.NuevoPedidoFragment;

import java.util.ArrayList;
import java.util.List;

public class NuevoPedidoPresenterImpl implements NuevoPedidoPresenter {

    private NuevoPedidoFragment mView;

    public NuevoPedidoPresenterImpl(NuevoPedidoFragment view) {
        mView = view;
    }

    @Override
    public void addPedido(int posicionClienteSelecionado, int posicionArticuloSeleccionado, String stringCantidad) {
        int cantidad;
        try{
            cantidad = Integer.parseInt(stringCantidad);
        } catch (Exception e) {
            mView.mostrarErrorIngresarCantidad();
            return;
        }

        Cliente cliente;
        try{
            cliente = ClienteService.getClientes().get(posicionClienteSelecionado);
        } catch (IndexOutOfBoundsException e) {
            mView.mostrarErrorSinCliente();
            return;
        }

        Articulo articulo;
        try{
            articulo = ArticuloService.getArticulos().get(posicionArticuloSeleccionado);
        } catch (IndexOutOfBoundsException e) {
            mView.mostrarErrorSinArticulo();
            return;
        }

        if(articulo == null){
            mView.mostrarErrorSinArticulo();
            return;
        }

        if(cliente == null){
            mView.mostrarErrorSinCliente();
            return;
        }

        if(cantidad == 0) {
            mView.mostrarErrorCantidadDebeSerMayorAcero();
            return;
        }

        try {
            PedidoService.addPedido(articulo, cliente, cantidad);
        } catch (Exception e) {
            mView.errorAlGuardarPedido();
            return;
        }

        cantidad = 0;
        mView.pedidoGuardado();
        mView.setCantidad(cantidad);
    }

    @Override
    public void onResume() {
        mView.setArticulos(getNombresArticulos());
        mView.setClientes(getNombresClientes());
    }

    private List<String> getNombresArticulos(){
        List<String> nombresArticulos = new ArrayList<>();

        for (Articulo articulo : ArticuloService.getArticulos()){
            nombresArticulos.add(articulo.getNombre());
        }

        return nombresArticulos;
    }

    private List<String> getNombresClientes() {
        List<String> nombresClientes = new ArrayList<>();

        for (Cliente cliente : ClienteService.getClientes()){
            nombresClientes.add(cliente.getNombre());
        }

        return nombresClientes;
    }
}
