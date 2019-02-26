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
public class RomanLifeQuizDB  extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 3;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuizRL";
    // tasks table name
    private static final String TABLE_QUEST = "questRl";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c

    private SQLiteDatabase dbaseRLife;
    public RomanLifeQuizDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbaseRLife=db;
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
        Questions q1=new Questions("The room in which the ancient Romans ate their dinner was called the:", "peristylium", "culina", "tablinium", "triclinium");//3
        this.addQuestion(q1);
        Questions q2=new Questions("The Latin word for a baker was:" , "piscator", "coquus", "pomarius", "pistor");//AEQUI
        this.addQuestion(q2);
        Questions q3=new Questions("The Roman villa was originally a(n):","small city house", "apartment house","Roman temple","large country estate");//Tullus Hostillus
        this.addQuestion(q3);
        Questions q4=new Questions("The pool in the atrium used to collect rain water was called the:",    "impluvium", "cubiculum", "tablinum","compluvium");//Julius Proculus
        this.addQuestion(q4);
        // REMEMBER TO UPDATE DATABSE VERSION EACH TIME AFTER CHANGING
        Questions q5=new Questions("A saltatrix was a:","singer","drum","musician","dancer");//cannae
        this.addQuestion(q5);
        Questions q6=new Questions("Which type of gladiator fought with a trident?","Murmillo","Thrax","Secutor","Retiarius");//Hadrian
        this.addQuestion(q6);
        Questions q7=new Questions("Where was the Ludus Troiae performed?","Forum Romanum","Colosseum","Campus Martius","Circus Maximus");//Rhea Silvia
        this.addQuestion(q7);
        Questions q8=new Questions("The starting gates of the chariot races were called the:","spinae","metae","podia","carceres");//Milvian Bridge
        this.addQuestion(q8);
        Questions q9=new Questions("The charioteer was referred to as a(n):","spinae","metae","ducenarius","auriga");//Ancus Marcius
        this.addQuestion(q9);
        Questions q10=new Questions("Which of the following circi was built first?","Circus Flaminius","Circus of Maxentius","Circus of Nero","Circus Maximus");//cannae
        this.addQuestion(q10);
        Questions q11=new Questions("The phrase pollices premere is associated with:","the first chariot race of the year","betting on horses","giving the death blow to a gladiator","showing mercy to a gladiator");//cannae
        this.addQuestion(q11);
        Questions q12=new Questions("The stage of a theater was called the: ","cavea","cunei","scaena","orchestra");//cannae
        this.addQuestion(q12);
        Questions q13=new Questions("The dressing room at the thermae was known as the: ","tepidarium","frigidarium","calidarium","apodyterium");//cannae
        this.addQuestion(q13);
        Questions q14=new Questions("Which color fabric was the most expensive?","caerula","rubra","alba","purpura");//cannae
        this.addQuestion(q14);
        Questions q15=new Questions("Which of the following jewels were NOT a Roman girl's “best friend”? (She would not\n" +
                "wear.)","emerald","amythest","pearls","diamonds");//cannae
        this.addQuestion(q15);
        Questions q16=new Questions(" Caligae were:","baby shoes","bride's sandals","athletic shoes","military shoes");//cannae
        this.addQuestion(q16);
        Questions q17=new Questions("The job of this soldier was to distribute passwords:","legatus","tribunus","tesserarius","centurio");//cannae
        this.addQuestion(q17);
        Questions q18=new Questions("This member of a Roman legion carried a vitis:","aquilifer","signifer","cornicen","centurio");//cannae
        this.addQuestion(q18);
        Questions q19=new Questions("A soldier could look forward to an honorable discharge and either 3,000 denarii or an\n" +
                "allocation of land after serving for the following number of years:","10 to 15","21 to 26","26 to 30","16 to 20");//cannae
        this.addQuestion(q19);
        Questions q20=new Questions("What is land given to a former soldier called? ","ager militis","ager puer","ager privatus","ager publicus");//cannae
        this.addQuestion(q20);
        Questions q21=new Questions("During the Roman Empire full beards became fashionable for men during the reign of:", "Trajan", "Caracalla", "Nero", "Trajan");//3
        this.addQuestion(q21);
        Questions q22=new Questions("The first aqueduct built in Rome was the:" , "Aqua Marcia", "Aqua Alexandria", "Anio Novus", "Aqua Appia");//AEQUI
        this.addQuestion(q22);
        Questions q23=new Questions("Manes were:","orders from the emperor", "documents of the freedom of a slave","morning prayers","spirits of the dead");//Tullus Hostillus
        this.addQuestion(q23);
        Questions q24=new Questions("In a Legionary Fortress the valetudinarium was the:",    "headquarters", "granary", "great hall","hospital");//Julius Proculus
        this.addQuestion(q24);
        // REMEMBER TO UPDATE DATABSE VERSION EACH TIME AFTER CHANGING
        Questions q25=new Questions("The most stately form of marriage ceremony was called:","coemptio","usus","dos","confarreatio");//cannae
        this.addQuestion(q25);
        Questions q26=new Questions("When a girl was married her hair was parted with a spear and arranged into _______\n" +
                "locks.","3","2","8","6");//Hadrian
        this.addQuestion(q26);
        Questions q27=new Questions("Patricians wore shoes with a silver or ivory ornament shaped like a(n)","Cow","Eagle","Bull","Sheep");//Rhea Silvia
        this.addQuestion(q27);
        Questions q28=new Questions("Lunch was called:","ientaculum","cena","antacena","prandium");//Milvian Bridge
        this.addQuestion(q28);
        Questions q29=new Questions("At dinner, the Romans reclined on ____________ side(s) of the table","one","two","four","three");//Ancus Marcius
        this.addQuestion(q29);
        Questions q30=new Questions("The four major fish sauces were all of the following EXCEPT:","garum","liquamen","allec","defrutum");//cannae
        this.addQuestion(q30);
        Questions q31=new Questions("The arca was kept in the:","culina","cubiculum","triclinium","tablinum");//cannae
        this.addQuestion(q31);
        Questions q32=new Questions("An armless chair with a curved back was called a: ","sella","lectus","solium","cathedra");//cannae
        this.addQuestion(q32);
        Questions q33=new Questions("Mosaics depicting Latin phrases such as: “Cave Canem”, “Salve” and “Nihil intret\n" +
                "mali” were found in the: ","atrium","lararium","cubiculum","vestibulum");//cannae
        this.addQuestion(q33);
        Questions q34=new Questions("Which of the following is a woodwind instrument?","tuba","cithara","hydraulus","tibia");//cannae
        this.addQuestion(q34);
        Questions q35=new Questions("Which type of gladiator carried a parma and sica?","Samnis","Retiarius","Murmillo","Thrax");//cannae
        this.addQuestion(q35);
        Questions q36=new Questions("Which type of gladiator was referred to as a Hoplomachus during the Roman Empire?","Dimachaerus","Bestiarius","Andabata","Samnis");//cannae
        this.addQuestion(q36);
        Questions q37=new Questions("The Naumachiae were fought in the:","Circus Maximus","Colosseum","Theatrum Pompeium","Campus Martius");//cannae
        this.addQuestion(q37);
        Questions q38=new Questions("A mappa was used to:","excercise the horses","direct the horses around the track","wipe perspiration from the charioteer's brow","signal the beginning of the race");//cannae
        this.addQuestion(q38);
        Questions q39=new Questions("An actor wearing a wig made of red hair indicated the following character type:","a doddering old man","the young hero"," a sexy courtesan ","the clever slave");//cannae
        this.addQuestion(q39);
        Questions q40=new Questions("The sweat bath was known as the:","unctorium","hypocaust","strigilis","laconium");//cannae
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
        dbaseRLife.insert(TABLE_QUEST, null, values);
    }
    public List<Questions> getAllQuestions() {
        List<Questions> quesList = new ArrayList<Questions>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_QUEST +" ORDER BY RANDOM() LIMIT 10";
        dbaseRLife=this.getReadableDatabase();
        Cursor cursor = dbaseRLife.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Questions questRLife = new Questions();
                questRLife.setID(cursor.getInt(0));
                questRLife.setQUESTION(cursor.getString(1));
                questRLife.setANSWER(cursor.getString(2));
                questRLife.setOPTA(cursor.getString(3));
                questRLife.setOPTB(cursor.getString(4));
                questRLife.setOPTC(cursor.getString(5));
                quesList.add(questRLife);
            } while (cursor.moveToNext());
        }
// return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT * FROM " + TABLE_QUEST + " ORDER BY RANDOM() LIMIT 10";
        SQLiteDatabase dbRLife = this.getWritableDatabase();
        Cursor cursor = dbRLife.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}

