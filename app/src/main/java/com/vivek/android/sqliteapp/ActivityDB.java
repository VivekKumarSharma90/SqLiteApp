package com.vivek.android.sqliteapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class ActivityDB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        ArrayList<String> arrFirst = new ArrayList<>();
        ArrayList<String> arrSecond = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = new DbHelper(ActivityDB.this).getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.FIELD_FIRST, "First");
        contentValues.put(DbHelper.FIELD_SECOND, "Learning");

        sqLiteDatabase.insert(DbHelper.TABLE_NAME, null, contentValues);

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + DbHelper.TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                arrFirst.add(cursor.getString(cursor.getColumnIndex(DbHelper.FIELD_FIRST)));
                arrSecond.add(cursor.getString(cursor.getColumnIndex(DbHelper.FIELD_SECOND)));

            } while (cursor.moveToNext());

            Log.i("first_field", "" + arrFirst);
            Log.i("second_field", "" + arrSecond);
        }
    }
}
