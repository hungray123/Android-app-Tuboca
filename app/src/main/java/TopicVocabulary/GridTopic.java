package TopicVocabulary;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.english.MainActivity;
import com.example.english.R;

import java.util.ArrayList;

import Vocabulary.Vocabulary_main;
import VocabularyFruits.Vocabulary_fruits;


public class GridTopic extends AppCompatActivity {

    GridView gv;
    ArrayList<V_Topic> arrayListTopic;
    V_Adapter vAdapter;

    Switch aSwitch;
    LinearLayout bgThemes;
    LinearLayout bgThemes2;
    private static  String SWITCH_STATUS="switch_status";
    private   static  String DARK_STATUS="dark_status";
    boolean switch_status;
    boolean dark_status;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_topic);
       final TextView tvBack1=(TextView) findViewById(R.id.tvBack);
       final TextView txtTopic2=(TextView) findViewById(R.id.txtTopic);
       final TextView  txtTitle3=(TextView) findViewById(R.id.txtTitle);
        gv=(GridView)findViewById(R.id.gridTopic);
        aSwitch=(Switch) findViewById(R.id.mySwitch);
        bgThemes=findViewById(R.id.bg_themes);
        bgThemes2=(LinearLayout)findViewById(R.id.theme2);

        preferences=getSharedPreferences("MY_PREFS",MODE_PRIVATE);
        editor=getSharedPreferences("MY_PREFS",MODE_PRIVATE).edit();
        switch_status=preferences.getBoolean(SWITCH_STATUS,false);
        dark_status=preferences.getBoolean(DARK_STATUS,false);
        aSwitch.setChecked(switch_status);
        if (dark_status){
            gv.setBackgroundResource(R.drawable.bg_dark);
            bgThemes.setBackgroundResource(R.drawable.bg_dark);
//            bgThemes2.setBackgroundResource(R.drawable.bg_dark);
            tvBack1.setTextColor(getResources().getColor(android.R.color.white));
            txtTitle3.setTextColor(getResources().getColor(android.R.color.white));
            txtTopic2.setTextColor(getResources().getColor(android.R.color.white));
        }else{
            gv.setBackgroundResource(R.drawable.bg_white);
            bgThemes.setBackgroundResource(R.drawable.bg_white);
            //                   bgThemes2.setBackgroundResource(R.drawable.bg_dark);
            tvBack1.setTextColor(getResources().getColor(android.R.color.darker_gray));
            txtTitle3.setTextColor(getResources().getColor(android.R.color.darker_gray));
            txtTopic2.setTextColor(getResources().getColor(android.R.color.darker_gray));
        }





        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    gv.setBackgroundResource(R.drawable.bg_dark);
                    bgThemes.setBackgroundResource(R.drawable.bg_dark);
//                    bgThemes2.setBackgroundResource(R.drawable.bg_dark);
                    tvBack1.setTextColor(getResources().getColor(android.R.color.white));
                    txtTitle3.setTextColor(getResources().getColor(android.R.color.white));
                    txtTopic2.setTextColor(getResources().getColor(android.R.color.white));

                    editor.putBoolean(SWITCH_STATUS,true);
                    editor.putBoolean(DARK_STATUS,true);
                    editor.apply();
                    aSwitch.setChecked(true);
                } else {
                    gv.setBackgroundResource(R.drawable.bg_white);
                    bgThemes.setBackgroundResource(R.drawable.bg_white);
                    //                   bgThemes2.setBackgroundResource(R.drawable.bg_dark);
                    tvBack1.setTextColor(getResources().getColor(android.R.color.darker_gray));
                    txtTitle3.setTextColor(getResources().getColor(android.R.color.darker_gray));
                    txtTopic2.setTextColor(getResources().getColor(android.R.color.darker_gray));

                    editor.putBoolean(SWITCH_STATUS,false);
                    editor.putBoolean(DARK_STATUS,false);
                    editor.apply();
                    aSwitch.setChecked(false);



                }

            }
        });


        arrayListTopic=new ArrayList<V_Topic>();
        arrayListTopic.add(new V_Topic(R.drawable.animals,"Animals"));
        arrayListTopic.add(new V_Topic(R.drawable.family,"Family"));
        arrayListTopic.add(new V_Topic(R.drawable.sports,"Sports"));
        arrayListTopic.add(new V_Topic(R.drawable.fruits,"Fruits"));
        arrayListTopic.add(new V_Topic(R.drawable.cook,"Cook"));
        arrayListTopic.add(new V_Topic(R.drawable.flower,"Flowers"));
        arrayListTopic.add(new V_Topic(R.drawable.clothes,"Clothes"));
        arrayListTopic.add(new V_Topic(R.drawable.devices,"Devices"));
        arrayListTopic.add(new V_Topic(R.drawable.colors,"Colors"));
        arrayListTopic.add(new V_Topic(R.drawable.other,"Others"));
        vAdapter=new V_Adapter(GridTopic.this,R.layout.v_topic,arrayListTopic);
        gv.setAdapter(vAdapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==0){
                    Toast.makeText(GridTopic.this,"you clicked on: "
                            +  position + " id: " + id, Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(GridTopic.this, Vocabulary_main.class);
                    startActivity(intent);
                }
                if (position == 3) {

                    Toast.makeText(GridTopic.this,"you clicked on: "
                            +  position + " id: " + id, Toast.LENGTH_SHORT).show();
                    Intent intent1 =new Intent(GridTopic.this, Vocabulary_fruits.class);
                    startActivity(intent1);
                }
            }
        });
        tvBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(GridTopic.this, MainActivity.class);
                startActivity(intent);
//                GridTopic.super.onBackPressed();
            }
        });
    }


}