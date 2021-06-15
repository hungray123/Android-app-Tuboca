package DB;

import android.provider.BaseColumns;

public class QuizContract {
    private  QuizContract(){}


    public  static class QuestionsTable implements BaseColumns{
        public  static  final  String TABLE_NAME="quiz_questions";
        public  static  final  String COLUMN_QUESTION="Question";
        public  static  final  String COLUMN_ANSWER1="Answer1";
        public  static  final  String COLUMN_ANSWER2="answer2";
        public  static  final  String COLUMN_ANSWER_R="Answer_r";
    }

}
