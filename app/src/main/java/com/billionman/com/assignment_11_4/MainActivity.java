package com.billionman.com.assignment_11_4;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String SQL_QUERY = "Select * from DETAILS";
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DetailsDB detailsDB = new DetailsDB(this);
        db = detailsDB.getReadableDatabase(); // DB open
        fetchData(db);
    }

    private void fetchData(SQLiteDatabase db) {
        List<String> data = new ArrayList<>();
        try (Cursor cursor = db.rawQuery(SQL_QUERY,null)) {
            cursor.moveToFirst();
            StringBuilder rowData = new StringBuilder();
            int count = 0;
            rowData.append(cursor.getColumnName(0) + ":" + cursor.getInt(0)).append(",")
                   .append(cursor.getColumnName(1) + ":" + cursor.getString(1)).append(",")
                   .append(cursor.getColumnName(2) + ":" + cursor.getString(2)).append(";");
            while (cursor.moveToNext()) {
                rowData.append("\n");
                rowData.append(cursor.getColumnName(0) + ":" + cursor.getInt(0)).append(",")
                       .append(cursor.getColumnName(1) + ":" + cursor.getString(1)).append(",")
                       .append(cursor.getColumnName(2) + ":" + cursor.getString(2)).append(";");
            }
            data.add(rowData.toString());
        }
        ArrayAdapter<String> listData = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        ListView lv = (ListView) findViewById(R.id.dataDetails);
        lv.setAdapter(listData);
    }
}
