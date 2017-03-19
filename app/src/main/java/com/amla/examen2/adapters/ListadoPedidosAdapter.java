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
        //TODO: Un presentador deberia formatear el texto y darselo
        holder.mCliente.setText(holder.mPedido.getCliente().getNombre());
        holder.mTotal.setText(" total: $"+holder.mPedido.getTotal());
        holder.mDetallePedido.setText(holder.mPedido.getCantidad()+" x "+holder.mPedido.getArticulo().getNombre() + " ( c/u $"+holder.mPedido.getArticulo().getPrecio()+")");
    }

    @Override
    public int getItemCount() {
        return mPedidos.size();
    }

    // TODO: debe encapsular los atributos...
    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mTotal;
        final TextView mCliente;
        final TextView mDetallePedido;
        Pedido mPedido;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mTotal = (TextView) view.findViewById(R.id.total);
            mCliente = (TextView) view.findViewById(R.id.cliente);
            mDetallePedido = (TextView) view.findViewById(R.id.detalle_pedido);
        }
    }
}
