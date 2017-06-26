package com.billionman.com.assignment_11_4;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by CTM on 24-06-2017.
 */

public class DetailsDB extends SQLiteOpenHelper {
    public DetailsDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DetailsDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public DetailsDB(Context context) {
        super(context, "DetailsDB", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE DETAILS (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, FIRST_NAME TEXT NOT NULL, LAST_NAME TEXT)";
        db.execSQL(sql);
        writeData(db);
    }

    private void writeData(SQLiteDatabase db) {
        String q1 = "INSERT INTO DETAILS (ID,FIRST_NAME,LAST_NAME) values(?,?,?)";
        SQLiteStatement st = db.compileStatement(q1);
        st.bindString(2,"Mithun");
        st.bindString(3,"ct");
        st.execute();
        st = db.compileStatement(q1);
        st.bindString(2,"Rohan");
        st.bindString(3,"babu");
        st.execute();
        st = db.compileStatement(q1);
        st.bindString(2,"pavan");
        st.bindString(3,"ct");
        st.execute();
        st = db.compileStatement(q1);
        st.bindString(2,"tejasvi");
        st.bindString(3,"shankar");
        st.execute();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
