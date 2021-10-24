package com.example.notesappsaveonly

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper( context: Context ) : SQLiteOpenHelper(context, "details.db", null, 1) {

    var sqLiteDatabase : SQLiteDatabase = writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL("create table Notes( Masseg text ) ")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {}

    fun save (  s1:String ): Long {

        val cv = ContentValues()
        cv.put("Masseg" , s1)

        var status = sqLiteDatabase.insert("Notes",null,cv)

        return status

    }
}