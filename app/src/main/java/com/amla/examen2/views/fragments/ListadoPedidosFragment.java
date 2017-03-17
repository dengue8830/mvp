package com.amla.examen2.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amla.examen2.R;
import com.amla.examen2.adapters.ListadoPedidosAdapter;
import com.amla.examen2.model.service.PedidoService;
import com.amla.examen2.presenter.ListadoPedidosPresenter;

public class ListadoPedidosFragment extends Fragment {
    private ListadoPedidosPresenter presenter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListadoPedidosFragment() {
    }

    public static ListadoPedidosFragment newInstance() {
        ListadoPedidosFragment fragment = new ListadoPedidosFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ListadoPedidosPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listadopedidos_list, container, false);

        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new ListadoPedidosAdapter(PedidoService.getPedidos()));

        return view;
    }
}
