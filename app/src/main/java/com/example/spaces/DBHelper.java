package com.example.spaces;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static java.sql.Types.NULL;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Spaces.db";
    private static final String DB_TABLE = "Venues_Table";

    private static final String ID = "ID";
    private static final String NAME = "NAME";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final String FREESPACES = "FREESPACES";

    private static final String CREATE_TABLE = "CREATE TABLE " + DB_TABLE + " (" +
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            NAME + " TEXT, " +
            DESCRIPTION + " TEXT, " +
            FREESPACES + " INTEGER DEFAULT 0)";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);

        onCreate(sqLiteDatabase);

    }

    public boolean insertData(String name, String description, int freeSpaces) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(DESCRIPTION, description);
        contentValues.put(FREESPACES, freeSpaces);

        long result = db.insert(DB_TABLE, null, contentValues);

        return result != -1; // data isn't inserted if result = -1
    }


    public Cursor viewData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + DB_TABLE;
        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }



}
