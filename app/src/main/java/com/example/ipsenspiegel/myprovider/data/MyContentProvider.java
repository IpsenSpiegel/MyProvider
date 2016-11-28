package com.example.ipsenspiegel.myprovider.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

public class MyContentProvider extends ContentProvider {

    private static final String TAG = MyContentProvider.class.getSimpleName();
    private static final String PROVIDER_AUTHORITY = "com.example.ipsenspiegel.myprovider.data";
    public static final Uri CONTEXT_URI = Uri.parse("content://" + MyContentProvider.PROVIDER_AUTHORITY);

    private MyDatabaseHelper myDatabaseHelper;


    public MyContentProvider() {
    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = this.myDatabaseHelper.getWritableDatabase();

        // se puede a lo bruto pero teniendo abstracciones
        //db.execSQL("INSERT INTO ");

        long regID = db.insert(paramsDb.TABLE_NAME, null, values);

        return ContentUris.withAppendedId(MyContentProvider.CONTEXT_URI, regID);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = this.myDatabaseHelper.getWritableDatabase();

        return db.delete(paramsDb.TABLE_NAME, selection, selectionArgs);
    }

    @Override
    public boolean onCreate() {
        this.myDatabaseHelper = new MyDatabaseHelper(this.getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = this.myDatabaseHelper.getReadableDatabase();
        return db.query(paramsDb.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);

    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
