package com.wupeng.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    /*运用BroadcastReceiver的特性设计一个用于获取手机剩余电量的程序，
    单击页面上的“获取手机当前电量”按钮，弹出当前的电量信息。如下图所示：*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getPower(View view) {
        switch (view.getId()) {
            case R.id.getPower: {
                registerReceiver(new PowerReceiver(), new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
                break;
            }

            default:
                break;
        }
    }
}