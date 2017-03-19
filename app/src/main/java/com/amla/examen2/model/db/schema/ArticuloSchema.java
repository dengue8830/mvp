package com.amla.examen2.model.db.schema;

/**
 * Created by dengue8830 on 3/19/17.
 */

public class ArticuloSchema {
    public static final String TABLE_NAME = "ARTICULOS";
    private static final String TIPO_INTEGER = " INTEGER ";
    private static final String TIPO_REAL = " REAL ";
    private static final String TIPO_TEXT = " TEXT ";
    private static final String SEP_COMMA = " , ";
    public static final String COLUMNA_ID = "ID";
    public static final String COLUMNA_NOMBRE = "NOMBRE";
    public static final String COLUMNA_PRECIO = "PRECIO";
    public static final String[] CAMPOS = {
            COLUMNA_ID,
            COLUMNA_NOMBRE,
            COLUMNA_PRECIO
    };
    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMNA_ID + TIPO_INTEGER + " PRIMARY KEY " +
                    SEP_COMMA + COLUMNA_NOMBRE + TIPO_TEXT +
                    SEP_COMMA + COLUMNA_PRECIO + TIPO_REAL + " )";
}
