package com.wupeng.myapplication7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*编写程序，实现基于Android客户端与服务器端交互的会员注册、登录、个人资料管理等功能，
    要求数据存储在MySQL数据库中，Servlet提供后台数据服务接口，Android做为客户端程序。*/
    private Button btn_add, btn_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_add = (Button) findViewById(R.id.add);
        btn_list = (Button) findViewById(R.id.list);
        btn_add.setOnClickListener(this);
        btn_list.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v == btn_add) {
            intent = new Intent(MainActivity.this, UserAddActivity2.class);
            startActivity(intent);
        } else if (v == btn_list) {
            intent = new Intent(MainActivity.this, UserListActivity.class);
            startActivity(intent);
        }
    }

}
