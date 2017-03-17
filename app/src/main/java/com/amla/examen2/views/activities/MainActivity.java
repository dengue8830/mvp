package com.amla.examen2.views.activities;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.amla.examen2.R;
import com.amla.examen2.presenter.MainPresenter;
import com.amla.examen2.views.fragments.ListadoPedidosFragment;
import com.amla.examen2.views.fragments.NuevoArticuloFragment;
import com.amla.examen2.views.fragments.NuevoPedidoFragment;

public class MainActivity extends AppCompatActivity{

    private BottomNavigationView navigation;
    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainPresenter(this);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mPresenter.opcionClickeada(item.getItemId(), R.id.navigation_nuevo_pedido, R.id.navigation_listado_pedidos, R.id.navigation_nuevo_articulo);
                return true;
            }

        });
        navegarHaciaPrimerTab();
    }

    private void navegarHaciaPrimerTab() {
        navigation.getMenu().findItem(R.id.navigation_listado_pedidos).setChecked(true);
        navegarListaPedidos();
    }

    public void navegarListaPedidos() {
        navegarHacia(ListadoPedidosFragment.newInstance());
    }


    public void navegarNuevoPedido() {
        navegarHacia(NuevoPedidoFragment.newInstance());
    }

    public void navegarNuevoArticulo() {
        navegarHacia(NuevoArticuloFragment.newInstance());
    }

    public void navegarHacia(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
