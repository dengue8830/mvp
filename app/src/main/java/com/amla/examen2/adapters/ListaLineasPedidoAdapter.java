package com.amla.examen2.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.amla.examen2.R;
import com.amla.examen2.model.vo.Articulo;
import com.amla.examen2.model.vo.LineaPedido;
import com.amla.examen2.presenter.LineaPedidoViewHolderPresenter;

import java.util.List;

public class ListaLineasPedidoAdapter extends RecyclerView.Adapter<ListaLineasPedidoAdapter.ViewHolder>  {

    private List<LineaPedido> mLineasPedido;
    protected final List<Articulo> mArticulos;
    private final Context mContext;

    public ListaLineasPedidoAdapter(List<LineaPedido> lineasPedido, List<Articulo> articulos, Context context) {
        mLineasPedido = lineasPedido;
        mArticulos = articulos;
        mContext = context;
    }

    @Override
    public ListaLineasPedidoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nuevo_pedido_linea_pedido_layout, parent, false);
        return new ListaLineasPedidoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListaLineasPedidoAdapter.ViewHolder holder, int position) {
        holder.mPresenter.setLineaPedido(mLineasPedido.get(position));
    }

    @Override
    public int getItemCount() {
        return mLineasPedido.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final Spinner mArticulo;
        final TextView mCantidad;
        private LineaPedidoViewHolderPresenter mPresenter;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mArticulo = (Spinner) view.findViewById(R.id.spinner);
            mCantidad = (TextView) view.findViewById(R.id.cantidad);
            mPresenter = new LineaPedidoViewHolderPresenter(this);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext, R.layout.radiotul_simple_spinner_item, LineaPedidoViewHolderPresenter.getNombresRadios());
            adapter.setDropDownViewResource(R.layout.layout_radiotul_spinner_dropdown_primary_item);//android.R.layout.simple_spinner_dropdown_item
            mArticulo.setAdapter(adapter);
            mArticulo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    mPresenter.setArticulo(mArticulos.get(position));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
            mCantidad.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    mPresenter.setCantidad(s);
                }

                @Override
                public void afterTextChanged(Editable s) {}
            });
        }

    }
}
