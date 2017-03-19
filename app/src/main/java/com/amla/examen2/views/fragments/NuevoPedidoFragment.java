package com.amla.examen2.views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.amla.examen2.R;
import com.amla.examen2.presenter.NuevoPedidoPresenter;

import java.util.ArrayList;
import java.util.List;

public class NuevoPedidoFragment extends Fragment {
    private NuevoPedidoPresenter mPresenter;
    private Spinner mArticulo;
    private TextView mCantidad;

    public NuevoPedidoFragment() {
        // Required empty public constructor
    }

    public static NuevoPedidoFragment newInstance() {
        NuevoPedidoFragment fragment = new NuevoPedidoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new NuevoPedidoPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nuevo_pedido, container, false);

        mArticulo = (Spinner) view.findViewById(R.id.spinner);

        mCantidad = (TextView) view.findViewById(R.id.cantidad);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.radiotul_simple_spinner_item, mPresenter.getNombresArticulos());
        adapter.setDropDownViewResource(R.layout.layout_radiotul_spinner_dropdown_primary_item);//android.R.layout.simple_spinner_dropdown_item
        mArticulo.setAdapter(adapter);
        mArticulo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mPresenter.setArticulo(position);
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

        view.findViewById(R.id.btnGuardarPedido).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.addPedido();
            }
        });

        return view;
    }


    public void errorAlGuardarPedido() {
        Toast.makeText(getContext(), "Error al guardar el pedido", Toast.LENGTH_LONG).show();
    }

    public void pedidoGuardado() {
        Toast.makeText(getContext(), "Listo!", Toast.LENGTH_LONG).show();
    }

    public void mostrarErrorSinArticulo() {
        Toast.makeText(getContext(), "Todas las lineas de pedido deben tener articulo", Toast.LENGTH_LONG).show();
    }

    public void mostrarErrorCantidadDebeSerMayorAcero() {
        Toast.makeText(getContext(), "Las cantidades deben ser mayor a cero", Toast.LENGTH_LONG).show();
    }
}
