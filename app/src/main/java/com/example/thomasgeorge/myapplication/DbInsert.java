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
<<<<<<< HEAD
    EditText name,minlen,maxlen,maxwt,fishcolor,fishfin;
=======
    EditText name,mouth,dorsalfin,tail;
>>>>>>> c1c371f67b41a97d439e24884522706c660cf6ba
    TextView tv;
    Button insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dbinsert);
<<<<<<< HEAD
        //name=(EditText) findViewById(R.id.fishname);
        minlen=(EditText) findViewById(R.id.fishminlen);
        //maxlen=(EditText) findViewById(R.id.fishmaxlen);
        maxwt=(EditText) findViewById(R.id.fishmaxwt);
        fishcolor=(EditText) findViewById(R.id.fishcolor);
        fishfin=(EditText) findViewById(R.id.fishfin);
=======
        name=(EditText) findViewById(R.id.fishname);
        mouth=(EditText) findViewById(R.id.fishmouth);
        dorsalfin=(EditText) findViewById(R.id.fishdorsalfin);
        tail=(EditText) findViewById(R.id.fishtail);
>>>>>>> c1c371f67b41a97d439e24884522706c660cf6ba
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
<<<<<<< HEAD
        String fishminlen=minlen.getText().toString();
        //String fishmaxlen=maxlen.getText().toString();
        String fishmaxwt=maxwt.getText().toString();
        String color=fishcolor.getText().toString();
        String fin=fishfin.getText().toString();
        int minlen1=Integer.parseInt(fishminlen);
        //int maxlen=Integer.parseInt(fishmaxlen);
        int maxwt1=Integer.parseInt(fishmaxwt);
        String st="SELECT " + FishDb.fishdb1.FISH_NAME + " FROM " + FishDb.fishdb1.TABLE_NAME + " WHERE " + FishDb.fishdb1.FISH_MINLEN + " >= '" + minlen1 + "' AND " + FishDb.fishdb1.FISH_MAXLEN + " <= '" + minlen1 + "' AND " + FishDb.fishdb1.FISH_MAXWT + " <= '" + maxwt1  + "' AND " + FishDb.fishdb1.FISH_COLOR + " = '" + color + "' AND " + FishDb.fishdb1.FISH_FIN + " = '" + fin +"'";

        try {
        fishdbconn = new FishDbConn(getBaseContext());
        db = fishdbconn.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT " + FishDb.fishdb1.FISH_NAME + " FROM " + FishDb.fishdb1.TABLE_NAME + " WHERE " + FishDb.fishdb1.FISH_MINLEN + " <= '" + minlen1 + "' AND " + FishDb.fishdb1.FISH_MAXLEN + " >= '" + minlen1 + "' AND " + FishDb.fishdb1.FISH_MAXWT + " >= '" + maxwt1  + "' AND " + FishDb.fishdb1.FISH_COLOR + " = '" + color + "' AND " + FishDb.fishdb1.FISH_FIN + " = '" + fin +"'", null);
            Log.e("QUERY",st);
        int Column1 = c.getColumnIndex(FishDb.fishdb1.FISH_NAME);
        //int Column2 = c.getColumnIndex("Field2");
            int cnt=c.getCount();
            Log.e("count",Integer.toString(cnt));
=======
        String fishmouth=mouth.getText().toString();
        String fishdorsalfin=dorsalfin.getText().toString();
        String fishtail=tail.getText().toString();
        try {
        fishdbconn = new FishDbConn(getBaseContext());
        db = fishdbconn.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT " + FishDb.fishdb1.FISH_NAME + " FROM " + FishDb.fishdb1.TABLE_NAME + " WHERE " + FishDb.fishdb1.FISH_TAIL + " = '" + fishtail + "' AND " + FishDb.fishdb1.FISH_MOUTH + " = '" + fishmouth + "' AND " + FishDb.fishdb1.FISH_DORSALFIN + " = '" + fishdorsalfin + "'", null);

        int Column1 = c.getColumnIndex(FishDb.fishdb1.FISH_NAME);
        //int Column2 = c.getColumnIndex("Field2");
>>>>>>> c1c371f67b41a97d439e24884522706c660cf6ba
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
