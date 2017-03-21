package com.amla.examen2;

import com.amla.examen2.model.vo.Pedido;
import com.amla.examen2.presenter.ListadoPedidosPresenter;
import com.amla.examen2.presenter.impl.ListadoPedidosPresenterImpl;
import com.amla.examen2.views.ListadoPedidosView;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExamenTest {

    @Test
    public void filtroFechaSeleccionadoEsHoy() throws Exception {
        TestListadoPedidosView view = new TestListadoPedidosView();
        view.onResume();
        view.getPresenter().filtroFechaSeleccionado();
    }

    private class TestListadoPedidosView implements ListadoPedidosView {
        private ListadoPedidosPresenter presenter;
        public ListadoPedidosPresenter getPresenter(){
            return presenter;
        }
        public TestListadoPedidosView(){
            this.presenter = new ListadoPedidosPresenterImpl(this);

        }
        public void onResume(){
            presenter.onResume();
        }
        @Override
        public void setPedidos(List<Pedido> pedidos) {

        }

        @Override
        public void setTotalDias(String totalDias) {

        }

        @Override
        public void abrirDialogFecha(int diaDelMes, int mesDelAno, int ano) {
            Calendar cal = Calendar.getInstance();
            assertTrue(diaDelMes == cal.get(Calendar.DAY_OF_MONTH) && mesDelAno == cal.get(Calendar.MONTH) && ano == cal.get(Calendar.YEAR));
        }

        @Override
        public void updateFechaFiltro(String fechaFiltro) {

        }

        @Override
        public void updateListado() {

        }
    }
}