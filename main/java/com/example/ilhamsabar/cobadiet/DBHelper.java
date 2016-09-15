package com.example.ilhamsabar.cobadiet;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ilham sabar on 11/4/2015.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static String DB_PATH = "/data/data/com.ilhamsabar.dietsehat/databases/";
    private static String DB_NAME = "diet2.sqlite";
    private static String TABLE = "dietmayo";

    private SQLiteDatabase myDataBase;
    private final Context myContext;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }

    public void CreateDataBase() throws IOException {
        boolean dbExist = checkDataBase();

        if (dbExist) {
            //Toast.makeText(myContext, "Database already exist", Toast.LENGTH_LONG).show();
        }
        else {
            this.getReadableDatabase();

            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;

        try {
            String myPath = DB_PATH + DB_NAME;

            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLException e) {
            //Toast.makeText(myContext, "Nothing database on the data", Toast.LENGTH_LONG).show();
        }

        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    private void copyDataBase() throws IOException {
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;

        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public boolean open() {
        try {
            String myPath = DB_PATH + DB_NAME;
            myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
            return true;
        } catch (SQLException sqle) {
            myDataBase = null;
            return false;
        }
    }

    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

    public List<Peraturan> getPeraturans() {

        List<Peraturan> peraturans = null;

        try {
            String query = "SELECT * FROM dietmayo";
            SQLiteDatabase db = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.OPEN_READONLY);
            Cursor cursor = db.rawQuery(query, null);
            peraturans = new LinkedList<Peraturan>();

            if (cursor.moveToFirst()) {
                do {
                    Peraturan peraturan = new Peraturan();
                   // peraturan.id = Integer.parseInt(cursor.getString(0));
                    peraturan.pagi = cursor.getString(1);
                    peraturan.siang = cursor.getString(2);
                    peraturan.malam = cursor.getString(3);
                    peraturans.add(peraturan);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Toast.makeText(myContext, "Database or SQL error", Toast.LENGTH_LONG).show();
        }
        close();
        return peraturans;
    }

//    public List<PeraturanOCD> getPeraturansOCD() {
//
//        List<PeraturanOCD> peraturansocd = null;
//
//        try {
//            String query = "SELECT * FROM dietocd";
//            SQLiteDatabase db = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.OPEN_READONLY);
//            Cursor cursor = db.rawQuery(query, null);
//            Toast.makeText(myContext, "menyeleksi row berhasil", Toast.LENGTH_LONG).show();
//            peraturansocd = new LinkedList<PeraturanOCD>();
//
//            if (cursor.moveToFirst()) {
//                do {
//                    PeraturanOCD peraturan = new PeraturanOCD();
//                    //peraturan.id = Integer.parseInt(cursor.getString(0));
//                    peraturan.puasa16 = cursor.getString(cursor.getColumnIndex("puasa16"));
//                    peraturan.puasa18 = cursor.getString(cursor.getColumnIndex("puasa18"));
//                    peraturan.puasa20 = cursor.getString(cursor.getColumnIndex("puasa20"));
//                    peraturan.puasa24 = cursor.getString(cursor.getColumnIndex("puasa24"));
//                    peraturansocd.add(peraturan);
//                } while (cursor.moveToNext());
//            }
//        } catch (Exception e) {
//            //Toast.makeText(myContext, "Database or SQL error", Toast.LENGTH_LONG).show();
//        }
//
//        return peraturansocd;
//    }
}

