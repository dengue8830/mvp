package com.amla.examen2;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.amla.examen2.views.fragments.ListadoPedidosFragment;
import com.amla.examen2.views.fragments.NuevoArticuloFragment;
import com.amla.examen2.views.fragments.NuevoPedidoFragment;
import com.amla.examen2.model.vo.Pedido;

public class MainActivity extends AppCompatActivity implements ListadoPedidosFragment.OnListFragmentInteractionListener{

    private BottomNavigationView navigation;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragmentoGenerico;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentoGenerico = ListadoPedidosFragment.newInstance();
                    break;
                case R.id.navigation_dashboard:
                    fragmentoGenerico = NuevoPedidoFragment.newInstance();
                    break;
                case R.id.navigation_notifications:
                    fragmentoGenerico = NuevoArticuloFragment.newInstance();
                    break;
                default:
                    fragmentoGenerico = ListadoPedidosFragment.newInstance();
            }

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragmentoGenerico).commit();

            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navegarHaciaPrimerTab();
    }

    private void navegarHaciaPrimerTab() {
        navigation.getMenu().findItem(R.id.navigation_home).setChecked(true);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, ListadoPedidosFragment.newInstance()).commit();
    }

    @Override
    public void onListFragmentInteraction(Pedido item) {
        System.out.println("el pedido es: "+item.getId());
    }
}
