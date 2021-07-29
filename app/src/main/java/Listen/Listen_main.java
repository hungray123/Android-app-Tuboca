package Listen;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.icu.text.SimpleDateFormat;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.style.UpdateAppearance;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.english.MainActivity;
import  com.example.english.R;

import java.util.ArrayList;
import java.util.Set;

public class Listen_main extends AppCompatActivity { // khai báo
    TextView        txtTitle, txtTimeSong , txtTimeTotal ;
    SeekBar         skSong;
    ImageView       btSkip, btPlay , btStop ,btNext ;
    ArrayList<Song> arraySong;
    MediaPlayer mediaPlayer;
    int position =0;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_main);
        AnhXa();
        AddSong();
        KhoiTaoMediaPlayer();
        setTxtTimeTotal();
        UpdatetimeSong();


        btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                btPlay.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                KhoiTaoMediaPlayer();
            }
        });
        //chuyen bai nghe
        btNext.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                position++; // cho position tang len
                if (position > arraySong.size() - 1){ // kiem tra so luong bai hat trong mang
                    position = 0;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                KhoiTaoMediaPlayer();
                mediaPlayer.start();
                btPlay.setImageResource(R.drawable.ic_baseline_pause_24);
                setTxtTimeTotal();
                UpdatetimeSong();

            }
        });

        //chuyen bai nghe
        btSkip.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                position--; // cho position tang len
                if (position <0 ){ // kiem tra so luong bai hat trong mang
                    position = arraySong.size() - 1 ; //neu bai hat < 1 thi quay ve cuoi cung cua mang va start
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                KhoiTaoMediaPlayer();
                mediaPlayer.start();
                btPlay.setImageResource(R.drawable.ic_baseline_pause_24);
                setTxtTimeTotal();
                UpdatetimeSong();

            }
        });

        // phát bài nghe
        mediaPlayer = MediaPlayer.create(Listen_main.this, arraySong.get(position).getFile());
        txtTitle.setText(arraySong.get(position).getTitle());
        btPlay.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                 if(mediaPlayer.isPlaying()){
                     // nếu đang phát thì dừng lại và đổi biẻu tượng thành pause
                     mediaPlayer.pause();
                     btPlay.setImageResource(R.drawable.ic_baseline_play_arrow_24);

                 }else {
                     // nếu đang dừng thì phát
                     mediaPlayer.start();
                     btPlay.setImageResource(R.drawable.ic_baseline_pause_24);
                     setTxtTimeTotal();
                     UpdatetimeSong();
                 }
            }
        });

        skSong.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(skSong.getProgress()); //kéo thả thanh seekbar

            }
        });

    }

    private void UpdatetimeSong() {
        Handler handler =new Handler(); // khoi tao handler
        handler.postDelayed(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void run() {
                SimpleDateFormat hour = new SimpleDateFormat("mm:ss"); // định dạng lại time
                txtTimeSong.setText(hour.format(mediaPlayer.getCurrentPosition())); // lấy vị trí
                skSong.setProgress(mediaPlayer.getCurrentPosition());// cap nhat vi trri hien tai cua seekbar
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        position++; // cho position tang len
                        if (position > arraySong.size() - 1){ // kiem tra so luong bai hat trong mang
                            position = 0;
                        }
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        KhoiTaoMediaPlayer();
                        mediaPlayer.start();
                        btPlay.setImageResource(R.drawable.ic_baseline_pause_24);
                        setTxtTimeTotal();
                        UpdatetimeSong();
                    }
                });
                handler.postDelayed(this, 500);

            }
        },100);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setTxtTimeTotal(){
        @SuppressLint("SimpleDateFormat") SimpleDateFormat hour = new SimpleDateFormat("mm:ss");
        txtTimeTotal.setText(hour.format(mediaPlayer.getDuration()));
        //gán max của sksong = mediaPlayer.getDuration
        skSong.setMax(mediaPlayer.getDuration());
    }


    private void KhoiTaoMediaPlayer() {
        mediaPlayer = MediaPlayer.create(Listen_main.this, arraySong.get(position).getFile());
        txtTitle.setText(arraySong.get(position).getTitle());
    }


    //thêm bài nghe
    private void AddSong() {
        arraySong   = new ArrayList<>();
        arraySong.add(new Song("Holiday" , R.raw.holiday));
        arraySong.add(new Song("Meet" , R.raw.meet));
        arraySong.add(new Song("Travek" , R.raw.travel));
        arraySong.add(new Song("Restaurant" , R.raw.gapmat));


// dung viet hoa no bi loi
    }
//Truy suất view
    private void AnhXa() {
        txtTimeSong       =(TextView) findViewById(R.id.txtTimeSong);
        txtTimeTotal      =(TextView) findViewById(R.id.txtTimeTotal);
        txtTitle          =(TextView) findViewById(R.id.txtTitle);
        skSong            =(SeekBar)  findViewById(R.id.skSong);
        btSkip            =(ImageView)findViewById(R.id.btSkip);
        btPlay            =(ImageView)findViewById(R.id.btPlay);
        btStop           =(ImageView)findViewById(R.id.btStop);
        btNext            =(ImageView)findViewById(R.id.btNext);

    }
}