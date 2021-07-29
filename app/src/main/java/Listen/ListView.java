package Listen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import  com.example.english.R;
public class ListView extends AppCompatActivity implements View.OnClickListener {
     TextView tr1,tr2,tr3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        tr1=findViewById(R.id.track1);
        tr1.setOnClickListener(this);
        tr2=findViewById(R.id.track2);
        tr2.setOnClickListener(this);
        tr3=findViewById(R.id.track3);
        tr3.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.track1:
                Intent intent =new Intent(ListView.this,Listen_main.class);
                startActivity(intent);
                break;
            case R.id.track2:
                Intent intent1 =new Intent(ListView.this,Listen_main.class);
                startActivity(intent1);
                break;
            case R.id.track3:
                Intent intent2 =new Intent(ListView.this,Listen_main.class);
                startActivity(intent2);
                break;

        }
    }
}