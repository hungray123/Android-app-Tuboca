package QuizList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.english.MainActivity;
import com.example.english.QuizTextToSpeech;
import com.example.english.R;

import java.util.ArrayList;

public class QuizListView extends AppCompatActivity {

    GridView grid;
    ArrayList<QuizListInfo> arrayList;
    CustomArrayAdapter customArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list_view);
        TextView backHome=findViewById(R.id.tvBack);
        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentResult = new Intent(QuizListView.this, MainActivity.class);
                startActivity(intentResult);
            }
        });

//           Intent intent1 = getIntent();
//           =intent1.getIntExtra("QuestionRight",0);



        grid =findViewById(R.id.datagrid);
        arrayList=new ArrayList<>();
        arrayList.add(new QuizListInfo("Quiz Lever 1","123",R.drawable.duck));
        arrayList.add(new QuizListInfo("Quiz Lever 2","456",R.drawable.ic_launcher_foreground));
        arrayList.add(new QuizListInfo("Quiz Lever 3","123",R.drawable.buffalo));
        arrayList.add(new QuizListInfo("Quiz Lever 4","123",R.drawable.lion));
        arrayList.add(new QuizListInfo("Quiz Lever 5","123",R.drawable.dog));
        arrayList.add(new QuizListInfo("Quiz Lever 6","123",R.drawable.horse));
        customArrayAdapter =new CustomArrayAdapter(QuizListView.this ,R.layout.quiz_listitem,arrayList);
        grid.setAdapter(customArrayAdapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(QuizListView.this,"you clicked on: " +  position + " id: " + id, Toast.LENGTH_SHORT).show();
                if (position==0){
                 Intent intent = new Intent(QuizListView.this, QuizTextToSpeech.class);
                 startActivity(intent);
             }
             else if(position==1){
                    Intent intent1 = new Intent(QuizListView.this, Quizlv2.class);
                    startActivity(intent1);

             }else{
                finish();
             }
            }
        });
//        grid.setOnItemClickListener((parent, view, position, id) -> {
//            //Length_short=2s display or Length_long=3s display
//            // .arrayList.get(position).toString is content display
//            //Toast.makeText(MainActivity.this,arrayList.get(position).toString(),Toast.LENGTH_SHORT).show();
//
//            Intent intent = new Intent(QuizListView.this, QuizTextToSpeech.class);
//            startActivity(intent);
//        });

    }


}