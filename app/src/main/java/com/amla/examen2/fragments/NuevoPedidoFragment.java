package com.amla.examen2.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.amla.examen2.R;
import com.amla.examen2.adapters.ListaLineasPedidoAdapter;
import com.amla.examen2.service.ArticuloService;
import com.amla.examen2.service.PedidoService;
import com.amla.examen2.vo.LineaPedido;

import java.util.ArrayList;
import java.util.List;

public class NuevoPedidoFragment extends Fragment {
    private List<LineaPedido> mLineasPedido;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nuevo_pedido, container, false);

        mLineasPedido = new ArrayList<>();
        mLineasPedido.add(new LineaPedido());
        mAdapter = new ListaLineasPedidoAdapter(mLineasPedido, ArticuloService.getArticulos(), view.getContext());

        recyclerView = (RecyclerView) view.findViewById(R.id.lista_lineas_pedido);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(mAdapter);

        Button btnNuevaLineaPedido = (Button) view.findViewById(R.id.btnNuevaLineaPedido);
        btnNuevaLineaPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLineasPedido.add(new LineaPedido());
                mAdapter.notifyDataSetChanged();
            }
        });
        Button btnGuardarPedido = (Button) view.findViewById(R.id.btnGuardarPedido);
        btnGuardarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PedidoService.addPedido(mLineasPedido);
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}
