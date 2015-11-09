package com.example.thomasgeorge.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

/**
 * Created by ThomasGeorge on 10/13/2015.
 */
public class FishDbConn extends SQLiteOpenHelper {

/*
    SQLiteDatabase db;
    public static final String DBNAME="fish.db";
    public static final int DBVERSION=1;
    public static final String createquery1="CREATE TABLE "+FishDb.fishdb1.TABLE_NAME+"("+FishDb.fishdb1.FISH_NAME+" TEXT,"+FishDb.fishdb1.FISH_MOUTH+" TEXT,"+FishDb.fishdb1.FISH_DORSALFIN+" TEXT,"+FishDb.fishdb1.FISH_TAIL+" TEXT);";
    public static final String createquery="CREATE TABLE IF NOT EXISTS table_name(key INTEGER PRIMARY KEY, fishname VARCHAR, fish_name1 VARCHAR, fish_mouth VARCHAR, fish_dorsalfin VARCHAR, fish_tail VARCHAR);";

    public FishDbConn(Context context)
    {
        super(context, DBNAME, null, DBVERSION);


        Log.e("DATABASE OPERATION", "database created.opened");
        db = getWritableDatabase();
        db.execSQL(createquery);
        Log.e("DATABASE OPERATION", "table created");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createquery);
        Log.e("DATABASE OPERATION", "table created");

    }
    //@Override
    public void onUpgrade(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS "+FishDb.fishdb1.TABLE_NAME);
        Log.e("DATABASE OPERATION", "table dropped");
        onCreate(db);
    }
    public void insertop(String name, String mouth, String dorsalfin, String tail, SQLiteDatabase db){
        ContentValues contentvalue = new ContentValues();
        //contentvalue.put("fishname","invalid");
        db=this.getWritableDatabase();
        contentvalue.put(FishDb.fishdb1.FISH_NAME,name);
        Log.e("name", name);
        contentvalue.put(FishDb.fishdb1.FISH_MOUTH, mouth);
        Log.e("mouth", mouth);
        contentvalue.put(FishDb.fishdb1.FISH_DORSALFIN, dorsalfin);
        Log.e("dorsal fin", dorsalfin);
        contentvalue.put(FishDb.fishdb1.FISH_TAIL, tail);
        Log.e("tail", tail);
        db.insert(FishDb.fishdb1.TABLE_NAME, null, contentvalue);
        Log.e("DATABASE OPERATION", "row created");

    }

    public Cursor getinfo(SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {FishDb.fishdb1.FISH_NAME,FishDb.fishdb1.FISH_MOUTH,FishDb.fishdb1.FISH_DORSALFIN,FishDb.fishdb1.FISH_TAIL};
        cursor=db.query(FishDb.fishdb1.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


*/
private static String DB_PATH = "/data/data/com.example.thomasgeorge.myapplication/databases/";

    private static String DB_NAME = "fishdb";

    private SQLiteDatabase myDataBase;

    private final Context myContext;

    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public FishDbConn(Context context) {

        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDataBase() throws IOException {

        boolean dbExist = checkDataBase();



            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();

            try {

                copyDataBase();
                Log.e("DB OP","copied db");

            } catch (IOException e) {

                Log.e("DB OP","Error copying database");

            }


    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase(){

        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch(SQLiteException e){

            //database does't exist yet.
            Log.e("DATABASE OPEARTIOn","database doesn't exist");

        }

        if(checkDB != null){

            checkDB.close();

        }

        return checkDB != null ? true : false;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException{

        //Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(DB_NAME);

        // Path to the just created empty db
        String outFileName = DB_PATH + DB_NAME;

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {

        //Open the database
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {

        if(myDataBase != null)
            myDataBase.close();

        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public Cursor getinfo(SQLiteDatabase db){
        Cursor cursor;
<<<<<<< HEAD
        String[] projections = {FishDb.fishdb1.FISH_NAME,FishDb.fishdb1.FISH_SCNAME,FishDb.fishdb1.FISH_MINLEN,FishDb.fishdb1.FISH_MAXLEN,FishDb.fishdb1.FISH_MAXWT,FishDb.fishdb1.FISH_COLOR,FishDb.fishdb1.FISH_FIN};
=======
        String[] projections = {FishDb.fishdb1.FISH_NAME,FishDb.fishdb1.FISH_MOUTH,FishDb.fishdb1.FISH_DORSALFIN,FishDb.fishdb1.FISH_TAIL};
>>>>>>> c1c371f67b41a97d439e24884522706c660cf6ba
        cursor=db.query(FishDb.fishdb1.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }
}
