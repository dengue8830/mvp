package com.amla.examen2.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.Double2;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.amla.examen2.R;
import com.amla.examen2.service.ArticuloService;
import com.amla.examen2.vo.Articulo;

public class NuevoArticuloFragment extends Fragment {

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nuevo_articulo, container, false);
        final EditText etNombre = (EditText) view.findViewById(R.id.nuevo_articulo_nombre);
        final EditText etPrecio = (EditText) view.findViewById(R.id.nuevo_articulo_precio);
        Button btnGuardar = (Button) view.findViewById(R.id.btnGuardarArticulo);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArticuloService.addArticulo(etNombre.getText().toString(), Double.parseDouble(etPrecio.getText().toString()));
            }
        });

        return view;
    }
}
