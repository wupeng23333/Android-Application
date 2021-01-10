package com.wupeng.myapplication7;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {

    private TextView et_id,et_username, et_userpassword, et_email, et_telephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Intent intent = getIntent();

        et_id=(TextView)findViewById(R.id.id);
        et_username = (TextView) findViewById(R.id.username);
        et_userpassword = (TextView) findViewById(R.id.userpassword);
        et_email = (TextView) findViewById(R.id.email);
        et_telephone = (TextView) findViewById(R.id.telephone);

        et_id.setText(intent.getExtras().getString("id"));
        et_username.setText(intent.getExtras().getString("username"));
        et_userpassword.setText(intent.getExtras().getString("userpassword"));
        et_email.setText(intent.getExtras().getString("email"));
        et_telephone.setText(intent.getExtras().getString("telephone"));
    }


}