package com.ayushcoding.www.jclapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ayush on 5/1/2016.
 */
public class RomanHistoryQuestionsDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuizRH";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c

    private SQLiteDatabase dbase;
    public RomanHistoryQuestionsDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
        db.execSQL(sql);
        addQuestions();
//db.close();
    }
    private void addQuestions()
    {
        Questions q1=new Questions("How many Samnite Wars" +
                " did Rome fight in?","1", "2", "4", "3");//3
        this.addQuestion(q1);
        Questions q2=new Questions("Against what tribe did" +
                " Cincinnatus turn a defeat into a Roman victory during a 16 day dictatorship in 458 BC", "Volsci", "Cherusci", "Averni", "Aequi");//AEQUI
        this.addQuestion(q2);
        Questions q3=new Questions("Which king of Rome was known for his" +
                " bellicose nature and conquest of Alba Longa?","Numa Pompillius", "Tarquin the Elder","Ancus Marcius","Tullus Hostillius");//Tullus Hostillus
        this.addQuestion(q3);
        Questions q4=new Questions("Which senator was said to" +
                " have seen the deification of Romulus?",    "Titus Tatius", "Poplicola", "Mettius Fufetius","Juilius Proculus");//Julius Proculus
        this.addQuestion(q4);
        // REMEMBER TO UPDATE DATABSE VERSION EACH TIME AFTER CHANGING
        Questions q5=new Questions("Where did Rome suffer one of its greatest" +
                " military defeats in 216 B.C?","Ticinus River","Lake Trasimene","Trebia River","Cannae");//cannae
        this.addQuestion(q5);
        Questions q6=new Questions("Which Roman Emperor popularized" +
                " the beard?","Trajan","Antoninus Pius","Marcuss Aurelius","Hadrian");//Hadrian
        this.addQuestion(q6);
        Questions q7=new Questions("Who was the mother" +
                " of Romulus and Remus?","Cornelia","Metella","Agrippina","Rhea Silvia");//Rhea Silvia
        this.addQuestion(q7);
        Questions q8=new Questions("Where did Constantne defeat his rival " +
                " Maxentius in battle in 312 A.D?","Bedriacum","Chrysopolis","Nicopolis","Milvian Bridge");//Milvian Bridge
        this.addQuestion(q8);
        Questions q9=new Questions("The fourth king of Rome was","Numa Pompillius","Tullus Hostillius","Tarquinus Priscus","Ancus Marcius");//Ancus Marcius
        this.addQuestion(q9);
        Questions q10=new Questions("The Roman hero known as “Lefty” is","Horatius Cocles","Cloelia","Marcus Manlius","Scaevola");//cannae
        this.addQuestion(q10);
        Questions q11=new Questions("The first enemy to use elephants against the Romans was","Hannibal","Brennus","Ariovistus","Pyrrhus");//cannae
        this.addQuestion(q11);
        Questions q12=new Questions("Rome’s law of treason forbade a governor to lead his troops outside his province. When Caesar\n" +
                "crossed the ____ River with a single legion, he broke this law. ","Ebro","Po","Tiber","Rubicon");//cannae
        this.addQuestion(q12);
        Questions q13=new Questions("The Second Triumvirate was composed of Octavian, Antony, and ","Brutus","Crassus","Lucullus","Lepidus");//cannae
        this.addQuestion(q13);
        Questions q14=new Questions("Which man left his plow in 458 BCE to become dictator? ","Coriolanus","Camillus","Cato the Elder","Cincinnatus");//cannae
        this.addQuestion(q14);
        Questions q15=new Questions("What did Caesar say when he defeated Pharnaces II?","Alea iacta est","Sic semper tyrannis","In hoc signo vinces","Veni, Vidi, Vici");//cannae
        this.addQuestion(q15);
        Questions q16=new Questions(" Against whom did Cicero deliver orations known as the Philippics? ","Caesar","Brutus","Pompey","Antony");//cannae
        this.addQuestion(q16);
        Questions q17=new Questions("The first wooden bridge built in Rome was the Pons","Milvius","Fabricius","Cestius","Sublicius");//cannae
        this.addQuestion(q17);
        Questions q18=new Questions("Cato the Younger committed suicide at","Hippo","Pharsalus","Munda","Utica");//cannae
        this.addQuestion(q18);
        Questions q19=new Questions("The Lex Hortensia of 287 BCE stated that","plebeians could marry patricians","plebeians could become consuls","the Senate could veto laws passed by the Concilium Plebis","laws passed by the Concilium Plebis would be binding on all citizens, even patricians");//cannae
        this.addQuestion(q19);
        Questions q20=new Questions("Where did the Romans fight their first naval battle? ","Ausculum","Tarentum","Zama","Mylae");//cannae
        this.addQuestion(q20);

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
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Questions> getAllQuestions() {
        List<Questions> quesList = new ArrayList<Questions>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_QUEST +" ORDER BY RANDOM() LIMIT 10";
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Questions quest = new Questions();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
// return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT * FROM " + TABLE_QUEST + " ORDER BY RANDOM() LIMIT 10";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}
