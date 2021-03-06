package com.amla.examen2.views.impl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.amla.examen2.R;
import com.amla.examen2.presenter.NuevoPedidoPresenter;
import com.amla.examen2.presenter.impl.NuevoPedidoPresenterImpl;
import com.amla.examen2.views.NuevoPedidoVIew;

import java.util.List;

public class NuevoPedidoFragment extends Fragment implements NuevoPedidoVIew{
    private NuevoPedidoPresenter mPresenter;
    private Spinner mArticulo;
    private TextView mCantidad;
    private Spinner mClientes;

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
        mPresenter = new NuevoPedidoPresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nuevo_pedido, container, false);

        mArticulo = (Spinner) view.findViewById(R.id.spinnerArticulo);
        mClientes = (Spinner) view.findViewById(R.id.spinnerCliente);
        mCantidad = (TextView) view.findViewById(R.id.cantidad);

        view.findViewById(R.id.btnGuardarPedido).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.addPedido(mClientes.getSelectedItemPosition(), mArticulo.getSelectedItemPosition(), mCantidad.getText().toString());
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
    public void setArticulos(List<String> articulos){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.simple_spinner_item, articulos);
        adapter.setDropDownViewResource(R.layout.layout_spinner_dropdown_primary_item);
        mArticulo.setAdapter(adapter);
    }

    @Override
    public void setClientes(List<String> clientes){
        ArrayAdapter<String> adapterClientes = new ArrayAdapter<>(getContext(), R.layout.simple_spinner_item, clientes);
        adapterClientes.setDropDownViewResource(R.layout.layout_spinner_dropdown_primary_item);
        mClientes.setAdapter(adapterClientes);
    }

    @Override
    public void setCantidad(int cantidad){
        mCantidad.setText(cantidad == 0 ? "" : cantidad+"");
    }

    @Override
    public void errorAlGuardarPedido() {
        Toast.makeText(getContext(), "Error al guardar el pedido", Toast.LENGTH_LONG).show();
    }

    @Override
    public void pedidoGuardado() {
        Toast.makeText(getContext(), "Listo!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void mostrarErrorSinArticulo() {
        Toast.makeText(getContext(), "Todas las lineas de pedido deben tener articulo", Toast.LENGTH_LONG).show();
    }

    @Override
    public void mostrarErrorCantidadDebeSerMayorAcero() {
        Toast.makeText(getContext(), "Las cantidades deben ser mayor a cero", Toast.LENGTH_LONG).show();
    }

    @Override
    public void mostrarErrorIngresarCantidad() {
        Toast.makeText(getContext(), "Debes ingresar una cantidad", Toast.LENGTH_LONG).show();
    }

    @Override
    public void mostrarErrorSinCliente() {
        Toast.makeText(getContext(), "Debes elegir un cliente", Toast.LENGTH_LONG).show();
    }
}
