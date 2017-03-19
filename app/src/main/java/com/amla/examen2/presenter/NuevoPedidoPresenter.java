package com.amla.examen2.presenter;

import com.amla.examen2.model.service.ArticuloService;
import com.amla.examen2.model.service.PedidoService;
import com.amla.examen2.model.vo.Articulo;
import com.amla.examen2.model.vo.LineaPedido;
import com.amla.examen2.views.fragments.NuevoPedidoFragment;

import java.util.ArrayList;
import java.util.List;

public class NuevoPedidoPresenter {

    private NuevoPedidoFragment mView;
    private List<LineaPedido> mLineasPedido;

    public NuevoPedidoPresenter(NuevoPedidoFragment view) {
        mView = view;
        mLineasPedido = new ArrayList<>();
        mLineasPedido.add(new LineaPedido());
//        inicializarLineasPedido();
    }

    private void inicializarLineasPedido(){
//        mLineasPedido = new ArrayList<>();
        mLineasPedido.clear();
        mLineasPedido.add(new LineaPedido());
    }

    public List<Articulo> getArticulos() {
        return  ArticuloService.getArticulos();
    }

    public void addLineaPedido() {
        mLineasPedido.add(new LineaPedido());
        mView.updateListado();
    }

    public void addPedido() {
        for (LineaPedido lineaPedido : mLineasPedido) {
            if(lineaPedido.getArticulo() == null){
                mView.mostrarErrorSinArticulo();
                return;
            }

            if(lineaPedido.getCantidad() == 0) {
                mView.mostrarErrorCantidadDebeSerMayorAcero();
                return;
            }

        }

        try {
            List<LineaPedido> cloned = new ArrayList<>();
            cloned.addAll(mLineasPedido);
            PedidoService.addPedido(cloned);
        } catch (Exception e) {
            mView.errorAlGuardarPedido();
        }

//        inicializarLineasPedido();
        mLineasPedido.clear();
        mView.updateListado();
        mLineasPedido.add(new LineaPedido());
        mView.updateListado();

        mView.pedidoGuardado();
    }

    public List<LineaPedido> getLineasPedido(){
        return mLineasPedido;
    }
}
