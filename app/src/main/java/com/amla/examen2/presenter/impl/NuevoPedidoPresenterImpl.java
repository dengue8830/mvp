package com.amla.examen2.presenter.impl;

import com.amla.examen2.model.service.ArticuloService;
import com.amla.examen2.model.service.PedidoService;
import com.amla.examen2.model.service.impl.ArticuloServiceImpl;
import com.amla.examen2.model.service.ClienteService;
import com.amla.examen2.model.service.impl.PedidoServiceImpl;
import com.amla.examen2.model.vo.Articulo;
import com.amla.examen2.model.vo.Cliente;
import com.amla.examen2.presenter.NuevoPedidoPresenter;
import com.amla.examen2.views.NuevoPedidoVIew;
import com.amla.examen2.views.impl.NuevoPedidoFragment;

import java.util.ArrayList;
import java.util.List;

public class NuevoPedidoPresenterImpl implements NuevoPedidoPresenter {
    private NuevoPedidoVIew mView;
    private ArticuloService articuloService;
    private PedidoService pedidoService;

    public NuevoPedidoPresenterImpl(NuevoPedidoVIew view) {
        mView = view;
        articuloService = new ArticuloServiceImpl();
        pedidoService = new PedidoServiceImpl();
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
            articulo = articuloService.getArticulos().get(posicionArticuloSeleccionado);
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
            pedidoService.addPedido(articulo, cliente, cantidad);
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

        for (Articulo articulo : articuloService.getArticulos()){
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
