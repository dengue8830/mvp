package com.amla.examen2.views.impl;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amla.examen2.R;
import com.amla.examen2.adapters.ListadoPedidosAdapter;
import com.amla.examen2.dto.DatePickerDTO;
import com.amla.examen2.model.vo.Pedido;
import com.amla.examen2.presenter.ListadoPedidosPresenter;
import com.amla.examen2.presenter.impl.ListadoPedidosPresenterImpl;
import com.amla.examen2.views.ListadoPedidosView;
import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;

import java.util.List;

public class ListadoPedidosFragment extends Fragment implements ListadoPedidosView {
    private ListadoPedidosPresenter mPresenter;
    private ListadoPedidosAdapter mAdapter;
    private TextView tvFiltroFecha;
    private TextView tvTotalDias;
    private RecyclerView rvPedidos;

    /**
     * Mandatory empty constructor
     */
    public ListadoPedidosFragment() {
    }

    public static ListadoPedidosFragment newInstance() {
        return new ListadoPedidosFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new ListadoPedidosPresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listadopedidos_list, container, false);

        Context context = view.getContext();
        rvPedidos = (RecyclerView) view.findViewById(R.id.listaPedidos);
        rvPedidos.setLayoutManager(new LinearLayoutManager(context));

        tvTotalDias = (TextView) view.findViewById(R.id.total_dias);
        tvFiltroFecha = (TextView) view.findViewById(R.id.filtroFecha);
        tvFiltroFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.filtroFechaSeleccionado();
            }
        });
        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void setPedidos(List<Pedido> pedidos){
        if(mAdapter == null){
            mAdapter = new ListadoPedidosAdapter(pedidos);
            rvPedidos.setAdapter(mAdapter);
        }
    }

    @Override
    public void abrirDialogFecha(DatePickerDTO dto){
        DatePickerBuilder dpb = new DatePickerBuilder()
                .setFragmentManager(getActivity().getSupportFragmentManager())
                .setStyleResId(R.style.BetterPickersDialogFragment_Light)
                .setDayOfMonth(dto.getDiaDelMes())
                .setMonthOfYear(dto.getMesDelAno())
                .setYear(dto.getAno())
                .setYearOptional(false)
                .addDatePickerDialogHandler(mPresenter);
        dpb.show();
    }

    @Override
    public void updateListado() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void updateFechaFiltro(String fechaFiltro) {
        tvFiltroFecha.setText(fechaFiltro);
    }

    @Override
    public void setTotalDias(String totalDias) {
        tvTotalDias.setText(totalDias);
    }
}
