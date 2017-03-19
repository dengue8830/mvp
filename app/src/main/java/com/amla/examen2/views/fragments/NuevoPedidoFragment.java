package com.amla.examen2.views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.amla.examen2.R;
import com.amla.examen2.adapters.ListaLineasPedidoAdapter;
import com.amla.examen2.presenter.NuevoPedidoPresenter;

public class NuevoPedidoFragment extends Fragment {
    private ListaLineasPedidoAdapter mAdapter;
    private NuevoPedidoPresenter mPresenter;

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

        mAdapter = new ListaLineasPedidoAdapter(mPresenter.getLineasPedido(), mPresenter.getArticulos(), view.getContext());

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.lista_lineas_pedido);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(mAdapter);

        view.findViewById(R.id.btnNuevaLineaPedido).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.addLineaPedido();
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

    public void updateListado(){
        mAdapter.notifyDataSetChanged();
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
