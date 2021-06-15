package QuizList;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.english.QuizTextToSpeech;
import com.example.english.R;

import java.util.ArrayList;

public class QuizListView extends AppCompatActivity {

    ListView listView;
    ArrayList<QuizListInfo> arrayList;
    CustomArrayAdapter customArrayAdapter;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list_view);

//           Intent intents=getIntent();
//            a=intents.getIntExtra("QuestionRight",0);
//            int b=a;


        listView =findViewById(R.id.listview);
        arrayList=new ArrayList<>();
        arrayList.add(new QuizListInfo("Quiz Lever 1","123",R.drawable.ic_launcher_foreground));
        arrayList.add(new QuizListInfo("Quiz Lever 2","456",R.drawable.ic_launcher_foreground));
        customArrayAdapter =new CustomArrayAdapter(QuizListView.this ,R.layout.quiz_listitem,arrayList);
        listView.setAdapter(customArrayAdapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            //Length_short=2s display or Length_long=3s display
            // .arrayList.get(position).toString is content display
            //Toast.makeText(MainActivity.this,arrayList.get(position).toString(),Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QuizListView.this, QuizTextToSpeech.class);
            startActivity(intent);
        });

    }


}