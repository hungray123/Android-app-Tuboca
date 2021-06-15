package Vocabulary;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.english.R;

import java.util.Collections;
import java.util.List;

import DB_VOCABULARY.VocabularyDBHelper;

public class Vocabulary_main extends AppCompatActivity {
    private TextView Next;
    private  TextView Word;
    private  TextView IPA;
    private  TextView Mean;
    private ImageView Image;
    private TextView Vid;
    int currentV=0;

    private List<Vocabulary> ListVocabulary;
    private  Vocabulary mVocabulary;
    int vd = 1;
    public int kd =5;

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
        Next=findViewById(R.id.next);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
        });

        SetNewVocabulary();

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
        currentV=currentV+1;
        Vid.setText(""+currentV);

    }

    private void NextVocabulary() {
        vd++;
        mVocabulary=ListVocabulary.get(vd);
            new Handler().postDelayed(() -> SetNewVocabulary(),1000);
        }
    }


