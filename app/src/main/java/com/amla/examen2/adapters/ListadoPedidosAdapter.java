package com.amla.examen2.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amla.examen2.R;
import com.amla.examen2.model.vo.Pedido;
import com.amla.examen2.presenter.ListadoPedidosItemPresenter;
import com.amla.examen2.presenter.impl.ListadoPedidosItemPresenterImpl;
import com.amla.examen2.views.ListadoPedidosItemView;

import java.util.List;

public class ListadoPedidosAdapter extends RecyclerView.Adapter<ListadoPedidosAdapter.ListadoPedidosItemViewHolder> {

    private final List<Pedido> mPedidos;

    public ListadoPedidosAdapter(List<Pedido> pedidos) {
        mPedidos = pedidos;
    }

    @Override
    public ListadoPedidosItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_listadopedidos_item, parent, false);
        return new ListadoPedidosItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListadoPedidosItemViewHolder holder, int position) {
        holder.mPresenter.onBindViewHolder(mPedidos.get(position));
    }

    @Override
    public int getItemCount() {
        return mPedidos.size();
    }

    class ListadoPedidosItemViewHolder extends RecyclerView.ViewHolder implements ListadoPedidosItemView{
        private final TextView mTotal;
        private final TextView mCliente;
        private final TextView mDetallePedido;
        private final TextView mLog;
        private final TextView mDireccionCliente;
        private final ListadoPedidosItemPresenter mPresenter;

        ListadoPedidosItemViewHolder(View view) {
            super(view);
            mTotal = (TextView) view.findViewById(R.id.total);
            mCliente = (TextView) view.findViewById(R.id.cliente);
            mDetallePedido = (TextView) view.findViewById(R.id.detalle_pedido);
            mLog = (TextView) view.findViewById(R.id.log);
            mDireccionCliente = (TextView) view.findViewById(R.id.direccion_cliente);
            mPresenter = new ListadoPedidosItemPresenterImpl(this);
        }

        @Override
        public void setTotal(String total){
            mTotal.setText(total);
        }

        @Override
        public void setCliente(String cliente){
            mCliente.setText(cliente);
        }

        @Override
        public void setDetalle(String detalle){
            mDetallePedido.setText(detalle);
        }

        @Override
        public void setLog(String log){
            mLog.setText(log);
        }

        @Override
        public void setDireccionCliente(String direccionCliente){
            mDireccionCliente.setText(direccionCliente);
        }
    }
}
