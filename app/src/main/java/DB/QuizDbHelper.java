package DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.english.Question;

import java.util.ArrayList;
import java.util.List;

import DB.QuizContract.QuestionsTable;


public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Quiz.db";
    private static final int DATABASE_VERSION = 6;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER1 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER2 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_R + " TEXT" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        Question q1 = new Question("lOVE", "lOVE", "YOU", "lOVE");
        addQuestion(q1);
        Question q2 = new Question("BEAUTIFUL", "TIRED", "BEAUTIFUL","BEAUTIFUL");
        addQuestion(q2);
        Question q3 = new Question("CREAM", "CREAM", "CROSS", "CREAM");
        addQuestion(q3);
        Question q4 = new Question("FLOWER", "FIRE", "FLOWER" ,"FLOWER");
        addQuestion(q4);
        Question q5 = new Question("CHILD", "CHILD", "CHILDREN", "CHILD");
        addQuestion(q5);
        Question q6 = new Question("FAMILY", "MILI", "FAMILY", "FAMILY");
        addQuestion(q6);
        Question q7 = new Question("FRESHER", "FRESS", "FRESHER", "FRESHER");
        addQuestion(q7);
        Question q8 = new Question("BODY", "BOSS", "BODY", "BODY");
        addQuestion(q8);
        Question q9 = new Question("GIRL", "GIL", "GIRL", "GIRL");
        addQuestion(q9);
        Question q10 = new Question("KEEP", "KEEP", "BROAD", "KEEP");
        addQuestion(q10);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_ANSWER1, question.getAnswer1());
        cv.put(QuestionsTable.COLUMN_ANSWER2, question.getAnswer2());
        cv.put(QuestionsTable.COLUMN_ANSWER_R, question.getAnswerR());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setAnswer1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER1)));
                question.setAnswer2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER2)));
                question.setAnswerR(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_R)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}