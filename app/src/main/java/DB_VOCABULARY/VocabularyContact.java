package DB_VOCABULARY;

import android.provider.BaseColumns;

public class VocabularyContact {
    private   VocabularyContact(){};
    public  static class VocabularyTable implements BaseColumns {
        public  static  final  String TABLE_NAME="Vocabulary";
        public  static  final  String COLUMN_IMAGE="image";
        public  static  final  String COLUMN_WORD="word";
        public  static  final  String COLUMN_MEAN="MEAN";
        public  static  final  String COLUMN_IPA="ipa";
        public  static  final  String COLUMN_EX="example";
        public  static  final  String COLUMN_EX1="example1";
        public  static  final  String COLUMN_EX2="example2";
    }
    public  static class VocabularyTableSport implements BaseColumns {
        public  static  final  String TABLE_NAME="Sports";
        public  static  final  String COLUMN_IMAGE="image";
        public  static  final  String COLUMN_WORD="word";
        public  static  final  String COLUMN_MEAN="MEAN";
        public  static  final  String COLUMN_IPA="ipa";

    }
}
