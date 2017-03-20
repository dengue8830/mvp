package com.amla.examen2.model.dao.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.amla.examen2.model.dao.PedidoDao;
import com.amla.examen2.model.db.BD;
import com.amla.examen2.model.db.DbHelper;
import com.amla.examen2.model.db.schema.ArticuloSchema;
import com.amla.examen2.model.db.schema.LineaPedidoSchema;
import com.amla.examen2.model.db.schema.PedidoSchema;
import com.amla.examen2.model.vo.Articulo;
import com.amla.examen2.model.vo.Cliente;
import com.amla.examen2.model.vo.Pedido;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PedidoDaoImpl implements PedidoDao{
//    private DbHelper dbHelper;

//    public PedidoDaoImpl(Context context){
//        dbHelper = new DbHelper(context);
//    }

    public PedidoDaoImpl(){

    }

    public List<Pedido> getPedidos(){
        return BD.getPedidos();
        /*List<Pedido> pedidos = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sortOrderPedidos = PedidoSchema.COLUMNA_ID + " DESC";
        Cursor cursorPedidos = db.query(PedidoSchema.TABLE_NAME, PedidoSchema.CAMPOS, null, null, null, null, sortOrderPedidos);

        while (cursorPedidos.moveToNext()) {
            Calendar fecha = Calendar.getInstance();
            fecha.setTimeInMillis(cursorPedidos.getLong(cursorPedidos.getColumnIndex(PedidoSchema.COLUMNA_FECHA)));
            int pedidoId = cursorPedidos.getInt(cursorPedidos.getColumnIndex(PedidoSchema.COLUMNA_ID));
//            Pedido pedido = new Pedido(pedidoId, getLineasPedido(pedidoId, db), fecha);
//            pedidos.add(pedido);
        }
        cursorPedidos.close();
        dbHelper.close();
        return pedidos;*/
    }

    public void addPedido(Articulo articulo, Cliente cliente, int cantidad) {
        BD.insertPedido(articulo, cliente, cantidad);
    }

//    private List<LineaPedido> getLineasPedido(int pedidoId, SQLiteDatabase db) {
//        String selectionLineasPedido = LineaPedidoSchema.COLUMNA_PEDIDO_ID + " = ?";
//        String[] selectionArgsLineasPedido = { ""+ pedidoId};
//        String sortOrderLineaPedidos = LineaPedidoSchema.COLUMNA_ID + " DESC";
//        Cursor cursorLineaPedidos = db.query(PedidoSchema.TABLE_NAME, LineaPedidoSchema.CAMPOS, selectionLineasPedido, selectionArgsLineasPedido, null, null, sortOrderLineaPedidos);
//        List<LineaPedido> lineasPedido = new ArrayList<>();
//
//        while (cursorLineaPedidos.moveToNext()) {
//            String selection = ArticuloSchema.COLUMNA_ID + " = ?";
//            int articuloId = cursorLineaPedidos.getInt(cursorLineaPedidos.getColumnIndex(LineaPedidoSchema.COLUMNA_ARTICULO_ID));
//            String[] selectionArgs = { ""+ articuloId};
//            Cursor cursorArticulo = db.query(ArticuloSchema.TABLE_NAME, ArticuloSchema.CAMPOS, selection, selectionArgs, null, null, null);
//
//            Articulo articulo = new Articulo(
//                    cursorArticulo.getInt(cursorArticulo.getColumnIndex(ArticuloSchema.COLUMNA_ID)),
//                    cursorArticulo.getString(cursorArticulo.getColumnIndex(ArticuloSchema.COLUMNA_NOMBRE)),
//                    cursorArticulo.getDouble(cursorArticulo.getColumnIndex(ArticuloSchema.COLUMNA_PRECIO)));
//
//            cursorArticulo.close();
//
//            LineaPedido lineaPedido = new LineaPedido(
//                    cursorLineaPedidos.getInt(cursorLineaPedidos.getColumnIndex(LineaPedidoSchema.COLUMNA_ID)),
//                    articulo,
//                    cursorLineaPedidos.getInt(cursorLineaPedidos.getColumnIndex(LineaPedidoSchema.COLUMNA_CANTIDAD)));
//
//            lineasPedido.add(lineaPedido);
//        }
//        cursorLineaPedidos.close();
//
//        return lineasPedido;
//    }
}
