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
public class GreekMythologyQuestionsDB extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuizMyth";
    // tasks table name
    private static final String TABLE_QUEST = "questMyth";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c

    private SQLiteDatabase dbaseMyth;
    public GreekMythologyQuestionsDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbaseMyth=db;
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
        Questions q1=new Questions("He went looking for a bride and upon seeing Persephone, kidnapped her", "Apollo", "Poseidon", "Hermes", "Hades");//3
        this.addQuestion(q1);
        Questions q2=new Questions("This god of warfare was not admired by the Greeks; the Romans loved his counterpart" , "Dionysus", "Hephaestus", "Neptune", "Ares");//AEQUI
        this.addQuestion(q2);
        Questions q3=new Questions("He eloped with Helen to Troy, causing the Trojan War","Hector", "Ganymede","Deiphobus","Paris");//Tullus Hostillus
        this.addQuestion(q3);
        Questions q4=new Questions("He led an Expedition to recover the Golden Fleece and bring it back to Greece",    "Perseus", "Alcmaeon", "Melicertes","Jason");//Julius Proculus
        this.addQuestion(q4);
        // REMEMBER TO UPDATE DATABSE VERSION EACH TIME AFTER CHANGING
        Questions q5=new Questions("Actaeon saw her bathing and was punished severely, turned into a stag","Aphrodite","Athena","Hera","Artemis");//cannae
        this.addQuestion(q5);
        Questions q6=new Questions("This half-man, half-bull lived in the Labyrinth until killed by Theseus","Geryon","Charon","Typhoon","Minotaur");//Hadrian
        this.addQuestion(q6);
        Questions q7=new Questions("He killed the Lernaean Hydra","Achilles","Jason","Theseus","Heracles");//Rhea Silvia
        this.addQuestion(q7);
        Questions q8=new Questions("This half-goat half-man woodland deity played the syrinx, a reed instrument","Lichas","Butes","Marsyas","Pan");//Milvian Bridge
        this.addQuestion(q8);
        Questions q9=new Questions("He was the father of Romulus and Remus","Jupiter","Neptune","Mercury","Mars");//Ancus Marcius
        this.addQuestion(q9);
        Questions q10=new Questions("Who killed the Calydonian Boar","Atalanta","Heracles","Theseus","Meleager");//cannae
        this.addQuestion(q10);
        Questions q11=new Questions("These three aged sisters share one eye and one tooth between them\n","Graecae","Graces","Erinyes","Graeae");//cannae
        this.addQuestion(q11);
        Questions q12=new Questions("Driven by love, she aided in obtaining the Golden Fleece with her magical powers ","Circes","Nausicaa","Pasiphae","Medea");//cannae
        this.addQuestion(q12);
        Questions q13=new Questions("This monster was part goat, part lion, and part snake","Echidna","Typhoon","Orthrus","Chimaera");//cannae
        this.addQuestion(q13);
        Questions q14=new Questions("Who defeated Periphetes","Achilles","Heracles","Odysseus","Theseus");//cannae
        this.addQuestion(q14);
        Questions q15=new Questions("This wise centaur taught many heroes, but he was accidentally killed by an arrow of Heracles","Bienor","Damastes","Eurytion","Chiron");//cannae
        this.addQuestion(q15);
        Questions q16=new Questions("He was the husband of Alcmena and the supposed father of Heracles","Evenus","Lycurgus","Pittheus","Amphitrion");//cannae
        this.addQuestion(q16);
        Questions q17=new Questions("She is the Muse of History","Euterpe","Polyhymnia","Terpsicore","Clio");//cannae
        this.addQuestion(q17);
        Questions q18=new Questions("He captured Pegasus and rode him as he performed heroic acts","Meleager","Perseus","Theseus","Bellerophon");//cannae
        this.addQuestion(q18);
        Questions q19=new Questions("She stopped to pick up Golden Apples and lost a race, gained a husband","Helen","Merope","Penelope","Atalanta");//cannae
        this.addQuestion(q19);
        Questions q20=new Questions("Cursed by Apollo, no one would believe her prophecies even though they were true","Ariadne","Sibyl","Melaniipe","Cassandra");//cannae
        this.addQuestion(q20);
        Questions q21=new Questions("This lover of Clytemnestra helped her kill her husband Agamemnon", "Darcleitus", "Meriones", "Sthenelus", "Aegisthus");//3
        this.addQuestion(q21);
        Questions q22=new Questions("This son of Theseus went to fight at Troy and rescued his grandmother" , "Haemon", "Menoetes", "Pleisthenes", "Acamas");//AEQUI
        this.addQuestion(q22);
        Questions q23=new Questions("Who killed Cebriones, charioteer of Hector","Achilles", "Ajax Telamon","Odysseus","Patroclus");//Tullus Hostillus
        this.addQuestion(q23);
        Questions q24=new Questions("This deity smacked Artemis, spilling her arrows and dragging her from the field of battle",    "Hera", "Posiedon", "Hermes","Athena");//Julius Proculus
        this.addQuestion(q24);
        // REMEMBER TO UPDATE DATABSE VERSION EACH TIME AFTER CHANGING
        Questions q25=new Questions("This tutor of Achilles goes to him to persuade him to return to battle against the Trojans ","Alcimus","Molossus","Chiron","Phoenix");//cannae
        this.addQuestion(q25);
        Questions q26=new Questions("He wounds Aphrodite and Ares in battle at Troy","Achilles","Odysseus","Menelaus","Diomedes");//Hadrian
        this.addQuestion(q26);
        Questions q27=new Questions("Who was the second person to speak with Odysseus in the Underworld","Agamemnon","Anticlea","Telamom Ajax","Achilles");//Rhea Silvia
        this.addQuestion(q27);
        Questions q28=new Questions("He was a minstrel in the house of Odysseus; his life was spared by the returning warrior ","Bebryces","Demodocus","Hippasus","Phemius");//Milvian Bridge
        this.addQuestion(q28);
        Questions q29=new Questions(" This suitor calls Mentor a madman for saying that the suitors had done wrong to Odysseus?","Antinonus","Hippalcimus","Penelus","Leocritus");//Ancus Marcius
        this.addQuestion(q29);
        Questions q30=new Questions(" This sister of Dido tried comfort the abandoned queen","Hilaria","Oleandra","Thyone","Anna");//cannae
        this.addQuestion(q30);
        Questions q31=new Questions("Wife of Aeneas in Italy","Corlene","Ialpye","Theodice","Lavinia");//cannae
        this.addQuestion(q31);
        Questions q32=new Questions("He traded kingdoms with his cousin Perseus","Aristeas","Eunomus","Siculus","Megapenthes");//cannae
        this.addQuestion(q32);
        Questions q33=new Questions("He was made king of Salamis for killing a dangerous snake","Agamedes","Icarius","Pamphyllus","Cychreus");//cannae
        this.addQuestion(q33);
        Questions q34=new Questions("This former sailor became a follower of Bacchus when he saw the power of the new god","Enyalius","Hippolochus","Phineus","Acoetes");//cannae
        this.addQuestion(q34);
        Questions q35=new Questions("Goddess of the hunt and goddess of the moon","Amphitrite","Aphrodite","Athena","Artemis");//cannae
        this.addQuestion(q35);
        Questions q36=new Questions("She wandered the earth for a time, looking for her kidnapped daughter Persephone","Aphrodite","Hera","Selene","Demeter");//cannae
        this.addQuestion(q36);
        Questions q37=new Questions("One look from her and you would turn to stone; her face adorns the breastplate of Athena","Chimaera","Hydra","Sphinx","Medusa");//cannae
        this.addQuestion(q37);
        Questions q38=new Questions("He was the King of the Winds","Dorus","Nereus","Triton","Aeolus");//cannae
        this.addQuestion(q38);
        Questions q39=new Questions("Ignoring his father’s orders, he flew too close to the sun and it melted the wax on his wings","Aphareus","Learchus","Phaethon","Icarus");//cannae
        this.addQuestion(q39);
        Questions q40=new Questions("Odysseus and his men were trapped in his cave; he was blinded by the clever Greeks","Deipyle","Geryon","Minotaur","Polyphemus");//cannae
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
        dbaseMyth.insert(TABLE_QUEST, null, values);
    }
    public List<Questions> getAllQuestions() {
        List<Questions> quesList = new ArrayList<Questions>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_QUEST +" ORDER BY RANDOM() LIMIT 10";
        dbaseMyth=this.getReadableDatabase();
        Cursor cursor = dbaseMyth.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Questions questMyth = new Questions();
                questMyth.setID(cursor.getInt(0));
                questMyth.setQUESTION(cursor.getString(1));
                questMyth.setANSWER(cursor.getString(2));
                questMyth.setOPTA(cursor.getString(3));
                questMyth.setOPTB(cursor.getString(4));
                questMyth.setOPTC(cursor.getString(5));
                quesList.add(questMyth);
            } while (cursor.moveToNext());
        }
// return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT * FROM " + TABLE_QUEST + " ORDER BY RANDOM() LIMIT 10";
        SQLiteDatabase dbMyth = this.getWritableDatabase();
        Cursor cursor = dbMyth.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}
