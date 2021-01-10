package com.wupeng.myapplication3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void searchBtn(View view) {
        switch (view.getId()){
            case R.id.search:{
                String url=((TextView)findViewById(R.id.url)).getText().toString();
                Intent intent=new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri uri=Uri.parse(url);
                intent.setData(uri);
                startActivity(intent);
            }
        }
    }
}