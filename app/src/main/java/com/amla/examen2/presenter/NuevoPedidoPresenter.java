package com.amla.examen2.presenter;

import com.amla.examen2.model.service.ArticuloService;
import com.amla.examen2.model.service.PedidoService;
import com.amla.examen2.model.vo.Articulo;
import com.amla.examen2.views.fragments.NuevoPedidoFragment;

import java.util.ArrayList;
import java.util.List;

public class NuevoPedidoPresenter {

    private NuevoPedidoFragment mView;
    private Articulo articulo;
    private int cantidad;

    public NuevoPedidoPresenter(NuevoPedidoFragment view) {
        mView = view;
    }

    public List<Articulo> getArticulos() {
        return  ArticuloService.getArticulos();
    }

    public void addPedido() {
        if(articulo == null){
            mView.mostrarErrorSinArticulo();
            return;
        }

        if(cantidad == 0) {
            mView.mostrarErrorCantidadDebeSerMayorAcero();
            return;
        }

        try {
            PedidoService.addPedido(articulo, cantidad);
        } catch (Exception e) {
            mView.errorAlGuardarPedido();
        }

        mView.pedidoGuardado();
    }

    public void setArticulo(int posicionArticulo) {
        articulo = ArticuloService.getArticulos().get(posicionArticulo);
    }

    public void setCantidad(CharSequence cantidad) {
        try{
            this.cantidad = Integer.parseInt(cantidad.toString());
        } catch (Exception e) {
            mView.mostrarErrorCantidadDebeSerMayorAcero();
        }
    }

    public List<String> getNombresArticulos(){
        List<String> nombresArticulos = new ArrayList<>();

        for (Articulo articulo : ArticuloService.getArticulos()){
            nombresArticulos.add(articulo.getNombre());
        }

        return nombresArticulos;
    }
}
