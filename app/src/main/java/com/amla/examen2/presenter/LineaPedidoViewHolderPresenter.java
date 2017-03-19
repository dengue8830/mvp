package com.amla.examen2.presenter;

import com.amla.examen2.model.service.ArticuloService;
import com.amla.examen2.model.vo.Articulo;
import com.amla.examen2.model.vo.LineaPedido;
import com.amla.examen2.views.viewholder.LineaPedidoViewHolder;

import java.util.ArrayList;
import java.util.List;

public class LineaPedidoViewHolderPresenter {
    private LineaPedidoViewHolder mViewHolder;
    private LineaPedido mLineaPedido;

    public LineaPedidoViewHolderPresenter(LineaPedidoViewHolder viewHolder){
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
        mViewHolder.setCantidad(mLineaPedido.getCantidad());
        List<Articulo> articulos = ArticuloService.getArticulos();

        if (mLineaPedido.getArticulo() == null) {
            if (!articulos.isEmpty()) {
                mLineaPedido.setArticulo(ArticuloService.getArticulos().get(0));
                mViewHolder.setArticulo(0);
            } else {
                mViewHolder.setArticulo(null);
            }
        } else {
            mViewHolder.setArticulo(getPosicionArticulo());
        }
    }

    public Integer getPosicionArticulo() {
        List<Articulo> articulos = ArticuloService.getArticulos();

        for (int i = 0; i < articulos.size(); i++) {
            if(mLineaPedido.getArticulo().getId() == articulos.get(i).getId()){
                return i;
            }
        }

        return 0;
    }
}
