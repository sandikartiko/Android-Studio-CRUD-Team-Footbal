package com.example.a1918051_tgs7;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper  {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_persipura";
    private static final String tb_persipura = "tb_persipura";
    private static final String getTb_persipura_id = "id";
    private static final String getTb_persipura_nama_player = "nama_player";
    private static final String getTb_persipura_posisi = "posisi";
    private static final String CREATE_TABLE_PERSIPURA = "CREATE TABLE " + tb_persipura +"(" + getTb_persipura_id + " INTEGER PRIMARY KEY ," + getTb_persipura_nama_player + " TEXT ," + getTb_persipura_posisi + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PERSIPURA);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void Createpersipura(persipura data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(getTb_persipura_id, data.get_id());
        values.put(getTb_persipura_nama_player, data.get_nama_player());
        values.put(getTb_persipura_posisi, data.get_posisi());
        db.insert(tb_persipura, null, values);
        db.close();
    }
    public List<persipura> Readpersipura() {
        List<persipura> listper = new ArrayList<persipura>();
        String selectQuery = "SELECT * FROM " + tb_persipura;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                persipura data = new persipura();
                data.set_id(cursor.getString(0));
                data.set_nama_player(cursor.getString(1));
                data.set_posisi(cursor.getString(2));
                listper.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listper;
    }
    public int Updatepersipura (persipura data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(getTb_persipura_nama_player, data.get_nama_player());
        values.put(getTb_persipura_posisi, data.get_posisi());
        return db.update(tb_persipura, values, getTb_persipura_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void Deletepersipura(persipura data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_persipura,getTb_persipura_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
