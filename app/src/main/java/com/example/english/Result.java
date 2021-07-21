package com.example.english;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import QuizList.QuizListView;

public class Result extends AppCompatActivity {
    Button btPlayAgain,btNext;
    TextView TotalQuestionR,totalPoint;
    SharedPreferences myPref;
    SharedPreferences.Editor myEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TotalQuestionR=findViewById(R.id.TotalQuestionR);
        totalPoint=findViewById(R.id.totalPoint);
        btPlayAgain=findViewById(R.id.btPlayAgain);
        btNext=findViewById(R.id.btNext);
        Intent intent =getIntent();
        int totalQuestion =intent.getIntExtra("TOTAL_QUESTION",0);
        int totalQuestionR=intent.getIntExtra("TOTAL_QUESTION_R",0);
        int total_point =intent.getIntExtra("COINS",0);
        TotalQuestionR.setText(totalQuestionR+"/"+totalQuestion);
        totalPoint.setText(String.valueOf(total_point));
        myPref=getSharedPreferences("shareCorrect",MODE_PRIVATE);
        myEditor=getSharedPreferences("shareCorrect",MODE_PRIVATE).edit();


        btPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Result.this,QuizTextToSpeech.class);
                startActivity(intent);

            }
        });
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a= String.valueOf(totalQuestion);
                String b=String.valueOf(totalQuestionR);
                myEditor.putString("totalQuestion",a);
                myEditor.putString("totalQuestionR",b);
                myEditor.commit();
                Intent intent =new Intent(Result.this, QuizListView.class);
//                intent.putExtra("QuestionRight",totalQuestionR);
                startActivity(intent);
            }
        });
    }


}