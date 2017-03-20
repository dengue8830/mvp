package com.amla.examen2.views.impl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.amla.examen2.R;
import com.amla.examen2.presenter.NuevoClientePresenter;
import com.amla.examen2.presenter.impl.NuevoClientePresenterImpl;
import com.amla.examen2.views.NuevoClienteView;

public class NuevoClienteFragment extends Fragment implements NuevoClienteView {

    private NuevoClientePresenter mPresenter;
    private EditText etNombre;
    private EditText etDireccion;

    public NuevoClienteFragment() {
        // Required empty public constructor
    }

    public static NuevoClienteFragment newInstance() {
        NuevoClienteFragment fragment = new NuevoClienteFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new NuevoClientePresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nuevo_cliente, container, false);
        etNombre = (EditText) view.findViewById(R.id.nuevo_cliente_nombre);
        etDireccion = (EditText) view.findViewById(R.id.nuevo_cliente_direccion);
        view.findViewById(R.id.btn_guardar_cliente).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.crearCliente(etNombre.getText().toString(), etDireccion.getText().toString());
            }
        });

        return view;
    }

    @Override
    public void errorAlCrearCliente() {
        Toast.makeText(getContext(), "Error al crear el cliente", Toast.LENGTH_LONG).show();
    }

    @Override
    public void clienteCreado() {
        Toast.makeText(getContext(), "Listo!", Toast.LENGTH_LONG).show();
        etNombre.setText("");
        etDireccion.setText("");
    }

    @Override
    public void mostrarErrorNombreVacio() {
        Toast.makeText(getContext(), "Ingresa un nombre", Toast.LENGTH_LONG).show();
    }

    @Override
    public void mostrarErrorDireccionVacia() {
        Toast.makeText(getContext(), "Ingresa una dirección", Toast.LENGTH_LONG).show();
    }
}
