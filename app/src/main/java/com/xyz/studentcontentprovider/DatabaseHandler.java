package com.xyz.studentcontentprovider;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rashmi Chhabria on 10/5/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    SQLiteDatabase db;
    Context context;

    public DatabaseHandler(Context context) {
        super(context, "studentdb", null, 1);
        this.context = context;
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student(rno integer primary key, name text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long addStudent(ContentValues values) {
        return db.insert("student", null, values);
    }

    public int updateStudent (ContentValues value, String s) {
        return db.update("student", value, s, null);
    }

    public int deleteStudent (String s) {
        return db.delete("student", s, null);
    }

}
