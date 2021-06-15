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

public class VocabularyDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Vocabulary.db";
    private static final int DATABASE_VERSION = 4;
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
                VocabularyContact.VocabularyTable.COLUMN_IPA + " TEXT, " +
                VocabularyContact.VocabularyTable.COLUMN_MEAN + " TEXT " +
                ")";

         db.execSQL(SQL_CREATE_VOCABULARY_TABLE);
         fillVocabularyTable();
    }

    private void fillVocabularyTable() {
        Vocabulary word =new Vocabulary(R.drawable.dogs,"Dog","Con chó","/dôg/");
        addVocabulary(word);
        Vocabulary word1 =new Vocabulary(R.drawable.duck,"Duck","Con vịt","/dək/");
        addVocabulary(word1);
        Vocabulary word2 =new Vocabulary(R.drawable.cow,"Cow","Con bò","/kou/");
        addVocabulary(word2);
        Vocabulary word3 =new Vocabulary(R.drawable.lion,"Lion","con sư tử","/ˈlīən/");
        addVocabulary(word3);
        Vocabulary word4 =new Vocabulary(R.drawable.chicken,"Chicken","Con gà","/ˈCHikən/");
        addVocabulary(word4);
        Vocabulary word5 =new Vocabulary(R.drawable.buffalo,"Buffalo","Con Trâu","/ˈbəf(ə)ˌlō/");
        addVocabulary(word5);

    }

    private void addVocabulary( Vocabulary vocabulary) {
        ContentValues cv1= new ContentValues();
        cv1.put(VocabularyContact.VocabularyTable.COLUMN_IMAGE,vocabulary.getImage());
        cv1.put(VocabularyContact.VocabularyTable.COLUMN_WORD,vocabulary.getWord());
        cv1.put(VocabularyContact.VocabularyTable.COLUMN_IPA,vocabulary.getIPA());
        cv1.put(VocabularyContact.VocabularyTable.COLUMN_MEAN,vocabulary.getMean());
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
                vocabularyList.add(vocabulary);

            } while (c.moveToNext());
        }

        c.close();
        return vocabularyList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + VocabularyContact.VocabularyTable.TABLE_NAME);
        onCreate(db);

    }
}
