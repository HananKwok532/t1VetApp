package com.example.hkwok1.vetapp;

import android.app.SearchManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DatabaseTable {

    public static final String TAG = "Database";

    //The columns we'll include in the dictionary table
    public static final String COL_ID = "apppointment ID";
    public static final String COL_TYPE= "appointment type";
    public static final String COL_petID = "pet ID";
    public static final String COL_date = "date of appointment";
    public static final String COL_time = "apppointment time";
    public static final String COL_petName= "pet name";
    public static final String DATABASE_NAME = "VetAPP";
    public static final String FTS_VIRTUAL_TABLE = "FTS";
    public static final int DATABASE_VERSION = 1;

    public  final DatabaseOpenHelper mDatabaseOpenHelper;
    public DatabaseTable(Context context) {
        mDatabaseOpenHelper = new DatabaseOpenHelper(context);
    }

    public static class DatabaseOpenHelper extends SQLiteOpenHelper {
        public final Context mHelperContext;
        public SQLiteDatabase mDatabase;

        public static final String FTS_TABLE_CREATE =
                "CREATE VIRTUAL TABLE " + FTS_VIRTUAL_TABLE + " USING fts3 (" +
                        COL_ID + ", " +
                        COL_TYPE + ", " +
                        COL_petID + ", " +
                        COL_date + ", " +
                        COL_time + ", " +
                        COL_petName + ")";

        DatabaseOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            mHelperContext = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            mDatabase = db;
            mDatabase.execSQL(FTS_TABLE_CREATE);
            loadcols();
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + FTS_VIRTUAL_TABLE);
            onCreate(db);
        }


        public void loadcols() {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        loadvalues();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }

        public void loadvalues() throws IOException {

            final Resources resources = mHelperContext.getResources();
            InputStream inputStream = resources.openRawResource(R.raw.vet_app.mwb);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            try {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] strings = TextUtils.split(line, "-");
                    if (strings.length < 2) continue;
                    long id = addWord(strings[0].trim(), strings[1].trim());
                    if (id < 0) {
                        Log.e(TAG, "unable to add word: " + strings[0].trim());
                    }
                }
            } finally {
                reader.close();
            }
        }

        public long addWord(String col, String value) {
            ContentValues initialValues = new ContentValues();
            initialValues.put(COL_ID, value);
            initialValues.put(COL_TYPE, value);
            initialValues.put(COL_petID, value);
            initialValues.put(COL_date, value);
            initialValues.put(COL_time, value);
            initialValues.put(COL_petName, value);

            return mDatabase.insert(FTS_VIRTUAL_TABLE, null, initialValues);
        }
    }
    public Cursor getEvents(String query, String[] columns) {
        String selection = COL_date+ " MATCH ?";
        String[] selectionArgs = new String[] {query+"*"};

        return query(selection, selectionArgs, columns);
    }

    private Cursor query(String selection, String[] selectionArgs, String[] columns) {
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(FTS_VIRTUAL_TABLE);

        Cursor cursor = builder.query(mDatabaseOpenHelper.getReadableDatabase(),
                columns, selection, selectionArgs, null, null, null);

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return cursor;
    }
}