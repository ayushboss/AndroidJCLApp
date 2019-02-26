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
 * Created by Ayush on 5/3/2016.
 */
public class LatinLitQuizDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuizLiter";
    // tasks table name
    private static final String TABLE_QUEST = "questLiter";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c

    private SQLiteDatabase dbaseLit;
    String  subCopy;
    public LatinLitQuizDB(Context context, String subject) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.subCopy = subject;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbaseLit=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
        db.execSQL(sql);
        addQuestions(subCopy);
//db.close();
    }
    private void addQuestions(String subject)
    {
        if (Objects.equals(subject, "vocab")) {
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

        } else if(Objects.equals(subject, "lit")) {
            Questions q1 = new Questions("The author of Poenulus is", "Ennius", "Cato the Elder", "Livy", "Plautus");//3
            this.addQuestion(q1);
            Questions q2 = new Questions("Which rhetorician born in Spain was the first person to receive a paid professorship from\n" +
                    "Vespasian? ", "Seneca", "Lucan", "Pliny the Elder", "Quintillian");//AEQUI
            this.addQuestion(q2);
            Questions q3 = new Questions("Which Roman emperor wrote A Greek History of the Etruscans?", "Nero", "Trajan", "Marcus Aurelius", "Claudius");//Tullus Hostillus
            this.addQuestion(q3);
            Questions q4 = new Questions("Which Roman poet published a book of elegies dedicated to Delia?", "Porpertius", "Vergil", "Horace", "Tibullus");//Julius Proculus
            this.addQuestion(q4);
            // REMEMBER TO UPDATE DATABSE VERSION EACH TIME AFTER CHANGING
            Questions q5 = new Questions("All of the following are plays written by Terrence EXCEPT", "Eunuchus Timorumenos", "Hecyra", "Heauton", "Nemesis");//cannae
            this.addQuestion(q5);
            Questions q6 = new Questions("Which author wrote an epigram for a slave girl who died before the age of six? ", "Tacitus", "Caligula", "Juvenal", "Martial");//Hadrian
            this.addQuestion(q6);
            Questions q7 = new Questions("Who wrote Germania, a treatise that discusses the geography, politics, and customs of the German people? ", "Julius Caesar", "Augustus", "Suetonius", "Tacitus");//Rhea Silvia
            this.addQuestion(q7);
            Questions q8 = new Questions("Cicero’s earliest extant speech is", "In Verrem", "Pro Caelio", "In Catilinam", "Pro Quinctio");//Milvian Bridge
            this.addQuestion(q8);
            Questions q9 = new Questions("The author of de Viris Illustribus is", "Seneca", "Tacitus", "Pliny the Younger", "Suetonius");//Ancus Marcius
            this.addQuestion(q9);
            Questions q10 = new Questions("Which satirist was banished to Egypt by Domitian?", "Lucan", "Seneca", "Horace", "Juvenal");//cannae
            this.addQuestion(q10);
            Questions q11 = new Questions("Who is the author of Epistulae ex Pontō, Halieutica, and Ibis? ", "Vergil", "Horace", "Propertius", "Ovid");//cannae
            this.addQuestion(q11);
            Questions q12 = new Questions("L. Aelius Stilo Praeconinus taught the science of philology to Varro and ", "Caesar", "Augustus", "Pompey", "Cicero");//cannae
            this.addQuestion(q12);
            Questions q13 = new Questions("What was the relationship between Pliny the Elder and Pliny the Younger? ", "grandfather and grandson", "father and son", "older and younger brothers", "uncle and nephew");//cannae
            this.addQuestion(q13);
            Questions q14 = new Questions("Animula vagula blandula hospes comesque corporis…is the beginning of a poem by", "Martial", "Antoninus Pius", "Horace", "Hadrian");//cannae
            this.addQuestion(q14);
            Questions q15 = new Questions(". Which Roman author describes Rome’s mission thus: parcere subiectis et debellare\n" +
                    "superbos?", "Horace", "Caesar", "Cicero", "Vergil");//cannae
            this.addQuestion(q15);
            Questions q16 = new Questions("Who composed the first Roman comedy? ", "Ennius", "Plautus", "Ovid", "Livius Andronicus");//cannae
            this.addQuestion(q16);
            Questions q17 = new Questions("Identical twins are characters in the play ", "Captivi", "Mercator", "Mostellaria", "Menaechmi");//cannae
            this.addQuestion(q17);
            Questions q18 = new Questions("Which grammarian analyzed Vergil’s Aeneid?", "Ovid", "Ennius", "Cato", "Servius");//cannae
            this.addQuestion(q18);
            Questions q19 = new Questions("The entire de Bellō Gallicō covers the years ", "63-59 BCE", "60-55 BCE", "49-44 BCE", "58-51 BCE");//cannae
            this.addQuestion(q19);
            Questions q20 = new Questions("Which of these speeches by Cicero was delivered first? ", "In Catilinam", "Pro Archia", "Pro Marcello", "In Verrem");//cannae
            this.addQuestion(q20);
            Questions q21 = new Questions("In which of these poems by Vergil do shepherds celebrate the deification of Daphnis? ", "Sirics", "Georgics", "Catalepton", "Eclogues");//3
            this.addQuestion(q21);
            Questions q22 = new Questions("In what book of the Aeneid are funeral games held for Anchises? ", "1", "3", "7", "5");//AEQUI
            this.addQuestion(q22);
            Questions q23 = new Questions("Which work of Ovid’s deals with the Roman calendar?", "Heroides", "Metamorphoses", "Epistula ad Pisones", "Fastii");//Tullus Hostillus
            this.addQuestion(q23);
            Questions q24 = new Questions("Who wrote Facta et Dicta Memorabilia? ", "Velleius Paterculus", "Ammianus Marcellinus", "Curtius Rufus", "Valerius Maximus");//Julius Proculus
            this.addQuestion(q24);
            // REMEMBER TO UPDATE DATABSE VERSION EACH TIME AFTER CHANGING
            Questions q25 = new Questions("The author of de Rerum Naturā is ", "Vergil", "Martial", "Horace", "Lucretius");//cannae
            this.addQuestion(q25);
            Questions q26 = new Questions("Moretum and Copa are minor poems attributed to ", "Tibullus", "Propertius", "Lucan", "Vergil");//Hadrian
            this.addQuestion(q26);
            Questions q27 = new Questions("If a guy wants to know where to find a girl who is right for him, he should consult", "Tibullus", "Propertius", "Vergil", "Ovid");//Rhea Silvia
            this.addQuestion(q27);
            Questions q28 = new Questions("Which author did not compose a work about agriculture? ", "Vergil", "Columella", "Cato", "Lucretius");//Milvian Bridge
            this.addQuestion(q28);
            Questions q29 = new Questions(". Which emperor did Pliny the Younger ask about dealing with the Christians? ", "Hadrian", "TItus", "Antoninus Pius", "Trajan");//Ancus Marcius
            this.addQuestion(q29);
            Questions q30 = new Questions("Who wrote an account of his career called the Res Gestae? ", "Agricola", "Claudius", "Seneca", "Augustus");//cannae
            this.addQuestion(q30);
            Questions q31 = new Questions("Which of the following was not a Silver Age writer? ", "Suetonius", "Pliny the Elder", "Pliny the Younger", "Naevius");//cannae
            this.addQuestion(q31);
            Questions q32 = new Questions("To what place was Ovid exiled?", "Capri", "Egypt", "Britannia", "Tomi");//cannae
            this.addQuestion(q32);
            Questions q33 = new Questions("By what other name is Lucan’s Pharsalia called? ", "Carmina", "Silvae", "Laus Pisonis", "Bellum Civile");//cannae
            this.addQuestion(q33);
            Questions q34 = new Questions("Persius wrote works in which genre?", "comedy", "history", "tragedy", "satire");//cannae
            this.addQuestion(q34);
            Questions q35 = new Questions("Who wrote de Nabuthae?", "St. Jerome", "St. Augustine", "St. Callixtus", "St. Ambrose");//cannae
            this.addQuestion(q35);
            Questions q36 = new Questions("Who wrote the Carmen Saeculare? ", "Martial", "Ovid", "Vergil", "Horace");//cannae
            this.addQuestion(q36);
            Questions q37 = new Questions("Where was Propertius born?", "Verona", "Roma", "Mantua", "Umbria");//cannae
            this.addQuestion(q37);
            Questions q38 = new Questions("L. Caecilius Firmianus Lactantius was 2an advisor to the emperor", "Valerianus", "Marcus Aurelius", "Hadrian", "Constantine");//cannae
            this.addQuestion(q38);
            Questions q39 = new Questions("Which books of the Aeneid correspond to the Iliad? ", "I - VI", "VIII - X", "II - III", "VII - XII");//cannae
            this.addQuestion(q39);
            Questions q40 = new Questions("Apicius wrote a book about ", "farming", "fishing", "writing", "cooking");//cannae
            this.addQuestion(q40);
        }
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
        dbaseLit.insert(TABLE_QUEST, null, values);
    }
    public List<Questions> getAllQuestions() {
        List<Questions> quesList = new ArrayList<Questions>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_QUEST +" ORDER BY RANDOM() LIMIT 10";
        dbaseLit=this.getReadableDatabase();
        Cursor cursor = dbaseLit.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Questions questLit = new Questions();
                questLit.setID(cursor.getInt(0));
                questLit.setQUESTION(cursor.getString(1));
                questLit.setANSWER(cursor.getString(2));
                questLit.setOPTA(cursor.getString(3));
                questLit.setOPTB(cursor.getString(4));
                questLit.setOPTC(cursor.getString(5));
                quesList.add(questLit);
            } while (cursor.moveToNext());
        }
// return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT * FROM " + TABLE_QUEST + " ORDER BY RANDOM() LIMIT 10";
        SQLiteDatabase dbLit = this.getWritableDatabase();
        Cursor cursor = dbLit.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}
