package com.amla.examen2.views.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.amla.examen2.R;
import com.amla.examen2.model.vo.Articulo;
import com.amla.examen2.presenter.LineaPedidoViewHolderPresenter;

import java.util.List;

/**
 * Created by dengue8830 on 3/17/17.
 */

public class LineaPedidoViewHolder extends RecyclerView.ViewHolder {
    private final Spinner mArticulo;
    private final TextView mCantidad;
    private LineaPedidoViewHolderPresenter mPresenter;
    private Context mContext;
    private List<Articulo> mArticulos;

    public LineaPedidoViewHolder(View view, Context context, List<Articulo> articulos) {
        super(view);
        mArticulos = articulos;
        mContext = context;
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
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPresenter.setCantidad(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public LineaPedidoViewHolderPresenter getPresenter(){
        return mPresenter;
    }

    public void setCantidad(int cantidad) {
        mCantidad.setText(cantidad == 0 ? "" : cantidad + "");
    }

    public void setArticulo(Integer posicionArticulo) {
        if(posicionArticulo != null){
            mArticulo.setSelection(posicionArticulo);
        }
    }
}
