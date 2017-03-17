package com.amla.examen2.views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amla.examen2.R;
import com.amla.examen2.model.service.ArticuloService;
import com.amla.examen2.presenter.NuevoArticuloPresenter;

public class NuevoArticuloFragment extends Fragment {

    private NuevoArticuloPresenter mPresenter;
    private EditText etNombre;
    private EditText etPrecio;

    public NuevoArticuloFragment() {
        // Required empty public constructor
    }

    public static NuevoArticuloFragment newInstance() {
        NuevoArticuloFragment fragment = new NuevoArticuloFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new NuevoArticuloPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nuevo_articulo, container, false);
        etNombre = (EditText) view.findViewById(R.id.nuevo_articulo_nombre);
        etPrecio = (EditText) view.findViewById(R.id.nuevo_articulo_precio);
        view.findViewById(R.id.btnGuardarArticulo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.crearArticulo(etNombre.getText().toString(), Double.parseDouble(etPrecio.getText().toString()));
            }
        });

        return view;
    }

    public void errorAlCrearArticulo() {
        Toast.makeText(getContext(), "Error al crear el artículo", Toast.LENGTH_LONG).show();
    }

    public void articuloCreado() {
        Toast.makeText(getContext(), "Listo!", Toast.LENGTH_LONG).show();
        etNombre.setText("");
        etPrecio.setText("");
    }
}
