package com.example.english;

import android.content.Context;
import android.media.MediaPlayer;

public class PlayAudio {
    private Context mContext;
    private MediaPlayer mediaPlayer;

    public  PlayAudio(Context context){
        this.mContext=context;
    }
    public void  setAudioForEvent( int FLAG){
        switch (FLAG){
            case 1:
                int correctAudio=R.raw.correct;
                playMusic(correctAudio);
                break;
            case 2:
                int wrongAudio=R.raw.error;
                playMusic(wrongAudio);
                break;
        }
    }
    private  void playMusic(int audioFile){

        mediaPlayer=MediaPlayer.create(mContext,audioFile);
        mediaPlayer.setOnPreparedListener(mp -> mediaPlayer.start());
        mediaPlayer.setOnCompletionListener(mp -> mediaPlayer.release());
    }
}
