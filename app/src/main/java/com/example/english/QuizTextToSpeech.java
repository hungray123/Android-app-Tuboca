package com.example.english;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import DB.QuizDbHelper;

public class QuizTextToSpeech extends AppCompatActivity {

    private TextView tvQuestion;
    public TextView tvContentQuestion;
    private TextView tvAnswer1,tvAnswer2;
    private TextView npoint;
    private ImageView speech;
    private TextToSpeech mTTS;
    private String text;

    private List<Question> questionList;
    private Question currentQuestion;

    int qid = 1;
    public int sizeofQuiz =4;
    private ProgressBar pBar;
    int mpoint=0;

    private final Handler handler = new Handler();
    private final Handler handler2 = new Handler();
    AnimationDrawable anim;
    Animation wrongAnimation;

    int correct=0;
    int FLAG=-1; //for unsuccessful
    PlayAudio playAudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_text_to_speech);
        QuizDbHelper dbHelper = new QuizDbHelper(this);
        dbHelper.getReadableDatabase();
        questionList=dbHelper.getAllQuestions_1();
        Collections.shuffle(questionList);
        currentQuestion=questionList.get(qid);

        pBar=findViewById(R.id.progressBar);
        tvQuestion = findViewById(R.id.tv_quesion);
        tvContentQuestion = findViewById(R.id.tv_content_quesiton);
        tvAnswer1 = findViewById(R.id.tvAnswer1);
        tvAnswer2 = findViewById(R.id.tvAnswer2);

        npoint=findViewById(R.id.point);

        updateQuestion();

        wrongAnimation= AnimationUtils.loadAnimation(this,R.anim.wrong_animation);
        wrongAnimation.setRepeatCount(3);
        playAudio=new PlayAudio(this);
        tvAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvAnswer1.setBackgroundResource(R.drawable.bg_orange_20);
                bt_Answer1();
            }
        });

        tvAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvAnswer2.setBackgroundResource(R.drawable.bg_orange_20);
                bt_Answer2();
            }
        });
        //Text To Speech
        Speech();

//        tvAnswer1.setBackgroundResource(R.drawable.bg_answer_20);
//        tvAnswer2.setBackgroundResource(R.drawable.bg_answer_20);

    }

    private void Speech() {
        mTTS=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status==TextToSpeech.SUCCESS){
                    int Result=mTTS.setLanguage(Locale.ENGLISH);
                    if (Result==TextToSpeech.LANG_MISSING_DATA||Result==TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("TTS","Language not Supported");
                    }else{
                        speech.setEnabled(true);
                    }
                }else {
                    Log.e("TTS","Failed");
                }
            }
        });
        speech=findViewById(R.id.id_img);
        speech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak(questionList.get(qid));
            }

            private void speak(Question a) {
                text=a.getQuestion();
                mTTS.speak(text,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }

    private void updateQuestion() {

        tvAnswer1.setBackgroundResource(R.drawable.bg_answer_20);
        tvAnswer2.setBackgroundResource(R.drawable.bg_answer_20);

        tvQuestion.setText( qid+"/"+sizeofQuiz);
//        tvContentQuestion.setText(currentQuestion.getQuestion());
        tvAnswer1.setText(currentQuestion.getAnswer1());
        tvAnswer2.setText(currentQuestion.getAnswer2());
        npoint.setText(""+mpoint);
         if (qid==1){
             mpoint=0;
         }
        mpoint=mpoint+10;
        int plus=0;
        int current=pBar.getProgress();
          if (current==pBar.getProgress()){
              plus =100/sizeofQuiz;

          }
        pBar.setProgress(current+plus);

    }

    private void SetNewQuestion() {

        qid++;
        currentQuestion = questionList.get(qid);
        updateQuestion();
        enableAnswer();


    }


    public void bt_Answer2() {

        disableAnswer();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentQuestion.getAnswer2().equals(currentQuestion.getAnswerR())) {
                    correct++;
//                    tvAnswer2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.green));
                    tvAnswer2.setBackgroundResource(R.drawable.flash_bg);
//                    tvAnswer1.setBackgroundResource(R.drawable.bg_red_20);
                    anim=(AnimationDrawable) tvAnswer2.getBackground();
                    anim.start();
                    FLAG=1;
                    playAudio.setAudioForEvent(FLAG);

                    Log.i("QuizInfo", "Correct");

                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (qid != sizeofQuiz) {

                                SetNewQuestion();
                            } else {
                                FinalResult();
                            }
                        }
                    }, 1500);
                } else {
                    tvAnswer2.setBackgroundResource(R.drawable.bg_red_20);
                    mpoint=0;
                    tvAnswer2.startAnimation(wrongAnimation);
                    FLAG=2;
                    playAudio.setAudioForEvent(FLAG);


                    Handler handler3 = new Handler();
                    handler3.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (currentQuestion.getAnswer1().equals(currentQuestion.getAnswerR())) {
                                tvAnswer1.setBackgroundResource(R.drawable.bg_green_20);
                            }
                        }
                    }, 1000);

                    Handler handler4=new Handler();
                    handler4.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (qid != sizeofQuiz) {
                                SetNewQuestion();
                            }else{
                                FinalResult();
                            }
                        }
                    }, 3000);


                }
            }
        }, 3000);

    }

    public void bt_Answer1() {
        disableAnswer();
//        tvAnswer1.setBackgroundResource(R.drawable.flash_bg);
//        anim=(AnimationDrawable) tvAnswer1.getBackground();
//        anim.start();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentQuestion.getAnswer1().equals(currentQuestion.getAnswerR())) {
                    correct++;
//                    tvAnswer1.setBackgroundColor(R.drawable.bg_answer_20);
                    tvAnswer1.setBackgroundResource(R.drawable.flash_bg);
                    anim=(AnimationDrawable) tvAnswer1.getBackground();
                    anim.start();
                    FLAG=1;
                    playAudio.setAudioForEvent(FLAG);
                    Log.i("QuizInfo", "Correct");

                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (qid != sizeofQuiz) {

                                SetNewQuestion();
                            } else {
                                FinalResult();
                            }
                        }
                    }, 1500);
                } else {
                    tvAnswer1.setBackgroundResource(R.drawable.bg_red_20);

                    mpoint=0;
                    tvAnswer1.startAnimation(wrongAnimation);
                    FLAG=2;
                    playAudio.setAudioForEvent(FLAG);


                    Handler handler3 = new Handler();
                    handler3.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (currentQuestion.getAnswer2().equals(currentQuestion.getAnswerR())) {
                                tvAnswer2.setBackgroundResource(R.drawable.bg_green_20);
                            }
                        }
                    }, 1000);

                    Handler handler4=new Handler();
                    handler4.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if (qid != sizeofQuiz) {
                                SetNewQuestion();
                            }else{
                                FinalResult();
                            }
                        }
                    }, 3000);


                }
            }
        }, 3000);
    }
    private void  disableAnswer(){
        tvAnswer1.setEnabled(false);
        tvAnswer2.setEnabled(false);
    }
    private void enableAnswer(){
        tvAnswer1.setEnabled(true);
        tvAnswer2.setEnabled(true);
    }

    private void  FinalResult(){
        Intent resultIntent= new Intent(QuizTextToSpeech.this,Result.class);
        resultIntent.putExtra("TOTAL_QUESTION_R",correct);
        resultIntent.putExtra("TOTAL_QUESTION",sizeofQuiz);
        resultIntent.putExtra("COINS",mpoint);
        startActivity(resultIntent);

    }


}