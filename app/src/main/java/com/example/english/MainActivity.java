package com.example.english;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import QuizList.QuizListView;
import TopicVocabulary.GridTopic;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{


    private TextView quizTest;
    private TextView vocabulary;
    private TextView listening;
    private TextView Video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initUi();
//        mListQuesion=getListQuesion();
//        if(mListQuesion.isEmpty()) return;
//        //tham so truyen vao la 1 quesion va index quesion
//        setDataQuesion(mListQuesion.get(currentQuesion));
//        npoint=findViewById(R.id.point);
//        npoint.setText("Point:"+mpoint);
//        //Media

          quizTest = findViewById(R.id.quiztest);
          quizTest.setOnClickListener(this);
        vocabulary=findViewById(R.id.vocabulary);
        vocabulary.setOnClickListener(this);
//        listening=findViewById(R.id.listening);
//        listening.setOnClickListener(this);
//        Video=findViewById(R.id.video);
//        Video.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
         case R.id.quiztest:
                Intent intent =new Intent(MainActivity.this, QuizListView.class);
                startActivity(intent);
                Toast.makeText(this,"quiztest",Toast.LENGTH_SHORT).show();
                break;
            case R.id.vocabulary:
                Toast.makeText(this,"vocabulary",Toast.LENGTH_SHORT).show();
                Intent intent1 =new Intent(MainActivity.this , GridTopic.class);
                startActivity(intent1);
                break;
            case R.id.listening:
                Toast.makeText(this,"listening",Toast.LENGTH_SHORT).show();
                break;
            case R.id.video:
                Toast.makeText(this,"video",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}




//    @Override
//    protected void onDestroy() {
//        if (mTTS !=null){
//            mTTS.stop();
//        }
//        super.onDestroy();
//    }
//    private  void  initUi(){
////        r=new Random();
//        tvQuesion=findViewById(R.id.tv_quesion);
//        tvContentQuesion=findViewById(R.id.tv_content_quesiton);
//        tvAnser1=findViewById(R.id.tv_ans1);
//        tvAnser2=findViewById(R.id.tv_ans2);
////        tvAnser3=findViewById(R.id.tv_ans3);
////        tvAnser4=findViewById(R.id.tv_ans4);
//
//
//        //speach
//
//
//        mTTS= new TextToSpeech(this, new TextToSpeech.OnInitListener() {
//            @Override
//            public void onInit(int status) {
//                if (status==TextToSpeech.SUCCESS){
//                    int Result= mTTS.setLanguage(Locale.ENGLISH);
//
//                    if (Result==TextToSpeech.LANG_MISSING_DATA||Result==TextToSpeech.LANG_NOT_SUPPORTED){
//                        Log.e("TTS","Language not Supported");
//                    }else{
//                        speach.setEnabled(true);
//                    }
//                }else {
//                    Log.e("TTS","Failed");
//                }
//            }
//        });
//
//        speach=findViewById(R.id.id_img);
//        speach.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                speak(mListQuesion.get(currentQuesion));
//            }
//
//            private void speak(Quesion a) {
//
//                text =a.getContent();
//                mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
//            }
//        });
//    }
//    private void setDataQuesion(Quesion quesion) {
//        if (quesion==null) return;
//        mQuesion= quesion;
//        String titleQuesion="Quesion "+quesion.getNumber();
//        tvQuesion.setText(titleQuesion);//cau hoi so bao nhieu
////        tvContentQuesion.setText(quesion.getContent());// content quesion
//        //reset background
//        tvAnser1.setBackgroundResource(R.drawable.bg_blue_dark_10);
//        tvAnser2.setBackgroundResource(R.drawable.bg_blue_dark_10);
////        tvAnser3.setBackgroundResource(R.drawable.bg_blue_corner_10);
////        tvAnser4.setBackgroundResource(R.drawable.bg_blue_corner_10);
//
//        tvAnser1.setText(quesion.getListAnser().get(0).getContent());
//        tvAnser2.setText(quesion.getListAnser().get(1).getContent());
////        tvAnser3.setText(quesion.getListAnser().get(2).getContent());
////        tvAnser4.setText(quesion.getListAnser().get(3).getContent());
//
//        tvAnser1.setOnClickListener(this);
//        tvAnser2.setOnClickListener(this);
////        tvAnser3.setOnClickListener(this);
////        tvAnser4.setOnClickListener(this);
//
//    }
//
//
//    private List<Quesion> getListQuesion(){
//        List<Quesion> list=new ArrayList<>();
//
//        List<Anwser> listAnser1=new ArrayList<>();
//        listAnser1.add(new Anwser("Love",true));
//        listAnser1.add(new Anwser("Lave",false));
////        listAnser1.add(new Anser("Mail",true));
////        listAnser1.add(new Anser("Maaa",false));
//        list.add(new Quesion("Love !", 1,listAnser1));
//
//
//        List<Anwser> listAnser2=new ArrayList<>();
//        listAnser2.add(new Anwser("Buy",true));
//        listAnser2.add(new Anwser("Bee",false));
////        listAnser2.add(new Anser("Bye",false));
////        listAnser2.add(new Anser("By",false));
//        list.add(new Quesion("Buy",2,listAnser2));
//
//
//        List<Anwser> listAnser3=new ArrayList<>();
////        listAnser3.add(new Anser("Fail",false));
////        listAnser3.add(new Anser("Flour",false));
//        listAnser3.add(new Anwser("Ferry",false));
//        listAnser3.add(new Anwser("Fairy",true));
//        list.add(new Quesion("Fairy",3,listAnser3));
//
//        List<Anwser> listAnser4=new ArrayList<>();
//        listAnser4.add(new Anwser("Hear",true));
//        listAnser4.add(new Anwser("Here",false));
////        listAnser4.add(new Anser("Horr",true));
////        listAnser4.add(new Anser("Head",false));
//        list.add(new Quesion("Hear",4,listAnser4));
//        return  list;
//    }
//
//
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.tv_ans1:
//                tvAnser1.setBackgroundResource(R.drawable.bg_orange_10);
//                CheckAnwser(tvAnser1,mQuesion,mQuesion.getListAnser().get(0));
//                break;
//
//            case R.id.tv_ans2:
//                tvAnser2.setBackgroundResource(R.drawable.bg_orange_10);
//                CheckAnwser(tvAnser2,mQuesion,mQuesion.getListAnser().get(1));
//                break;
//
//        }
//    }
//    private  void CheckAnwser(final TextView textView,Quesion quesion,final Anwser anwser){
//        final  MediaPlayer correct=MediaPlayer.create(this,R.raw.correct);
//        final  MediaPlayer error=MediaPlayer.create(this,R.raw.error);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if(anwser.isCorrect()){
//                    correct.start();
//                    textView.setBackgroundResource(R.drawable.bg_green_10);
//                    nexQuesion();
//                }else{
//                    error.start();
//                    textView.setBackgroundResource(R.drawable.bg_red_10);
//                    showAnserCorrect(quesion);
//                    gameOver();
//                }
//            }
//        },1000);
//
//    }
//
//    private void gameOver() {
//        AlertDialog.Builder builder=new AlertDialog.Builder(this);
//        builder.setMessage("Game Over! Your Point is: "+mpoint+" point");
//        builder.setCancelable(false);
//
//        builder.setPositiveButton(" NewGame", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                currentQuesion=0;//quay ve cau 1
//                mpoint=0;
//                setDataQuesion(mListQuesion.get(currentQuesion));//quay ve cau 1
//                npoint.setText("Point: "+mpoint);
//                dialog.dismiss();
//            }
//        });
//        AlertDialog alertDialog=builder.create();
//        alertDialog.show();
//    }
//
//
//
//    private void showAnserCorrect( Quesion quesion) {
//        if (quesion==null||quesion.getListAnser()==null||quesion.getListAnser().isEmpty()) return;
//
//        if (quesion.getListAnser().get(0).isCorrect()){
//            tvAnser1.setBackgroundResource(R.drawable.bg_green_10);
//
//        }else if (quesion.getListAnser().get(1).isCorrect()) {
//            tvAnser2.setBackgroundResource(R.drawable.bg_green_10);
//        }
////        }else  if (quesion.getListAnser().get(2).isCorrect()){
////            tvAnser3.setBackgroundResource(R.drawable.bg_green_corner_10);
////        }else  if (quesion.getListAnser().get(3).isCorrect()){
////            tvAnser4.setBackgroundResource(R.drawable.bg_green_corner_10);
////        }
//    }
//
//    private void nexQuesion() {
//
//
//        if (currentQuesion==mListQuesion.size()-1){
//            showDialog();
//        }else {
//            currentQuesion++;
//            mpoint=mpoint+100;
//
//
//
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//
//                    setDataQuesion(mListQuesion.get(currentQuesion));//chuyen sang cau hoi khac
//                    npoint.setText("Point:"+mpoint);
//
//                }
//            },1000);
//
//        }
////        updateQuesions(r.nextInt(mQuesionLength));
//    }
//
//    private void showDialog(){
//        AlertDialog.Builder builder=new AlertDialog.Builder(this);
//        builder.setMessage("You Winnn! Your Point is: "+mpoint+" point");
//        builder.setCancelable(false);
//
//        builder.setPositiveButton(" NewGame", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                currentQuesion=0;//quay ve cau 1
//                mpoint=0;
//                setDataQuesion(mListQuesion.get(currentQuesion));//quay ve cau 1
//                npoint.setText("Point: "+mpoint);
//                dialog.dismiss();
//            }
//        });
//        AlertDialog alertDialog=builder.create();
//        alertDialog.show();
//    }
//}