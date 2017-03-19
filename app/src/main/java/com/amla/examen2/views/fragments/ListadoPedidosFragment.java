package com.amla.examen2.views.fragments;

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
import com.amla.examen2.presenter.ListadoPedidosPresenter;
import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;

public class ListadoPedidosFragment extends Fragment {
    private ListadoPedidosPresenter mPresenter;
    private ListadoPedidosAdapter mAdapter;
    private TextView tvFiltroFecha;
    private TextView tvTotalDias;

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
        mPresenter = new ListadoPedidosPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listadopedidos_list, container, false);

        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listaPedidos);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        mAdapter = new ListadoPedidosAdapter(mPresenter.getPedidos());
        recyclerView.setAdapter(mAdapter);

        tvTotalDias = (TextView) view.findViewById(R.id.total_dias);
        tvTotalDias.setText(mPresenter.getTotalDias());
        tvFiltroFecha = (TextView) view.findViewById(R.id.filtroFecha);
        tvFiltroFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.filtroFechaSeleccionado();
            }
        });
        return view;
    }

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

    public void updateListado() {
        mAdapter.notifyDataSetChanged();
    }

    public void updateFechaFiltroTextView(String fechaFiltro) {
        tvFiltroFecha.setText(fechaFiltro);
    }

    public void setTotalDias(String totalDias) {
        tvTotalDias.setText(totalDias);
    }
}
