/**
   Ajeet Kumar Yadav
   Project Team - 5
   CS Tutorial Application
   CS 5363 - Software Project Management
   Java file for the database helper class
   This file contains schema on how to connect to the database
*/

package com.example.ajeyadav.cstutorialapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.MatrixCursor;

/**
 * Created by Achzeet on 10/14/2015.
 */

public class DatabaseHelper  extends SQLiteOpenHelper{

    // Declaring database variables
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "id";
    private static final String COLUMN_ID = "contacts";
    private static final String COLUMN_NAME = "fullname";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD_ = "password";
    SQLiteDatabase db;

    // Query to create the database table
    private final static String TABLE_CREATE = "create table contacts (id integer primary key not null, "
            + "fullname text not null, email text not null, password  text not null);";

    // Default constructor
    public DatabaseHelper(Context context) {
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method to look up correct password related to the user input email
    public String searchpassword(String uemail){

        db = this.getReadableDatabase();
        String query = "select email, password from  " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b = "not found";

        // selection statement to verify the correct corresponding username and password
        if(cursor.moveToFirst()){
            do {
                a = cursor.getString(0);
                if (a.equals(uemail)) {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        // return statement
        return b;
    }

    // Method to create database
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    // Method to insert contact into database
    public void insertContact(Contact c){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();

        // Inserting values in the database
        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, c.getFullname());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_PASSWORD_, c.getPassword());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    // Method to check the current database version and upgrade accordingly
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.db = db;
    }

}