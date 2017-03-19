package com.amla.examen2.model.db.schema;

/**
 * Created by dengue8830 on 3/19/17.
 */

public class PedidoSchema {
    public static final String TABLE_NAME = "PEDIDOS";
    private static final String TIPO_INTEGER = " INTEGER ";
    private static final String SEP_COMMA = " , ";
    public static final String COLUMNA_ID = "ID";
    public static final String COLUMNA_FECHA = "FECHA";
    public static final String[] CAMPOS = {
            COLUMNA_ID,
            COLUMNA_FECHA
    };
    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMNA_ID + TIPO_INTEGER + " PRIMARY KEY " +
                    SEP_COMMA + COLUMNA_FECHA + TIPO_INTEGER + " )";
}
