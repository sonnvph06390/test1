package com.example.son.test1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "oto_list";
    private static final String TABLE_NAME = "oto";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PRICE = "price";
    private Context context;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY, " +
                NAME + " TEXT, " +
                PRICE + " TEXT)";
        sqLiteDatabase.execSQL(sqlQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
        Toast.makeText(context, "Drop successfylly", Toast.LENGTH_SHORT).show();

    }
    public void addStudent(Oto oto){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, oto.getId());
        values.put(NAME, oto.getName());
        values.put(NAME, oto.getPrice());

        //Neu de null thi khi value bang null thi loi

        db.insert(TABLE_NAME,null,values);

        db.close();
    }
    public List<Oto> getAllOto() {
        List<Oto> listOto = new ArrayList<Oto>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Oto oto = new Oto();
                oto.setId(cursor.getString(0));
                oto.setName(cursor.getString(1));
                oto.setPrice(cursor.getString(2));
                listOto.add(oto);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listOto;
    }
    public void deleteStudent(Oto oto) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID + " = ?",
                new String[] { String.valueOf(oto.getId()) });
        db.close();
    }
}
