package VocabularyFruits;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.english.MainActivity;
import com.example.english.R;

import java.util.List;
import java.util.Locale;

import DB_VOCABULARY.VocabularyDBHelper;


public class Vocabulary_fruits extends AppCompatActivity  implements View.OnClickListener {

    ViewPager2 vpHorizontal;
    ImageView icBack;
    ImageView backHome;
    ImageView sound1234;
    TextToSpeech toSpeech;


    VocabularyDBHelper dbFruit;
    private List<Fruits> fruitsList;

    //   int[] images = {R.drawable.dog,R.drawable.dog,R.drawable.cat,R.drawable.apple};
    AdapterFruits adapterFruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary_fruits);

        final LayoutInflater inflater = getLayoutInflater();
        final View myView = inflater.inflate(R.layout.item_fruits, null);
        final ImageView  icSound = (ImageView) myView.findViewById(R.id.icSoundFruit123);
        sound1234= (ImageView) findViewById(R.id.sound123);
//        Toast.makeText(Vocabulary_fruits.this,"id"+fruitsList.
//        get(vpHorizontal.getCurrentItem()),Toast.LENGTH_SHORT).show();
        sound1234.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak(fruitsList.get(vpHorizontal.getCurrentItem()));

            }

            private void speak(Fruits word) {
                String mword = word.getWord();
                toSpeech.speak(mword, TextToSpeech.QUEUE_FLUSH, null);
                

            }
        });


        dbFruit = new VocabularyDBHelper(this);
        dbFruit.getReadableDatabase();
        fruitsList = dbFruit.getAllVocabularySPORT();
//        Collections.shuffle(fruitsList);

        icBack = findViewById(R.id.bacFruit);
        backHome = findViewById(R.id.backHome);
        icBack.setOnClickListener(this);
        backHome.setOnClickListener(this);


        vpHorizontal = findViewById(R.id.vp_horizontal);
//        adapterSports= new AdapterSports(images);

        adapterFruits = new AdapterFruits(Vocabulary_fruits.this, fruitsList,dbFruit);
//        vpHorizontal.setAdapter(adapterSports);
//        Toast.makeText(Vocabulary_fruits.this, + String.valueOf().show();



        vpHorizontal.setClipToPadding(false);
        //set page limit
        vpHorizontal.setClipChildren(false);
        vpHorizontal.setOffscreenPageLimit(3);
        //set default start position
        vpHorizontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        //SET ADAPTER ON HORIZONTAL  viewpager;
        vpHorizontal.setAdapter(adapterFruits);
        //initialize composite page transformer
        CompositePageTransformer transformer = new CompositePageTransformer();
        //Add margin between page
        transformer.addTransformer(new MarginPageTransformer(8));
        //Increase selected page size
        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float v = 1 - Math.abs(position);
                //set scale y
                page.setScaleY(0.8f + v * 0.2f);



            }
        });
        //set page transform
        vpHorizontal.setPageTransformer(transformer);

        Speech();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bacFruit:
//                Intent IntentBack=new Intent(Vocabulary_sports.this, GridTopic.class);
//                startActivity(IntentBack);

            case R.id.backHome:
                Intent IntentBackHome = new Intent(Vocabulary_fruits.this, MainActivity.class);
                startActivity(IntentBackHome);

        }
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