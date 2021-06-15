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
    }
}
