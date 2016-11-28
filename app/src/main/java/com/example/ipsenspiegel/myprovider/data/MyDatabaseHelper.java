package com.example.ipsenspiegel.myprovider.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by A5Alumno on 28/11/2016.
 */

//en la solución es MyDatabase

public class MyDatabaseHelper extends SQLiteOpenHelper{


    private static final String CREATE_DB_TABLE = "CREATE TABLE " + ParamsDb.TABLE_NAME + " ("
            + ParamsDb._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ParamsDb.STUDENT_NAME+ " TEXT, "
            + ParamsDb.STUDENT_AGE+ "INTEGER);";

    //base de datos se crea en el constructor que se ejecuta una vez
    public MyDatabaseHelper(Context context) {
        super(context, ParamsDb.DB_NAME, null, ParamsDb.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MyDatabaseHelper.CREATE_DB_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
