package com.amla.examen2.presenter;

import com.amla.examen2.adapters.ListaLineasPedidoAdapter;
import com.amla.examen2.model.service.ArticuloService;
import com.amla.examen2.model.vo.Articulo;
import com.amla.examen2.model.vo.LineaPedido;

import java.util.ArrayList;
import java.util.List;

public class LineaPedidoViewHolderPresenter {
    private ListaLineasPedidoAdapter.ViewHolder mViewHolder;
    private LineaPedido mLineaPedido;

    public LineaPedidoViewHolderPresenter(ListaLineasPedidoAdapter.ViewHolder viewHolder){
        mViewHolder = viewHolder;
    }

    public static List<String> getNombresRadios() {
        List<String> nombesRadios = new ArrayList<>();

        for (Articulo articulo : ArticuloService.getArticulos()) {
            nombesRadios.add(articulo.getNombre());
        }

        return nombesRadios;
    }

    public void setArticulo(Articulo articulo) {
        mLineaPedido.setArticulo(articulo);
    }

    public void setCantidad(CharSequence cantidad) {
        if(!cantidad.toString().isEmpty())
            mLineaPedido.setCantidad(Integer.parseInt(cantidad.toString()));
    }

    public void setLineaPedido(LineaPedido lineaPedido) {
        mLineaPedido = lineaPedido;
    }
}
