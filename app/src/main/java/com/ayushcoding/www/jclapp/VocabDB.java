package com.ayushcoding.www.jclapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Ayush on 7/5/2016.
 */
public class VocabDB extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuizVocab";
    // tasks table name
    private static final String TABLE_QUEST = "questGrammar";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c

    private SQLiteDatabase dbaseGrammar;
    public VocabDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbaseGrammar=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
        db.execSQL(sql);
        addVocabQuestion(0,  "adsidus",  "constant",  "level",  "worthy",  "seated",  "constant",  "Choose the best meaning for each Latin word");
        addVocabQuestion(1,  "venia",  "love",  "vein",  "pardon",  "arrival",  "pardon",  "Choose the best meaning for each Latin word");
        addVocabQuestion(2,  "confestim",  "secretly",  "happily",  "wild",  "at once",  "at once",  "Choose the best meaning for each Latin word");
        addVocabQuestion(3,  "pernicies",  "belief",  "destruction",  "thief",  "torch",  "destruction",  "Choose the best meaning for each Latin word");
        addVocabQuestion(4,  "fingere",  "to touch",  "to fasten",  "to imagine",  "to end",  "to imagine",  "Choose the best meaning for each Latin word");
        addVocabQuestion(5,  "exiguus",  "insignificant",  "active",  "dirty",  "scaly",  "insignificant",  "Choose the best meaning for each Latin word");
        addVocabQuestion(6,  "collum",  "neck",  "hill",  "settler",  "associate",  "neck",  "Choose the best meaning for each Latin word");
        addVocabQuestion(7,  "castra",  "house",  "camp",  "correction",  "charity",  "camp",  "Choose the best meaning for each Latin word");
        addVocabQuestion(8,  "ocior",  "hidden",  "swifter",  "eight",  "bird-like",  "swifter",  "Choose the best meaning for each Latin word");
        addVocabQuestion(9,  "acer",  "sharp",  "reclined",  "quick",  "famous",  "sharp",  "Choose the best meaning for each Latin word");
        addVocabQuestion(10,  "ipse",  "himself",  "his own",  "the same one",  "another one",  "himself",  "Choose the best meaning for each Latin word");
        addVocabQuestion(11,  "iucundus",  "joined",  "mountainous",  "pleasing",  "ordered",  "pleasing",  "Choose the best meaning for each Latin word");
        addVocabQuestion(12,  "frumentum",  "river",  "enjoyment",  "use",  "grain",  "grain",  "Choose the best meaning for each Latin word");
        addVocabQuestion(13,  "tegere",  "to help",  "to weave",  "to protect",  "to testify",  "to protect",  "Choose the best meaning for each Latin word");
        addVocabQuestion(14,  "interea",  "between",  "journey",  "meanwhile",  "dangerous",  "meanwhile",  "Choose the best meaning for each Latin word");
        addVocabQuestion(15,  "praeter",  "except",  "go ahead",  "judge",  "pass by",  "except",  "Choose the best meaning for each Latin word");
        addVocabQuestion(16,  "vultus",  "fox",  "expression",  "wish",  "bird",  "expression",  "Choose the best meaning for each Latin word");
        addVocabQuestion(17,  "gramen",  "grass",  "step",  "joy",  "amazement",  "grass",  "Choose the best meaning for each Latin word");
        addVocabQuestion(18,  "parcere",  "to obey",  "to suffer",  "to spare",  "to prepare",  "to spare",  "Choose the best meaning for each Latin word");
        addVocabQuestion(19,  "hostage",  "pecus",  "obses",  "nepos",  "hostis",  "obses",  "Choose the best meaning for each English word");
        addVocabQuestion(20,  "crowd",  "carina",  "comes",  "caterva",  "convivium",  "caterva",  "Choose the best meaning for each English word");
        addVocabQuestion(21,  "to curve",  "surgere",  "currere",  "colere",  "flectere",  "flectere",  "Choose the best meaning for each English word");
        addVocabQuestion(22,  "rural",  "agrestis",  "rursus",  "idoneus",  "confertus",  "agrestis",  "Choose the best meaning for each English word");
        addVocabQuestion(23,  "organs",  "vis",  "viscus",  "vix",  "vitta",  "viscus",  "Choose the best meaning for each English word");
        addVocabQuestion(24,  "in detail",  "prolixe",  "mitis",  "ceu",  "proinde",  "prolixe",  "Choose the best meaning for each English word");
        addVocabQuestion(25,  "to wander",  "mirÄrÄ«",  "vagÄrÄ«",  "erigere",  "deligere",  "vagÄrÄ«",  "Choose the best meaning for each English word");
        addVocabQuestion(26,  "heel",  "talus",  "culmen",  "pollex",  "calx",  "calx",  "Choose the best meaning for each English word");
        addVocabQuestion(27,  "noise",  "strepitus",  "carcer",  "nubes",  "nocens",  "strepitus",  "Choose the best meaning for each English word");
        addVocabQuestion(28,  "never",  "palam",  "numquam",  "tametsi",  "demum",  "numquam",  "Choose the best meaning for each English word");
        addVocabQuestion(29,  "couch",  "torus",  "taeda",  "letum",  "limen",  "torus",  "Choose the best meaning for each English word");
        addVocabQuestion(30,  "wickedness",  "inertia",  "nequita",  "tepor",  "nux",  "nequita",  "Choose the best meaning for each English word");
        addVocabQuestion(31,  "too much",  "paulisper",  "clam",  "tam",  "nimis",  "nimis",  "Choose the best meaning for each English word");
        addVocabQuestion(32,  "to cherish",  "ciÄ“re",  "vellere",  "fovÄ“re",  "sacrÄre",  "fovÄ“re",  "Choose the best meaning for each English word");
        addVocabQuestion(33,  "reed",  "mergus",  "sera",  "canna",  "ala",  "canna",  "Choose the best meaning for each English word");
        addVocabQuestion(34,  "to join",  "iungere",  "iuvÄre",  "iubÄ“re",  "iudicÄre",  "iungere",  "Choose the best meaning for each English word");
        addVocabQuestion(35,  "just as",  "tamen",  "sicut",  "seu",  "bis",  "sicut",  "Choose the best meaning for each English word");
        addVocabQuestion(36,  "to enter",  "intuÄ“rÄ«",  "insidiÄrÄ«",  "induere",  "inÄ«re",  "inÄ«re",  "Choose the best meaning for each English word");
        addVocabQuestion(37,  "knee",  "gener",  "gemitus",  "gens",  "genu",  "genu",  "Choose the best meaning for each English word");
        addVocabQuestion(38,  "therefore",  "igitur",  "quamquam",  "nam",  "tunc",  "igitur",  "Choose the best meaning for each English word");
        addVocabQuestion(39,  "trap",  "insidiae",  "initium",  "immanis",  "inopia",  "insidiae",  "Choose the best meaning for each English word");
        addVocabQuestion(40,  "hair",  "coma",  "canis",  "clipeus",  "crimen",  "coma",  "Choose the best meaning for each English word");
        addVocabQuestion(41,  "twig",  "virgo",  "barbarus",  "braccium",  "virga",  "virga",  "Choose the best meaning for each English word");
        addVocabQuestion(42,  "burn",  "flagito",  "incido",  "flamma",  "flagro",  "flagro",  "Choose the best meaning for each English word");
        addVocabQuestion(43,  "robber",  "laetor",  "latebra",  "latro",  "laurus",  "latro",  "Choose the best meaning for each English word");
        addVocabQuestion(44,  "wounded",  "saucius",  "sanctus",  "secus",  "senectus",  "saucius",  "Choose the best meaning for each English word");
        addVocabQuestion(45,  "boat",  "ratio",  "pulvis",  "ratis",  "radix",  "ratis",  "Choose the best meaning for each English word");
        addVocabQuestion(46,  "dishonor",  "obses",  "fluctus",  "stuprum",  "demum",  "stuprum",  "Choose the best meaning for each English word");
        addVocabQuestion(47,  "raise up",  "iuvo",  "arrigo",  "impetro",  "diligo",  "arrigo",  "Choose the best meaning for each English word");
        addVocabQuestion(48,  "adore",  "veneror",  "vereor",  "venio",  "verto",  "veneror",  "Choose the best meaning for each English word");
        addVocabQuestion(49,  "mob",  "castus",  "carina",  "cervix",  "caterva",  "caterva",  "Choose the best meaning for each English word");
        
