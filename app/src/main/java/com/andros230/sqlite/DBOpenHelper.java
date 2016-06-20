package com.andros230.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBOpenHelper extends SQLiteOpenHelper {
    private String TAG = "DBOpneHelper";
    private static final String TABLE_NAME = "bmob_table";

    public DBOpenHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (id INTEGER primary key autoincrement, mac text, lat text, log text);";
        sqLiteDatabase.execSQL(sql);
        Log.d(TAG, "创建数据库");
    }

    //增加操作
    public long insert() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("mac", "aaa4");
        cv.put("lat", "lat2223");
        cv.put("log", "log2232");
        long row = db.insert(TABLE_NAME, null, cv);
        Log.d(TAG, "增加数据" + row);
        return row;
    }

    //查询数据
    public void search() {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            String sql = "select * from " + TABLE_NAME;
            Cursor cur = db.rawQuery(sql, new String[]{});
            while (cur.moveToNext()) {
                Log.d(TAG, cur.getString(0));
                Log.d(TAG, cur.getString(1));
                Log.d(TAG, cur.getString(2));
                Log.d(TAG, cur.getString(3));
            }
            cur.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //修改操作
        public void update(){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("mac", "88888");
            cv.put("lat", "lat88888");
            cv.put("log", "log88888");
            db.update(TABLE_NAME, cv, "mac = ?", new String[]{"aaa4"});
    }


    //删除操作
    public void delete() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "mac = ?", new String[]{"aaa3"});
        Log.d(TAG, "删除数据");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
