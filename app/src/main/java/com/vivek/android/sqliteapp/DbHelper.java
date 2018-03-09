package com.vivek.android.sqliteapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by android2 on 9/3/18.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "test.db";
    public static final String TABLE_NAME = "test_table";
    public static final String FIELD_FIRST = "test_name";
    public static final String FIELD_SECOND = "test_type";

    public DbHelper(Context context/*, String name, SQLiteDatabase.CursorFactory factory, int version*/) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + FIELD_FIRST + ", " + FIELD_SECOND + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + "");
    }
}
