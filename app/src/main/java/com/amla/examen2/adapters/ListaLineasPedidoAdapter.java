package com.amla.examen2.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amla.examen2.R;
import com.amla.examen2.model.vo.Articulo;
import com.amla.examen2.model.vo.LineaPedido;
import com.amla.examen2.views.viewholder.LineaPedidoViewHolder;

import java.util.List;

public class ListaLineasPedidoAdapter extends RecyclerView.Adapter<LineaPedidoViewHolder>  {

    private List<LineaPedido> mLineasPedido;
    private final List<Articulo> mArticulos;
    private final Context mContext;

    public ListaLineasPedidoAdapter(List<LineaPedido> lineasPedido, List<Articulo> articulos, Context context) {
        mLineasPedido = lineasPedido;
        mArticulos = articulos;
        mContext = context;
    }

    @Override
    public LineaPedidoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nuevo_pedido_linea_pedido_layout, parent, false);
        return new LineaPedidoViewHolder(view, mContext, mArticulos);
    }

    @Override
    public void onBindViewHolder(final LineaPedidoViewHolder holder, int position) {
        holder.getPresenter().setLineaPedido(mLineasPedido.get(position));
    }

    @Override
    public int getItemCount() {
        return mLineasPedido.size();
    }
}
