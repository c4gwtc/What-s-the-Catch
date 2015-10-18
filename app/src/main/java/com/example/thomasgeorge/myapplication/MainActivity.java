package com.example.thomasgeorge.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

   Context context;
    FishDbConn fishdbconn;
    SQLiteDatabase db;
    EditText name,mouth,dorsalfin,tail;
    Button insert,viewlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name=(EditText) findViewById(R.id.fishname);
        mouth=(EditText) findViewById(R.id.fishmouth);
        dorsalfin=(EditText) findViewById(R.id.fishdorsalfin);
        tail=(EditText) findViewById(R.id.fishtail);
        insert=(Button) findViewById(R.id.insert);
        viewlist=(Button) findViewById(R.id.viewlist);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        FishDbConn myDbHelper = new FishDbConn(this);
        myDbHelper = new FishDbConn(this);

        try {

            myDbHelper.createDataBase();
            Log.e("DATABASE OPERATION","database created");

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        try {

            myDbHelper.openDataBase();
            Log.e("DATABASE OPERATION", "database opened");


        }catch(SQLException sqle){

            try {
                throw sqle;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DbInsert.class));
            }
        });

        viewlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DataListActivity.class));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void Insert(View view){
        Intent intent = new Intent(this,DbInsert.class);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /*
    public void addRow(View view){
        String fishname=name.getText().toString();
        String fishmouth=mouth.getText().toString();
        String fishdorsalfin=dorsalfin.getText().toString();
        String fishtail=tail.getText().toString();
        fishdbconn = new FishDbConn(this);
        db = fishdbconn.getWritableDatabase();
        fishdbconn.insertop(fishname,fishmouth,fishdorsalfin,fishtail,db);
        Toast.makeText(getBaseContext(), "Data inserted", Toast.LENGTH_LONG).show();
        fishdbconn.close();
    }
*/
}