//db.close();
    }
    private void addVocabQuestion(int questNum, String question, String ans1, String ans2, String ans3, String ans4, String corr, String ins)
    {
        if (Objects.equals(corr, ans1)) {
            Questions q1=new Questions(question, ans4, ans2, ans3, corr);//3
            this.addQuestion(q1);
        }
        else if (Objects.equals(corr, ans2)) {
            Questions q1=new Questions(question, ans1, ans4, ans3, corr);//3
            this.addQuestion(q1);
        } else if (Objects.equals(corr, ans3)) {
            Questions q1=new Questions(question, ans1, ans2, ans4, corr);//3
            this.addQuestion(q1);
        } else if (Objects.equals(corr, ans4)) {
            Questions q1=new Questions(question, ans1, ans2, ans3, corr);//3
            this.addQuestion(q1);
        }

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
// Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Questions quest) {
//SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());

// Inserting Row
        dbaseGrammar.insert(TABLE_QUEST, null, values);
    }
    public List<Questions> getAllQuestions() {
        List<Questions> quesList = new ArrayList<Questions>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_QUEST +" ORDER BY RANDOM() LIMIT 10";
        dbaseGrammar=this.getReadableDatabase();
        Cursor cursor = dbaseGrammar.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Questions questGrammar = new Questions();
                questGrammar.setID(cursor.getInt(0));
                questGrammar.setQUESTION(cursor.getString(1));
                questGrammar.setANSWER(cursor.getString(2));
                questGrammar.setOPTA(cursor.getString(3));
                questGrammar.setOPTB(cursor.getString(4));
                questGrammar.setOPTC(cursor.getString(5));
                quesList.add(questGrammar);
            } while (cursor.moveToNext());
        }
// return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT * FROM " + TABLE_QUEST + " ORDER BY RANDOM() LIMIT 10";
        SQLiteDatabase dbGrammar = this.getWritableDatabase();
        Cursor cursor = dbGrammar.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}