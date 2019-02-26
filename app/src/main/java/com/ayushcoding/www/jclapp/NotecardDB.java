package com.ayushcoding.www.jclapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ayush on 6/13/2016.
 */
public class NotecardDB extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 2;
    // Database Name
    private static final String DATABASE_NAME = "notecardDB";
    // tasks table name
    private static final String TABLE_SCORES = "questionsCustomNotecard";

    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUESTION = "question";
    private static final String ANSWER = "answer";
    private static final String SUBJECT = "subject";
    private static final String[] AllKeys = new String[]{KEY_ID, KEY_QUESTION, ANSWER, SUBJECT};

    private SQLiteDatabase dbase;

    public NotecardDB(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_SCORES + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESTION
                + " TEXT, " + ANSWER + " TEXT, " + SUBJECT + " TEXT)";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORES);
// Create tables again
        onCreate(db);
    }

    public void addQuestion(String quest, String ans, String sub) {
        SQLiteDatabase dbase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUESTION, quest);
        values.put(ANSWER, ans);
        values.put(SUBJECT, sub);
        System.out.println(quest + ans + sub);
        dbase.insert(TABLE_SCORES, null, values);
    }
    public int getProfilesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_SCORES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }
    public String[] selectQuestions(int id) {
        dbase = getReadableDatabase();
        Cursor find = dbase.rawQuery("SELECT * FROM " + TABLE_SCORES + " WHERE " + KEY_ID + " = ?", new String[] {String.valueOf(id)});
        find.moveToFirst();

        String[] employList = new String[50];

        while (find.isAfterLast() == false) {
            QuestionNotecard employ = new QuestionNotecard();
            int idThing = find.getInt(find.getColumnIndex(KEY_ID));
            String questionThing = find.getString(find.getColumnIndex(KEY_QUESTION));
            String answerThing = find.getString(find.getColumnIndex(ANSWER));
            String sub = find.getString(find.getColumnIndex(SUBJECT));
            employList = new String[] {questionThing, answerThing, sub};
            find.moveToNext();

        }
        return employList;
    }
    public void deleteThings(String quest) {
        dbase = getWritableDatabase();
        dbase.delete(TABLE_SCORES, KEY_QUESTION + "=?", new String[] { quest });
        dbase.close();
    }
}
