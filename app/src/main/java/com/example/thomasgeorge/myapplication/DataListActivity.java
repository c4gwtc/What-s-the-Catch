package com.example.thomasgeorge.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;

public class DataListActivity extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase db;
    FishDbConn fishDbConn;
    Cursor cursor;
    ListDataAdapter listDataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.list_view);
        listDataAdapter = new ListDataAdapter(getApplicationContext(),R.layout.row_layout);
        fishDbConn=new FishDbConn(getApplicationContext());
        db = fishDbConn.getReadableDatabase();
        cursor = fishDbConn.getinfo(db);
        if(cursor.moveToFirst())
        {
            do{
                String name,mouth,tail,id;
                //id=cursor.getString(0);
                name=cursor.getString(0);
                mouth=cursor.getString(1);
                tail=cursor.getString(2);
                DataProvider dataProvider = new DataProvider(name,mouth,tail);
                Log.e("data",tail);
                listDataAdapter.add(dataProvider);
            }while(cursor.moveToNext());
        }


    }

}
