package com.wupeng.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        status = (TextView) findViewById(R.id.status);
        status.setText("播放状态：停止播放");
        intent = new Intent(this, MusicService.class);
    }

    TextView status;
    Intent intent;

    public void startMusic(View view) {
        intent.putExtra("action", "startMusic");
        startService(intent);
        status.setText("播放状态：正在播放");
    }

    public void pauseMusic(View view) {
        intent.putExtra("action", "pauseMusic");
        startService(intent);
        status.setText("播放状态：暂停播放");
    }

    public void stopMusic(View view) {
        intent.putExtra("action", "stopMusic");
        startService(intent);
        status.setText("播放状态：停止播放");
    }

    public void exitMusic(View view) {
        stopMusic(view);
        finish();
        stopService(intent);
    }
}