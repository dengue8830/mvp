package com.amla.examen2.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amla.examen2.R;
import com.amla.examen2.views.fragments.ListadoPedidosFragment;
import com.amla.examen2.model.vo.Pedido;

import java.util.List;

public class ListadoPedidosAdapter extends RecyclerView.Adapter<ListadoPedidosAdapter.ViewHolder> {

    private final List<Pedido> mPedidos;

    public ListadoPedidosAdapter(List<Pedido> pedidos) {
        mPedidos = pedidos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_listadopedidos_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mPedido = mPedidos.get(position);
        holder.mCantidadLineasPedido.setText(mPedidos.get(position).getLineasPedido().size()+"");
        holder.mSubtotal.setText(mPedidos.get(position).getTotal()+"");
    }

    @Override
    public int getItemCount() {
        return mPedidos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mCantidadLineasPedido;
        final TextView mSubtotal;
        Pedido mPedido;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mCantidadLineasPedido = (TextView) view.findViewById(R.id.cantidad_lineas_pedido);
            mSubtotal = (TextView) view.findViewById(R.id.subtotal);
        }
    }
}
