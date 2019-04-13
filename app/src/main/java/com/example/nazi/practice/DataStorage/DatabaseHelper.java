package com.example.nazi.practice.DataStorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.os.Build.ID;

/**
 * Created by Nazi on 2/2/2019.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String DATA_BASE="Student.db";
    private static final String TABLE_NAME="student_table";
    private static final String COL_1="ID";
    private static final String COL_2="NAME";
    private static final String COL_3="SURNAME";
    private static final String COL_4="MARKS";
    private static final String SQl_CREATE_ENTRIES="CREATE TABLE"+TABLE_NAME +
            "("+COL_1+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_2+" TEXT,"+COL_3+" TEXT,"+COL_4+" INTEGER)";
    private static final String SQl_DELETE_ENTRIES="DROP TABLE IF EXISTS"+TABLE_NAME;

    public DatabaseHelper(Context context) {
        super(context, DATA_BASE, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQl_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQl_DELETE_ENTRIES);
        onCreate(db);

    }
    public boolean insertData(String name,String surname,String marks){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        long result= db.insert(TABLE_NAME,null,contentValues);
        //The second argument tells the framework what to do in the event that
        // the ContentValues is empty (i.e., you did not put any values).
        // If you specify the name of a column, the framework inserts a row and
        // sets the value of that column to null.
        // If you specify null, like in this code sample, the framework does not insert a row when there are no values.
        if(result==-1)
            return false;
        else
            return true;

    }
}
