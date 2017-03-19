package com.amla.examen2.model.db.schema;

/**
 * Created by dengue8830 on 3/19/17.
 */

public class LineaPedidoSchema {
    public static final String TABLE_NAME = "LINEAS_PEDIDO";
    private static final String TIPO_INTEGER = " INTEGER ";
    private static final String SEP_COMMA = " , ";
    public static final String COLUMNA_ID = "ID";
    public static final String COLUMNA_PEDIDO_ID = "ID";
    public static final String COLUMNA_ARTICULO_ID = "ID_ARTICULO";
    public static final String COLUMNA_CANTIDAD = "CANTIDAD";
    public static final String[] CAMPOS = {
            COLUMNA_ID,
            COLUMNA_PEDIDO_ID,
            COLUMNA_ARTICULO_ID,
            COLUMNA_CANTIDAD
    };
    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMNA_ID + TIPO_INTEGER + " PRIMARY KEY " +
                    SEP_COMMA + COLUMNA_PEDIDO_ID + TIPO_INTEGER +
                    SEP_COMMA + COLUMNA_ARTICULO_ID + TIPO_INTEGER +
                    SEP_COMMA + COLUMNA_CANTIDAD + TIPO_INTEGER + " )";
}
