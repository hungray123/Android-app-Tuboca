package DB_VOCABULARY;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.english.R;
import java.util.ArrayList;
import java.util.List;

import Vocabulary.Vocabulary;
import VocabularyFruits.Fruits;

public class VocabularyDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Vocabulary.db";
    private static final int DATABASE_VERSION = 13;
    private SQLiteDatabase db;

    public VocabularyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;

        final String SQL_CREATE_VOCABULARY_TABLE = "CREATE TABLE " +
                VocabularyContact.VocabularyTable.TABLE_NAME + " ( " +
                VocabularyContact.VocabularyTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                VocabularyContact.VocabularyTable.COLUMN_IMAGE + " TEXT, " +
                VocabularyContact.VocabularyTable.COLUMN_WORD + " TEXT, " +
                VocabularyContact.VocabularyTable.COLUMN_MEAN + " TEXT, " +
                VocabularyContact.VocabularyTable.COLUMN_IPA + " TEXT, " +
                VocabularyContact.VocabularyTable.COLUMN_EX + " TEXT, " +
                VocabularyContact.VocabularyTable.COLUMN_EX1 + " TEXT, " +
                VocabularyContact.VocabularyTable.COLUMN_EX2 + " TEXT" +
                ")";

         db.execSQL(SQL_CREATE_VOCABULARY_TABLE);
         fillVocabularyTable();
         //table-sports

        final String SQL_CREATE_VOCABULARY_TABLE_SPORT = "CREATE TABLE " +
                VocabularyContact.VocabularyTableSport.TABLE_NAME + " ( " +
                VocabularyContact.VocabularyTableSport._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                VocabularyContact.VocabularyTableSport.COLUMN_IMAGE + " TEXT, " +
                VocabularyContact.VocabularyTableSport.COLUMN_WORD + " TEXT, " +
                VocabularyContact.VocabularyTableSport.COLUMN_MEAN + " TEXT, " +
                VocabularyContact.VocabularyTableSport.COLUMN_IPA + " TEXT " +
                ")";

        db.execSQL(SQL_CREATE_VOCABULARY_TABLE_SPORT);
        fillVocabularyTableFRUIT();

    }

    private void fillVocabularyTableFRUIT() {
        Fruits word=new Fruits(R.drawable.lychee,"Lychee","/ˈlēCHē/","Vải thiều");
        addVocabularySPORT(word);
        Fruits word1=new Fruits(R.drawable.longan,"Longan","/ˈlôNGɡən/","Quả nhãn");
        addVocabularySPORT(word1);
        Fruits word2=new Fruits(R.drawable.blackberries,"Blackberries","/blakˈberēs /","Dâu đen");
        addVocabularySPORT(word2);
        Fruits word4=new Fruits(R.drawable.melon,"Melon","/ˈmelən/","Dưa gang");
        addVocabularySPORT(word4);
        Fruits word5=new Fruits(R.drawable.peach,"Peach","/pēCH/","Quả đào");
        addVocabularySPORT(word5);
        Fruits word6=new Fruits(R.drawable.grape,"Grapes","/ɡrāp/","Chùm nho");
        addVocabularySPORT(word6);
        Fruits word7=new Fruits(R.drawable.apple,"Apple","/ˈapəl /","Qủa táo");
        addVocabularySPORT(word7);
        Fruits word8=new Fruits(R.drawable.melon,"Orange","/ˈôrənj/","Qủa cam");
        addVocabularySPORT(word8);
        Fruits word9=new Fruits(R.drawable.papaya,"Papaya","/pəˈpīə/","Đu đủ");
        addVocabularySPORT(word9);
        Fruits word10=new Fruits(R.drawable.pineapple,"Pineapple","/ˈpīˌnapəl/","Qủa dứa");
        addVocabularySPORT(word10);
        Fruits word11=new Fruits(R.drawable.pomelo,"Pomelo","/ˈpäməlō/","Qủa bưởi");
        addVocabularySPORT(word11);
        Fruits word12=new Fruits(R.drawable.pear,"Pear","/per/","Qủa lê");
        addVocabularySPORT(word12);
        Fruits word13=new Fruits(R.drawable.watermelon,"Watermelon","/ˈwôdərˌmelən/","Dưa hấu");
        addVocabularySPORT(word13);
        Fruits word14=new Fruits(R.drawable.strawberry,"Strawberry","/ˈstrôˌberē/","Dây tây");
        addVocabularySPORT(word14);
        Fruits word15=new Fruits(R.drawable.guava,"Guava","/ˈɡwävə/","Qủa ổi");
        addVocabularySPORT(word15);
        Fruits word16=new Fruits(R.drawable.kumquat,"Kumquat","/ˈkəmˌkwät/","Qủa quất");
        addVocabularySPORT(word16);
        Fruits word17=new Fruits(R.drawable.jackfruit,"Jack fruit","/ˈjakˌfro͞ot/","Qủa mít");
        addVocabularySPORT(word17);
        Fruits word18=new Fruits(R.drawable.banana,"Banana","/bəˈnanə/","Qủa chuối");
        addVocabularySPORT(word18);
    }

    private void addVocabularySPORT(Fruits fruits) {
        ContentValues cv2=new ContentValues();
        cv2.put(VocabularyContact.VocabularyTableSport.COLUMN_IMAGE, fruits.getImageFruits());
        cv2.put(VocabularyContact.VocabularyTableSport.COLUMN_WORD, fruits.getWord());
        cv2.put(VocabularyContact.VocabularyTableSport.COLUMN_IPA, fruits.getIpa());
        cv2.put(VocabularyContact.VocabularyTableSport.COLUMN_MEAN, fruits.getMean());
        db.insert(VocabularyContact.VocabularyTableSport.TABLE_NAME,null,cv2);
    }

    private void fillVocabularyTable() {
        Vocabulary word =new Vocabulary(R.drawable.dog,"Dog","Con chó","/dôg/",
                "Chó là loài động vật được nuôi nhiều trên thế giới, có thể trông coi nhà ,dẫn đường.."
                ,"I saw my neighbor's dog running in my yard.",
                "There's no dog.");
        addVocabulary(word);
        Vocabulary word1 =new Vocabulary(R.drawable.duck,"Duck","Con vịt","/dək/",
                "Vịt có chiếc mỏ dẹp rất lợi hại trong việc bắt các loài sinh vật nhỏ sống dưới "
                ,"The duck can swim.",
                "Like water off a duck's back.");
        addVocabulary(word1);
        Vocabulary word2 =new Vocabulary(R.drawable.cow,"Cow","Con bò","/kou/",
                "Con bò rất thích ra đồng ăn cỏ.",
                "That cow doesn't look as white as milk to me.",
                "Did you sell the cow?");
        addVocabulary(word2);
        Vocabulary word3 =new Vocabulary(R.drawable.lion,"Lion","Con sư tử","/ˈlīən/",
                "Sư tử ăn thịt.",
                "The lion roared once and sprang.",
                "This Lion King here.");
        addVocabulary(word3);
        Vocabulary word4 =new Vocabulary(R.drawable.cock,"Cock","Con gà trống","/käk/",
                "Gà trống gáy ò ó o.",
                "Cocks are highly aggressive towards other cocks.",
                "Oh, no, on Ladder the people wake up the roosters.");
        addVocabulary(word4);
        Vocabulary word5 =new Vocabulary(R.drawable.buffalo,"Buffalo","Con trâu","/ˈbəf(ə)ˌlō/",
                "Sắp tới lúc đi chăn trâu  rồi.",
                "The great white buffalo",
                "in these sacrificial buffaloes");
        addVocabulary(word5);

        Vocabulary word6 =new Vocabulary(R.drawable.horse,"Horse","Con ngựa","/hôrs/",
                "Atticus, trả ngựa đây.",
                "He walked his horse to the gate.",
                "Con ngựa đã đi đâu?");
        addVocabulary(word6);

        Vocabulary word7 =new Vocabulary(R.drawable.tiger,"Tiger","Con hổ","/ˈtīɡər/",
                "Sundarban là nơi sinh sống của hơn 400 con hổ Bengal.",
                "Tiger's skin is said to cure a fever caused by ghosts.",
                "Siberian tigers have a pattern of dark stripes on orange fur.");
        addVocabulary(word7);

        Vocabulary word8 =new Vocabulary(R.drawable.cat,"Cat","Con mèo","/kat/",
                "Con mèo này có đôi mắt rất đẹp.",
                "That's a cat!",
                "Fewer strokes among cat owners.");
        addVocabulary(word8);

        Vocabulary word9 =new Vocabulary(R.drawable.wolf,"Wolf","Con sói","/wo͝olf/",
                "Người ta nghĩ nó bị chó sói tấn công.",
                "But the wolf that breaks it will die.",
                "A wolf can wear sheep's clothing, but he's still a wolf.");
        addVocabulary(word9);

        Vocabulary word10 =new Vocabulary(R.drawable.monkey,"Monkey","Con khỉ","/ˈməNGkē/",
                "Cậu là một con khỉ thông minh... nhưng cậu vẫn là khỉ.",
                "There's a funny monkey here!",
                "Dumb monkey!");
        addVocabulary(word10);


    }

    private void addVocabulary( Vocabulary vocabulary) {
        ContentValues cv1= new ContentValues();
        cv1.put(VocabularyContact.VocabularyTable.COLUMN_IMAGE,vocabulary.getImage());
        cv1.put(VocabularyContact.VocabularyTable.COLUMN_WORD,vocabulary.getWord());
        cv1.put(VocabularyContact.VocabularyTable.COLUMN_IPA,vocabulary.getIPA());
        cv1.put(VocabularyContact.VocabularyTable.COLUMN_MEAN,vocabulary.getMean());
        cv1.put(VocabularyContact.VocabularyTable.COLUMN_EX,vocabulary.getExample());
        cv1.put(VocabularyContact.VocabularyTable.COLUMN_EX1,vocabulary.getExample1());
        cv1.put(VocabularyContact.VocabularyTable.COLUMN_EX2,vocabulary.getExample2());
        db.insert(VocabularyContact.VocabularyTable.TABLE_NAME,null,cv1);
    }

    public List<Vocabulary> getAllVocabulary(){
        List<Vocabulary> vocabularyList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + VocabularyContact.VocabularyTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
               Vocabulary vocabulary =new Vocabulary();
                vocabulary.setImage(c.getInt(c.getColumnIndex(VocabularyContact.VocabularyTable.COLUMN_IMAGE)));
                vocabulary.setWord(c.getString(c.getColumnIndex(VocabularyContact.VocabularyTable.COLUMN_WORD)));
                vocabulary.setIPA(c.getString(c.getColumnIndex(VocabularyContact.VocabularyTable.COLUMN_IPA)));
                vocabulary.setMean(c.getString(c.getColumnIndex(VocabularyContact.VocabularyTable.COLUMN_MEAN)));
                vocabulary.setExample(c.getString(c.getColumnIndex(VocabularyContact.VocabularyTable.COLUMN_EX)));
                vocabulary.setExample1(c.getString(c.getColumnIndex(VocabularyContact.VocabularyTable.COLUMN_EX1)));
                vocabulary.setExample2(c.getString(c.getColumnIndex(VocabularyContact.VocabularyTable.COLUMN_EX2)));
                vocabularyList.add(vocabulary);

            } while (c.moveToNext());
        }

        c.close();
        return vocabularyList;
    }
    //SPORT
    public List<Fruits> getAllVocabularySPORT(){
        List<Fruits> fruitsList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + VocabularyContact.VocabularyTableSport.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Fruits fruits =new Fruits();
                fruits.setImageFruits(c.getInt(c.getColumnIndex(VocabularyContact.VocabularyTableSport.COLUMN_IMAGE)));
                fruits.setWord(c.getString(c.getColumnIndex(VocabularyContact.VocabularyTableSport.COLUMN_WORD)));
                fruits.setIpa(c.getString(c.getColumnIndex(VocabularyContact.VocabularyTableSport.COLUMN_IPA)));
                fruits.setMean(c.getString(c.getColumnIndex(VocabularyContact.VocabularyTableSport.COLUMN_MEAN)));
                fruitsList.add(fruits);

            } while (c.moveToNext());
        }

        c.close();
        return fruitsList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + VocabularyContact.VocabularyTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + VocabularyContact.VocabularyTableSport.TABLE_NAME);
        onCreate(db);



    }
}
