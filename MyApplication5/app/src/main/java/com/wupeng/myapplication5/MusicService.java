package com.wupeng.myapplication5;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        //获取意图传递的信息
        String action = intent.getStringExtra("action");
        switch (action) {
            case "startMusic":
                playMusic();
                break;
            case "stopMusic":
                stopMusic();
                break;
            case "pauseMusic":
                pauseMusic();
                break;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void playMusic() {
        if (mediaPlayer == null) {
            //调⽤MediaPlayer的静态⽅法create
            mediaPlayer = MediaPlayer.create(this, R.raw.music);
        }
        mediaPlayer.start();
    }

    private void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop(); //停⽌
            mediaPlayer.reset(); //重置
            mediaPlayer.release(); //释放资源
            mediaPlayer = null; //重新赋值为空
        }
    }

    private void pauseMusic() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    @Override
    public void onDestroy() {
        stopMusic();
        super.onDestroy();
    }
}