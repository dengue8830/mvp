package com.amla.examen2.views.impl;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.amla.examen2.R;
import com.amla.examen2.presenter.MainPresenter;
import com.amla.examen2.presenter.impl.MainPresenterImpl;
import com.amla.examen2.views.MainView;

public class MainActivity extends AppCompatActivity implements MainView{

    private BottomNavigationView navigation;
    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainPresenterImpl(this);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mPresenter.opcionClickeada(item.getItemId(), R.id.navigation_nuevo_pedido, R.id.navigation_listado_pedidos, R.id.navigation_nuevo_articulo, R.id.navigation_nuevo_cliente);
                return true;
            }

        });
        navegarHaciaPrimerTab();
    }

    private void navegarHaciaPrimerTab() {
        navigation.getMenu().findItem(R.id.navigation_listado_pedidos).setChecked(true);
        navegarListaPedidos();
    }

    @Override
    public void navegarListaPedidos() {
        setTitle("Lista de pedidos");
        navegarHacia(ListadoPedidosFragment.newInstance());
    }

    @Override
    public void navegarNuevoPedido() {
        setTitle("Nuevo pedido");
        navegarHacia(NuevoPedidoFragment.newInstance());
    }

    @Override
    public void navegarNuevoArticulo() {
        setTitle("Nuevo artículo");
        navegarHacia(NuevoArticuloFragment.newInstance());
    }

    @Override
    public void navegarNuevoCliente() {
        setTitle("Nuevo cliente");
        navegarHacia(NuevoClienteFragment.newInstance());
    }

    public void navegarHacia(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
