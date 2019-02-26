package com.ayushcoding.www.jclapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ayush on 5/2/2016.
 */
public class ScoresDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 4;
    // Database Name
    private static final String DATABASE_NAME = "scoresDB";
    // tasks table name
    private static final String TABLE_SCORES = "scores";

    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TOPIC = "topicColumn";
    private static final String KEY_TOTAL = "total";
    private static final String KEY_CORRECT = "correct";
    private static final String[] AllKeys = new String[]{KEY_ID, KEY_TOPIC, KEY_TOTAL, KEY_CORRECT};

    private SQLiteDatabase dbase;

    public ScoresDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_SCORES + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_TOPIC
                + " TEXT, " + KEY_TOTAL + " INTEGER, " + KEY_CORRECT + " INTEGER)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORES);
// Create tables again
        onCreate(db);
    }

    public void addScore(String topic, Integer score, Integer total) {
        SQLiteDatabase dbase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TOPIC, topic);
        values.put(KEY_TOTAL, total);
        values.put(KEY_CORRECT, score);
        System.out.println("TOTAL " + total + " , CORRECT " + score + " , TOPIC " + topic);
        dbase.insert(TABLE_SCORES, null, values);
    }

    public int[] selectMythScore(String topic) {
        SQLiteDatabase dbase = this.getReadableDatabase();
        String WHERE = KEY_TOPIC + "=?";
        Cursor cursor = dbase.query(TABLE_SCORES, AllKeys, WHERE, new String[]{topic}, null, null, null);
        cursor.moveToFirst();
        int [] totalAndCorrect = new int[2];
//        List<Scores> scoreList = new ArrayList<Scores>();
        String topicCheck = "";
        Integer total;
        Integer correct;
        while (cursor.isAfterLast() == false) {
            Scores scores = new Scores();
            topicCheck = cursor.getString(cursor.getColumnIndex(KEY_TOPIC));
            total = cursor.getInt(cursor.getColumnIndex(KEY_TOTAL));
            correct = cursor.getInt(cursor.getColumnIndex(KEY_CORRECT));
            cursor.moveToNext();
            totalAndCorrect = new int[]{total, correct};
        }
        return totalAndCorrect;
    }
public void deleteValues() {
    dbase = this.getWritableDatabase();
    dbase.delete(TABLE_SCORES, null, null);
}

    public void ScoreUpdate(String topic, Integer prevScore) {
        dbase = getReadableDatabase();
        String WHERE = KEY_TOPIC + "=?";
        Cursor cursor = dbase.query(TABLE_SCORES, AllKeys, WHERE, new String[]{topic}, null, null, null);
        cursor.moveToFirst();

//        List<Scores> scoreList = new ArrayList<Scores>();
        String topicCheck = "";
        Integer total = 0;
        Integer correct = 0;
        while (cursor.isAfterLast() == false) {
            Scores scores = new Scores();
            topicCheck = cursor.getString(cursor.getColumnIndex(KEY_TOPIC));
            total = cursor.getInt(cursor.getColumnIndex(KEY_TOTAL));
            correct = cursor.getInt(cursor.getColumnIndex(KEY_CORRECT));
            cursor.moveToNext();
//            Scores scores = new Scores();
//            scores.setTopic(cursor.getString(cursor.getColumnIndex(KEY_TOPIC)));
//            scores.setTotal(cursor.getInt(cursor.getColumnIndex(KEY_TOTAL)));
//            scores.setCorrect(cursor.getInt(cursor.getColumnIndex(KEY_CORRECT)));
//            scoreList.add(scores);
//            cursor.moveToNext();

        }
        System.out.println("BEFOREEEEEEEEEEEEEEEEEEEEEEEEEEE : " + total + "    " + correct);
        total += 10;
        correct = correct + prevScore;
        ContentValues values = new ContentValues();
        values.put(KEY_TOPIC, topic);
        values.put(KEY_TOTAL, total);
        values.put(KEY_CORRECT, correct);
        dbase.insert(TABLE_SCORES, null, values);
        System.out.println("TOTAL " + total + " , CORRECT " + correct + " , TOPIC " + topic);
    }

    public boolean checkEvent(String topic, Integer score) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DATABASE_NAME,
                new String[]{KEY_ID, KEY_TOPIC, KEY_TOTAL, KEY_CORRECT},
                KEY_TOPIC + " = ?",
                new String[]{topic},
                null, null, null, null);

        if (cursor.moveToFirst()) {
            ScoreUpdate(topic, score);
            System.out.println("exists");
            return true; //row exists
        } else {
            addScore(topic, score, 10);
            System.out.println("NOT exists");
            return false;
        }
    }
}

