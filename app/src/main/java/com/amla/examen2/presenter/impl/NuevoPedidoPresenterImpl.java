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
    private Articulo articulo;
    private int cantidad;
    private Cliente cliente;

    public NuevoPedidoPresenterImpl(NuevoPedidoFragment view) {
        mView = view;
    }

    public void addPedido(int posicionClienteSelecionado, int posicionArticuloSeleccionado, String stringCantidad) {
        try{
            this.cantidad = Integer.parseInt(stringCantidad);
        } catch (Exception e) {
            mView.mostrarErrorIngresarCantidad();
            return;
        }

        try{
            cliente = ClienteService.getClientes().get(posicionClienteSelecionado);
        } catch (IndexOutOfBoundsException e) {
            mView.mostrarErrorSinCliente();
            return;
        }

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
    public List<String> getNombresArticulos(){
        List<String> nombresArticulos = new ArrayList<>();

        for (Articulo articulo : ArticuloService.getArticulos()){
            nombresArticulos.add(articulo.getNombre());
        }

        return nombresArticulos;
    }

    @Override
    public List<String> getNombresClientes() {
        List<String> nombresClientes = new ArrayList<>();

        for (Cliente cliente : ClienteService.getClientes()){
            nombresClientes.add(cliente.getNombre());
        }

        return nombresClientes;
    }
}
