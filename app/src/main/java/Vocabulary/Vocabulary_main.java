package Vocabulary;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.english.R;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import DB_VOCABULARY.VocabularyDBHelper;

public class Vocabulary_main extends AppCompatActivity {
    LinearLayout bgThemes2;

    private TextView Next;
    private  TextView Word;
    private  TextView IPA;
    private  TextView Mean;
    private ImageView Image;
    private TextView EX;
    private TextView EX1;
    private TextView EX2;

    private  ImageView ICsound;
    private  ImageView ICsound1;
    private  ImageView ICsound2;
    TextToSpeech toSpeech;
    private final Handler handler = new Handler();

    private TextView Vid;
    int currentV=0;

    private List<Vocabulary> ListVocabulary;
    private  Vocabulary mVocabulary;
    int vd = 1;
    public int kd =9;
     int vc= 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary_main);
        VocabularyDBHelper dbHelper = new VocabularyDBHelper(this);
        dbHelper.getReadableDatabase();
        ListVocabulary=dbHelper.getAllVocabulary();
        Collections.shuffle(ListVocabulary);
        mVocabulary=ListVocabulary.get(vd);
        Image=findViewById(R.id.image_vc);
        Vid=findViewById(R.id.Vid);
        Word=findViewById(R.id.word);
        IPA=findViewById(R.id.ipa);
        Mean=findViewById(R.id.mean);
        EX=findViewById(R.id.ex);
        EX1=findViewById(R.id.ex1);
        EX2=findViewById(R.id.ex2);
        Next=findViewById(R.id.next);
        ICsound=findViewById(R.id.id_img);
        ICsound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak(ListVocabulary.get(vd));
            }
            private  void speak(Vocabulary word){
                String text=word.getWord();
                toSpeech.speak(text, TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        ICsound1=findViewById(R.id.id_sound);
        ICsound1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak1(ListVocabulary.get(vd));
            }
            private  void speak1(Vocabulary word1){
                String text1=word1.getExample2();
                toSpeech.speak(text1, TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        ICsound2=findViewById(R.id.id_sound1);
        ICsound2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak1(ListVocabulary.get(vd));
            }
            private  void speak1(Vocabulary word2){
                String text2=word2.getExample1();
                toSpeech.speak(text2, TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        Speech();

        Next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //vc la bien để cho cái speech đọc cái từ tiếp theo
                vc =vd+1;
                speak(ListVocabulary.get(vc));
                setbackground();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (vd !=kd){
                            NextVocabulary();

                        }else{
                           FinalResult();
                        }

                    }
                },1000);



            }

            private void setbackground() {
                Next.setBackgroundResource(R.drawable.bg_home_32);
            }

            private  void speak(Vocabulary word){
              handler.postDelayed(new Runnable() {
                  @Override
                  public void run() {
                      if (vc!=(kd+1)){
                          String text=word.getWord();
                          toSpeech.speak(text, TextToSpeech.QUEUE_FLUSH,null);
                      }else{
                          String text="Thank you";
                          toSpeech.speak(text, TextToSpeech.QUEUE_FLUSH,null);
                      }

                  }
              },2500);


            }
        });

        SetNewVocabulary();
        SharedPreferences receiverPrefs=getSharedPreferences("MY_PREFS",MODE_PRIVATE);
        LinearLayout themes21=findViewById(R.id.theme2);
        boolean a =receiverPrefs.getBoolean("dark_status",false);
        themes21.setBackgroundResource(R.drawable.bg_white);
        if (a){
            themes21.setBackgroundResource(R.drawable.bg_dark);
        }else{
            themes21.setBackgroundResource(R.drawable.bg_white);
        }


    }

    private void FinalResult() {
        Intent intent=new Intent(Vocabulary_main.this,VResult.class);
                            startActivity(intent);
    }

    private void SetNewVocabulary() {


        Image.setImageResource(mVocabulary.getImage());
        Word.setText(mVocabulary.getWord());
        IPA.setText(mVocabulary.getIPA());
        Mean.setText(mVocabulary.getMean());
        EX.setText(mVocabulary.getExample());
        EX1.setText(mVocabulary.getExample1());
        EX2.setText(mVocabulary.getExample2());
        currentV=currentV+1;
        Vid.setText(""+currentV);

    }

     private void NextVocabulary() {
         Next.setBackgroundResource(R.drawable.bg_next);
        vd++;
        mVocabulary=ListVocabulary.get(vd);
            new Handler().postDelayed(() -> SetNewVocabulary(),1000);
        }


    private void Speech() {
        toSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = toSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });


    }
    }



