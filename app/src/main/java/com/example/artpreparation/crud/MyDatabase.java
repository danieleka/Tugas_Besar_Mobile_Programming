package com.example.artpreparation.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {

    //    private static final String CREATE_TABLE_ALAT = ;
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_alat";

    private static final String tb_alat = "tb_alat";

    private static final String tb_alat_id = "id";
    private static final String tb_alat_nama = "nama";
    private static final String tb_alat_jenis = "jenis";
    private static final String tb_alat_fungsi = "fungsi";

    private static final String CREATE_TABLE_ALAT= "CREATE TABLE " + tb_alat + "("
            + tb_alat_id + " INTEGER PRIMARY KEY ," + tb_alat_nama + " TEXT,"
            + tb_alat_jenis + " TEXT, " + tb_alat_fungsi + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ALAT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void CreateDesainer (Alat mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_alat_id, mdNotif.get_id());
        values.put(tb_alat_nama, mdNotif.get_nama());
        values.put(tb_alat_jenis, mdNotif.get_jenis());
        values.put(tb_alat_fungsi, mdNotif.get_fungsi());
        db.insert(tb_alat, null, values);
        db.close();
    }

    public List<Alat> ReadDesainer() {
        List<Alat> judulModelList = new ArrayList<Alat>();
        String selectQuery = "SELECT  * FROM " + tb_alat;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Alat mdKontak = new Alat();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_jenis(cursor.getString(2));
                mdKontak.set_fungsi(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }

    public int UpdateDesainer (Alat mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(tb_alat_nama, mdNotif.get_nama());
        values.put(tb_alat_jenis, mdNotif.get_jenis());
        values.put(tb_alat_fungsi, mdNotif.get_fungsi());

        return db.update(tb_alat, values, tb_alat_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});     }

    public void DeleteDesainer (Alat mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_alat, tb_alat_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}