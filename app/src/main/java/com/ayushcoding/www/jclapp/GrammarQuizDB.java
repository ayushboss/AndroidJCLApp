package com.ayushcoding.www.jclapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ayush on 5/3/2016.
 */
public class GrammarQuizDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuizGrammar";
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
    public GrammarQuizDB(Context context) {
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
        addQuestions();
//db.close();
    }
    private void addQuestions()
    {
        Questions q1=new Questions("TRANSLATE THE WORD IN SINGLE QUOTES INTO LATIN : Arīon erat 'very famous' poēta Graecus", "notus", "notior", "notissime", "notissimus");//3
        this.addQuestion(q1);
        Questions q2=new Questions("TRANSLATE THE WORD IN SINGLE QUOTES INTO LATIN : Hoc mare 'safer' quam Oceānus Atlanticus est" , "tutus", "tutius", "tutissimus", "tutior");//AEQUI
        this.addQuestion(q2);
        Questions q3=new Questions("A Latin finite verb form has these grammatical characteristics:","tense, person, number, case, and mood", "case, tense, gender, mood, and voice","person, number, tense, case, and mood","tense, voice, mood, person, and number");//Tullus Hostillus
        this.addQuestion(q3);
        Questions q4=new Questions("A Latin noun form has these grammatical characteristics:",    "gender, case, number, and tense", "tense, case, and number", "case, tense, voice, and gender","gender, number, and case");//Julius Proculus
        this.addQuestion(q4);
        // REMEMBER TO UPDATE DATABSE VERSION EACH TIME AFTER CHANGING
        Questions q5=new Questions("A Latin adjective must agree with the noun it describes in…","number, case, and declension","tense, number, and case","gender, case, and declension","case, number, and gender");//cannae
        this.addQuestion(q5);
        Questions q6=new Questions("An adverb may be:","positive","comparative","neither positive nor comparative","either positive or comparative");//Hadrian
        this.addQuestion(q6);
        Questions q7=new Questions("From which principal part of a verb do the imperfect and future tenses form?","1st","3rd","4th","2nd");//Rhea Silvia
        this.addQuestion(q7);
        Questions q8=new Questions("From which principal part of a regular verb does the perfect tense, passive voice form?","1st","2nd","3rd","4th");//Milvian Bridge
        this.addQuestion(q8);
        Questions q9=new Questions("How many Latin verb tenses are there?","3","4","5","6");//Ancus Marcius
        this.addQuestion(q9);
        Questions q10=new Questions("How many Latin noun declensions are there?","2","3","4","5");//cannae
        this.addQuestion(q10);
        Questions q11=new Questions("To which conjugation does the verb peto, petere belong?","1st","2nd","4th","3th");//cannae
        this.addQuestion(q11);
        Questions q12=new Questions("To which declension does the noun corpus, corporis belong?","2nd","4th","5th","3rd");//cannae
        this.addQuestion(q12);
        Questions q13=new Questions("Which Latin word would introduce the question “You did your homework, right?”","ne","nec","num","nonne");//cannae
        this.addQuestion(q13);
        Questions q14=new Questions("What Latin case can be used to show possession?","Nominative","Accusative","Vocative","Dative");//cannae
        this.addQuestion(q14);
        Questions q15=new Questions("What Latin case is used to express the means by which a task is done?","Genetive","Dative","Accusative","Ablative");//cannae
        this.addQuestion(q15);
        Questions q16=new Questions("With what case would you translate the word „master‟ in this sentence: “Thank you, master.” ","Nominative","Dative","Accusative","Vocative");//cannae
        this.addQuestion(q16);
        Questions q17=new Questions("What noun case is used to expresses time when an event occurs?","Genitive","Dative","Accusative","Ablative");//cannae
        this.addQuestion(q17);
        Questions q18=new Questions("IDENTIFY THE CASE OR TENSE OF WORDS WITH SINGLE QUOTES AROUND THEM : 'fuit' imperātor nōmine Otho","present","imperfect","future","imperfect");//cannae
        this.addQuestion(q18);
        Questions q19=new Questions("IDENTIFY THE CASE OR TENSE OF WORDS WITH SINGLE QUOTES AROUND THEM : 'senatōrēs' pugnāntēs puella vīderat.","Nominative","Dative","Ablative","Accusative");//cannae
        this.addQuestion(q19);
        Questions q20=new Questions("IDENTIFY THE CASE OR TENSE OF WORDS WITH SINGLE QUOTES AROUND THEM : servī magnum pavōnem 'coquent'.","Present","Perfect","Pluperfect","Future");//cannae
        this.addQuestion(q20);
        Questions q21=new Questions("IDENTIFY THE CASE OR TENSE OF WORDS WITH SINGLE QUOTES AROUND THEM : dea Venus 'virō' piō favit.", "Genetive", "Vocative", "Ablative", "Dative");//3
        this.addQuestion(q21);
        Questions q22=new Questions("IDENTIFY THE CASE OR TENSE OF WORDS WITH SINGLE QUOTES AROUND THEM : verba ducis scrībīs 'audīta erunt'." , "Imperfect", "Future", "Perfect", "Future Perfect");//AEQUI
        this.addQuestion(q22);
        Questions q23=new Questions("IDENTIFY THE CASE OR TENSE OF WORDS WITH SINGLE QUOTES AROUND THEM : mīlitēs per rivum 'frigidum' natābant.","Locative", "Dative","Ablative","Accusative");//Tullus Hostillus
        this.addQuestion(q23);
        Questions q24=new Questions("IDENTIFY THE CASE OR TENSE OF WORDS WITH SINGLE QUOTES AROUND THEM : virī Rōmānī, fortissimī 'estis'!", "Imperfect", "Future", "Perfect","Present");//Julius Proculus
        this.addQuestion(q24);
        // REMEMBER TO UPDATE DATABSE VERSION EACH TIME AFTER CHANGING
        Questions q25=new Questions("IDENTIFY THE CASE OR TENSE OF WORDS WITH SINGLE QUOTES AROUND THEM : cantāre 'mihi' placet.","Nominative","Accusative","Ablative","Dative");//cannae
        this.addQuestion(q25);
        Questions q26=new Questions("IDENTIFY THE CASE OR TENSE OF WORDS WITH SINGLE QUOTES AROUND THEM : servī vīllam 'trēs' annōs aedificābant","Dative","Accusative","Ablative","Genetive");//Hadrian
        this.addQuestion(q26);
        Questions q27=new Questions("IDENTIFY THE CASE OR TENSE OF WORDS WITH SINGLE QUOTES AROUND THEM : 'erunt' multī nautae in nave","Present","Imperfect","Perfect","Future");//Rhea Silvia
        this.addQuestion(q27);
        Questions q28=new Questions("IDENTIFY THE CASE OR TENSE OF WORDS WITH SINGLE QUOTES AROUND THEM : vīs 'hostium' erat maxima.","Nominative","Dative","Accusative","Genetive");//Milvian Bridge
        this.addQuestion(q28);
        Questions q29=new Questions("IDENTIFY THE CASE OR TENSE OF WORDS WITH SINGLE QUOTES AROUND THEM : puella epistulam 'stilō' scribit.","Nominative","Genitive","Dative","Ablative");//Ancus Marcius
        this.addQuestion(q29);
        Questions q30=new Questions("IDENTIFY THE CASE OR TENSE OF WORDS WITH SINGLE QUOTES AROUND THEM : nōs urbem invenīre nōn 'potuimus'.","Presen","Imperfect","Future","Perfect");//cannae
        this.addQuestion(q30);
        Questions q31=new Questions("IDENTIFY THE CASE OR TENSE OF WORDS WITH SINGLE QUOTES AROUND THEM : magnus lupus malus ā benignō 'vēnātōre' interfectus est.","Nominative","Genitive","Accusative","Ablative");//cannae
        this.addQuestion(q31);
        Questions q32=new Questions("CHOOSE THE LATIN WORD OR PHRASE THAT WOULD BEST TRANSLATE WORDS IN SINGLE QUOTES : 'The soldiers' are attacking the enemy camp","miles","militi","militiae","milites");//cannae
        this.addQuestion(q32);
        Questions q33=new Questions("CHOOSE THE LATIN WORD OR PHRASE THAT WOULD BEST TRANSLATE WORDS IN SINGLE QUOTES : My books are in 'the study'.","tablinam","tablinum","tablinae","tablino");//cannae
        this.addQuestion(q33);
        Questions q34=new Questions("CHOOSE THE LATIN WORD OR PHRASE THAT WOULD BEST TRANSLATE WORDS IN SINGLE QUOTES : 'His' mother told him a story.","suae","suus","is","ejus");//cannae
        this.addQuestion(q34);
        Questions q35=new Questions("CHOOSE THE LATIN WORD OR PHRASE THAT WOULD BEST TRANSLATE WORDS IN SINGLE QUOTES : The beautiful flowers 'were brought' by the gardener.","portabant","portantur","portatur","portati sunt");//cannae
        this.addQuestion(q35);
        Questions q36=new Questions("CHOOSE THE LATIN WORD OR PHRASE THAT WOULD BEST TRANSLATE WORDS IN SINGLE QUOTES : The servant walked to school 'with the children'.","liberis","liberi","cum liberos","cum liberis");//cannae
        this.addQuestion(q36);
        Questions q37=new Questions("CHOOSE THE LATIN WORD OR PHRASE THAT WOULD BEST TRANSLATE WORDS IN SINGLE QUOTES : 'Whose' pencil is this?","quis","qui","quem","cuius");//cannae
        this.addQuestion(q37);
        Questions q38=new Questions("CHOOSE THE LATIN WORD OR PHRASE THAT WOULD BEST TRANSLATE WORDS IN SINGLE QUOTES : The farmers at the market were 'very happy' today","laetos","laetiores","laetissimae","laetissimi");//cannae
        this.addQuestion(q38);
        Questions q39=new Questions("CHOOSE THE LATIN WORD OR PHRASE THAT WOULD BEST TRANSLATE WORDS IN SINGLE QUOTES : The boy 'wants' to eat a small dinner","vellit","voluit","volunt","vult");//cannae
        this.addQuestion(q39);
        Questions q40=new Questions("CHOOSE THE LATIN WORD OR PHRASE THAT WOULD BEST TRANSLATE WORDS IN SINGLE QUOTES : 'Don‟t' run down the hallway!","nolle","non","num","noli");//cannae
        this.addQuestion(q40);

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
