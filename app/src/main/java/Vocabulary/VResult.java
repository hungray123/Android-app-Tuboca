package Vocabulary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.english.R;

import TopicVocabulary.GridTopic;

public class VResult extends AppCompatActivity {
    TextView bt_Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vresult);
        bt_Next=findViewById(R.id.btV_next);
        bt_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VResult.this, GridTopic.class);
                startActivity(intent);
            }
        });

    }
}