package com.example.saveit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public static final String database_name="resgistered";
    public static final String table_name="login_info";
    public static final String COL1="usernames";
    public static final String COL2="passwords";

    public Database(Context context){

        super(context,database_name,null,1);
        SQLiteDatabase db=this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + table_name +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, usernames TEXT, passwords TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
        onCreate(db);
    }
}
