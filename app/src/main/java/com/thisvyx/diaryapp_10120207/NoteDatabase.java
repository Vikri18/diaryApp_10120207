/**
 * NIM : 10120207
 * Nama : Vikri Frediansyah
 * Kelas : IF-5
 */
package com.thisvyx.diaryapp_10120207;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class NoteDatabase extends SQLiteOpenHelper {

    //atribut
    public static final int DB_VERSION = 2;
    public static final String DB_NAME = "DiaryApp.db";
    public static final String DB_TABLE = "NotesTable";

    public static final String COLUMN_ID = "NotesId";
    public static final String COLUMN_CATEGORY = "NotesCategory";
    public static final String COLUMN_TITTLE = "NotesTittle";
    public static final String COLUMN_DETAILS = "NotesDetails";
    public static final String COLUMN_DATE = "NotesDate";
    public static final String COLUMN_TIME = "NotesTime";




    //method
    public NoteDatabase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + DB_TABLE +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITTLE + " TEXT," +
                COLUMN_CATEGORY + " TEXT," +
                COLUMN_DETAILS + " TEXT," +
                COLUMN_DATE + " TEXT," +
                COLUMN_TIME + " TEXT" + ")";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion >= newVersion )
            return;
        db.execSQL("DROP TABLE IF EXISTS "+ DB_NAME );
        onCreate(db);
    }

    public long AddNote(NoteModel noteModel){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_TITTLE, noteModel.getNoteTittle());
        contentValues.put(COLUMN_CATEGORY, noteModel.getNoteCategory());
        contentValues.put(COLUMN_DETAILS, noteModel.getNoteDetails());
        contentValues.put(COLUMN_DATE, noteModel.getNoteDate());
        contentValues.put(COLUMN_TIME, noteModel.getNoteTime());

        long ID = db.insert(DB_TABLE, null, contentValues);
        Log.d("Inserted", "id ->" +ID);
        return ID;
    }

    public List<NoteModel> getNote(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<NoteModel> allNote = new ArrayList<>();

        String queryStatement = "SELECT * FROM " + DB_TABLE;
        Cursor cursor = db.rawQuery(queryStatement,null);

        if (cursor.moveToFirst()){
            do{
                NoteModel noteModel = new NoteModel();

                noteModel.setId(cursor.getInt(0));
                noteModel.setNoteTittle(cursor.getString(1));
                noteModel.setNoteCategory(cursor.getString(2));
                noteModel.setNoteDetails(cursor.getString(3));
                noteModel.setNoteDate(cursor.getString(4));
                noteModel.setNoteTime(cursor.getString(5));

                allNote.add(noteModel);
            }while (cursor.moveToNext());
        }
        return allNote;
    }
}
