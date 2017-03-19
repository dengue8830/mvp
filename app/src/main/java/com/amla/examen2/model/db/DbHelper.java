package com.amla.examen2.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.amla.examen2.model.db.schema.ArticuloSchema;
import com.amla.examen2.model.db.schema.LineaPedidoSchema;
import com.amla.examen2.model.db.schema.PedidoSchema;

public class DbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Examen2.db";

    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PedidoSchema.SQL_CREATE);
        db.execSQL(LineaPedidoSchema.SQL_CREATE);
        db.execSQL(ArticuloSchema.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
