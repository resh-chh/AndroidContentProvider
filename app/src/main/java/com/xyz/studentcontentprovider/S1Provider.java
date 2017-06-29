package com.xyz.studentcontentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class S1Provider extends ContentProvider {

    DatabaseHandler dbH;

    public S1Provider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int result = dbH.deleteStudent(selection);
        if(result==0) {
            Log.d("STU123", "Deleted");
        }
        else {
            Log.d("STU123", "Not Deleted");
        }
        return result;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rid = dbH.addStudent(values);
        if (rid < 0) {
            Log.d("STU123", "Insert Issue");
        } else {
            Log.d("STU123", "Insert Success");
        }
        return uri;
    }

    @Override
    public boolean onCreate() {
        dbH = new DatabaseHandler(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder s1=new SQLiteQueryBuilder();
        s1.setTables("student");

        SQLiteDatabase sdb1=dbH.getWritableDatabase();
        Cursor cursor=s1.query(sdb1, null, null, null, null, null, null);

        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int result=dbH.updateStudent(values, selection);
        return result;
    }
}
