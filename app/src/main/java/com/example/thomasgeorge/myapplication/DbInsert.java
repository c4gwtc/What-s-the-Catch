package com.example.thomasgeorge.myapplication;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ThomasGeorge on 10/13/2015.
 */
public class DbInsert extends Activity{

    Context context;
    FishDbConn fishdbconn;
    SQLiteDatabase db;
    EditText name,mouth,dorsalfin,tail;
    TextView tv;
    Button insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dbinsert);
        name=(EditText) findViewById(R.id.fishname);
        mouth=(EditText) findViewById(R.id.fishmouth);
        dorsalfin=(EditText) findViewById(R.id.fishdorsalfin);
        tail=(EditText) findViewById(R.id.fishtail);
        tv=(TextView) findViewById(R.id.textView);
        DBAdapter(this);


    }
    public void DBAdapter(Context ctx){//I think this might go up in the constructor
        this.context=ctx;
        fishdbconn=new FishDbConn(context);
    }

    public void addRow(View view){
/*
        //String fishname=name.getText().toString();
        String fishmouth=mouth.getText().toString();
        String fishdorsalfin=dorsalfin.getText().toString();
        String fishtail=tail.getText().toString();
        fishdbconn = new FishDbConn(getBaseContext());
        db = fishdbconn.getWritableDatabase();
        //fishdbconn.onCreate(db);
        //fishdbconn.insertop(fishname,fishmouth,fishdorsalfin,fishtail,db);
        Toast.makeText(getBaseContext(), "Data inserted", Toast.LENGTH_LONG).show();
        fishdbconn.close();
*/
        String fishmouth=mouth.getText().toString();
        String fishdorsalfin=dorsalfin.getText().toString();
        String fishtail=tail.getText().toString();
        try {
        fishdbconn = new FishDbConn(getBaseContext());
        db = fishdbconn.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT " + FishDb.fishdb1.FISH_NAME + " FROM " + FishDb.fishdb1.TABLE_NAME + " WHERE " + FishDb.fishdb1.FISH_TAIL + " = '" + fishtail + "' AND " + FishDb.fishdb1.FISH_MOUTH + " = '" + fishmouth + "' AND " + FishDb.fishdb1.FISH_DORSALFIN + " = '" + fishdorsalfin + "'", null);

        int Column1 = c.getColumnIndex(FishDb.fishdb1.FISH_NAME);
        //int Column2 = c.getColumnIndex("Field2");
        String Data = "";
        // Check if our result was valid.
        c.moveToFirst();
        if (c != null) {
            // Loop through all Results
            do {
                String Name = c.getString(Column1);
                //int Age = c.getInt(Column2);
                Data =Data +Name+"\n";
            }while(c.moveToNext());
        }

        tv.setText(Data);
        //setContentView(tv);
    }
    catch(Exception e) {
        Log.e("Error", "Error", e);
    }
   }
}
