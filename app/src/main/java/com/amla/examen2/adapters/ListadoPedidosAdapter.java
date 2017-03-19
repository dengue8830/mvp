package com.amla.examen2.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amla.examen2.R;
import com.amla.examen2.model.vo.Pedido;

import org.w3c.dom.Text;

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
        holder.mTotal.setText(holder.mPedido.getTotal()+"");
        holder.mCliente.setText(holder.mPedido.getCliente().getNombre());
    }

    @Override
    public int getItemCount() {
        return mPedidos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mTotal;
        final TextView mCliente;
        Pedido mPedido;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mTotal = (TextView) view.findViewById(R.id.total);
            mCliente = (TextView) view.findViewById(R.id.cliente);
        }
    }
}
