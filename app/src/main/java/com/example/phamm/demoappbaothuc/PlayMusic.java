package com.example.phamm.demoappbaothuc;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class PlayMusic extends Service {
    private MediaPlayer mediaPlayer;
    int id;
    public PlayMusic() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this,R.raw.nhac_chuong);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("AAA","Nhạc Báo Thức");
        String key = intent.getExtras().getString("extra");
        if(key.equals("on")){
           id = 0;
        }
        if(key.equals("off")){
            id =  1;
        }
        if(id==0){
            mediaPlayer.start();
            id=0;
        }
        if(id==1){
            mediaPlayer.stop();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.release();
        super.onDestroy();

    }
}
