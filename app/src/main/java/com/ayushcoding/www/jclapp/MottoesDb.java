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
 * Created by Ayush on 7/6/2016.
 */
public class MottoesDb extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 2;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuizMottoes";
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
    public MottoesDb(Context context) {
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
        addVocabQuestion(0,  "'Excelsior'",  "New York",  "New Jersey",  "Colorado",  "New Mexico",  "New York",  "Match the motto to its state");
        addVocabQuestion(1,  "'Cedant arma togae'",  "Washington",  "Pennsylvania",  "Wyoming",  "Delaware",  "Wyoming",  "Match the motto to its state");
        addVocabQuestion(2,  "'Montani semper liberi'",  "Montana",  "West Virginia",  "Oregon",  "Vermont",  "West Virginia",  "Match the motto to its state");
        addVocabQuestion(3,  "'Esto Perpetua'",  "Idaho",  "North Dakota",  "Iowa",  "Virginia",  "Idaho",  "Match the motto to its state");
        addVocabQuestion(4,  "'Virtute et armis'",  "Georgia",  "South Carolina",  "Alabama",  "Mississippi",  "Mississippi",  "Match the motto to its state");
        addVocabQuestion(5,  "'Dirigo'",  "Massachussetts",  "Maine",  "Ohio",  "Florida",  "Maine",  "Match the motto to its state");
        addVocabQuestion(6,  "'Regnat populus'",  "Arkansas",  "Texas",  "Kansas",  "North Carolina",  "Arkansas",  "Match the motto to its state");
        addVocabQuestion(7,  "'Ditat Deus'",  "Alaska",  "Nevada",  "Arizona",  "Indiana",  "Arizona",  "Match the motto to its state");
        addVocabQuestion(8,  "'Labor omnia vincit'",  "Missouri",  "Minnosota",  "Oklahoma",  "Hawaii",  "Oklahoma",  "Match the motto to its state");
        addVocabQuestion(9,  "'Dum spiro, spero'",  "South Dakota",  "South Carolina",  "North Dakota",  "Montana",  "South Carolina",  "Match the motto to its state");
        addVocabQuestion(10,  "What is the meaning of 'Rosam quae meruit ferat' (Motto of Sweet Briar College in Virginia)",  "She who picks the rose may wear it",  "She who tends the rose may hold it",  "The roses bears many thorns",  "She who has earned the rose may bear it",  "She who has earned the rose may bear it",  "Choose the correct answer");
        addVocabQuestion(11,  "“Litteris dedicate et omnibus artibus” is the motto of the University of Nebraska. It means:",  "Literature and art are dedicated to all",  "Everyone must learn art and literature",  "Dedicated to letters and all the arts",  "All arts and letters show dedication",  "Dedicated to letters and all the arts",  "Choose the correct answer");
        addVocabQuestion(12,  "'Disciplina praesidium civitatis'",  "University of Texas",  "University of Arkansas",  "Harvard",  "MIT",  "University of Texas",  "Match the motto to its alma mater");
        addVocabQuestion(13,  "'Cuvu et Republicae'",  "Univeristy of Oklahoma",  "University of Houston",  "Tulane Univeristy",  "Louisiana State University",  "University of Oklahoma",  "Match the motto to its alma mater");
        addVocabQuestion(14,  "'Veritatem Dilexi'",  "Bryn Mawr College",  "Rice University",  "Vassar College",  "Amherst College",  "Bryn Mawr",  "Match the motto to its alma mater");
        addVocabQuestion(15,  "Requiescat in pace",  "R.I.P",  "RQP",  "RP",  "RQC",  "R.I.P",  "Choose the abbreviation to the phrase");
        addVocabQuestion(16,  "vudekucet",  "viz",  "vs",  "q.v",  "v.",  "viz.",  "Match the abbreviation to its phrase");
        addVocabQuestion(17,  "recipe",  "Rx",  "Re",  "r",  "REG",  "Rx",  "Match the abbreviation to its phrase");
        addVocabQuestion(18,  "ibidem",  "ibid.",  "id.",  "i.a",  "i.e",  "ibid.",  "Match the abbreviation to its phrase");
        addVocabQuestion(19,  "All of the following are acceptable abbreviations for “circa” EXCEPT:",  "c.",  "ca.",  "cr.",  "cca.",  "c.",  "Choose the correct answer");
        addVocabQuestion(20,  "A.D",  "after death",  "in the year of our Lord",  "towards",  "to",  "in the year of our Lord",  "Match the abbreviations to their English Meaning");
        addVocabQuestion(21,  "REG",  "queen",  "regular",  "rule",  "regiment",  "queen",  "Match the abbreviation to its English meaning");
        addVocabQuestion(22,  "prn",  "pronoun",  "as needed",  "peace out",  "pernicious",  "pronoun",  "Match the abbreviation to its English Meaning");
        addVocabQuestion(23,  "o.d",  "in the right eye",  "in the left eye",  "over does",  "odor",  "in the left eye",  "Match the abbreviation to its English Meaning");
        addVocabQuestion(24,  "'Arma virumque cano'",  "Caesar",  "Horace",  "Vergil",  "Catullus",  "Caesar",  "Who is the author of this motto?");
        addVocabQuestion(25,  "'Non omnis moriar'",  "Seneca",  "Horace",  "Sallust",  "St. Augustine",  "Sallust",  "Who is the author of this motto?");
        addVocabQuestion(26,  "'Modus omnibus in rebus'",  "Plautus",  "Cicero",  "Horace",  "Syrus",  "Cicero",  "Who is the author of this motto?");
        addVocabQuestion(27,  "'Cogito ergo sum'",  "Descartes",  "Locke",  "Bacon",  "Franklin",  "Descartes",  "Who is the author of this motto?");
        addVocabQuestion(28,  "'Ars longa, vita brevis'",  "Hippocrates",  "Ovid",  "Catullus",  "Vergil",  "Hippocrates",  "Who is the author of this motto?");
        addVocabQuestion(29,  "The motto of the modern Olympic movement is",  "Citius, altius, fortisu",  "In hoc signo vinces",  "festina lente",  "Audentis fortuna iuvat",  "In hoc signo vinces",  "Choose the correct answer");
        addVocabQuestion(30,  "Students of Spanish, French and American Sign Language who dare to question the study of Latin would do well to remember this motto!",  "persona non grata",  "sic transit gloria mundi",  "Rident stolidi verb Latina",  "Cedant arma togae",  "persona non grata",  "Choose the correct answer");
        addVocabQuestion(31,  "All of the following Latin words and Phrases pertain to the theatre EXCEPT:",  "exeunt",  "dramatis personae",  "deus ex machina",  "ad acta",  "deus ex machina",  "Choose the correct answer");
        addVocabQuestion(32,  "“Nos moraturi te salutamus” was traditionally said at a Roman:",  "funeral",  "temple",  "army camp",  "market place",  "market place",  "Choose the correct answer");
        addVocabQuestion(33,  "“Ubi tu Gaius, ibi ego Gaia” was traditionally said at a Roman:",  "chariot race",  "bath house",  "wedding",  "senate meeting",  "wedding",  "Choose the correct answer");
        addVocabQuestion(34,  "“ Ollus Quiris leto datus” was traditionally said at a Roman:",  "funeral",  "household shrine",  "library",  "dinner",  "library",  "Choose the correct answer");
        addVocabQuestion(35,  "In today's society, an example of a “vade mecum” would be",  "an airplane",  "a cell phone",  "a television",  "a SUV",  "an airplane",  "Choose the correct answer");
        addVocabQuestion(36,  "In Texas in the summertime, an example of a “sine qua non” would be:",  "a beach ball",  "a frisbee",  "a bottle of water",  "gum",  "a frisbee",  "Choose the correct answer");
        addVocabQuestion(37,  "'sub rosa' means:",  "secretly",  "a floral bouquet",  "in the garden",  "a church",  "in the garden",  "Choose the correct answer");
        addVocabQuestion(38,  "'sui generis' means:'",  "family",  "unique",  "old age",  "inheritance",  "family",  "Choose the correct answer");
        addVocabQuestion(39,  "'ultima Thule' means",  "a distant land",  "the highest honor",  "the tallest soldier",  "very expensive",  "the highest honor",  "Choose the correct answer");
        addVocabQuestion(40,  "Where would you most likely read “si sol deficit, respicit me nemo”.",  "at a museum",  "on a clock face",  "at the zoo",  "on a sundial",  "at a museum",  "Choose the correct answer");
        addVocabQuestion(41,  "The phrase “inter canem et lupum” metaphorically means",  "in the 'dog house'",  "at dawn",  "in the wilderness",  "at twilight",  "in the wilderness",  "Choose the correct answer");
        addVocabQuestion(42,  "The phrase “a fronte praecipitium a tergo lupi” metaphorically means:",  "between a rock and a hard place",  "a rolling stone gathers no moss",  "too many cooks spoil the broth",  "the grass is always greener on the other side",  "the grass is always on the other side",  "Choose the correct answer");
        addVocabQuestion(44,  "“obiter dictum” is a(n):",  "incidental opinion",  "an advertisement",  "a new fad",  "a strict order",  "incidental opinion",  "Choose the correct answer");
        addVocabQuestion(45,  "When your Latin teacher took the day off of school Friday, s/he had to find a person to teach in their place. The Latin phrase for this is:",  "in propria persona",  "ipse dixit",  "mutatis mutandis",  "locum tenens",  "in propria persona",  "Choose the correct answer");
        addVocabQuestion(46,  "“ad praesens ova cras pullis sunt meliora” is best defined by this proverb:",  "A bird in hand is worth two in the bush",  "Which came first, the chicken or the egg?",  "Don't count your chickens before they hatch",  "Don't be a chicken!",  "Don't be a chicken!",  "Choose the correct answer");
        addVocabQuestion(47,  "Lady Gaga, Cher and Madonna are all examples of a:",  "viva voce",  "per diem",  "rara avis",  "casus belli",  "viva voce",  "Choose the correct answer");
        addVocabQuestion(48,  "“aqua et igni interdictus” is synonymous with:",  "declaring war",  "a confession",  "banishment",  "being under arrest",  "banishment",  "Choose the correct answer");
        addVocabQuestion(49,  "“quid pro quo” is best defined by the saying:",  "never judge a book by its cover",  "you scratch my back and I'll scratch yours",  "opportunity only knocks once",  "the buck stops here",  "opportunity only knocks once",  "Choose the correct answer");
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
