package com.wupeng.myapplication6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity {
    private EditText reg_username;
    private EditText reg_userpassword;
    private Button reg_submit;
    private OpenHelper openHelper;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        reg_username = (EditText) findViewById(R.id.reg_username);
        reg_userpassword = (EditText) findViewById(R.id.reg_userpassword);
        reg_submit = (Button) findViewById(R.id.reg_submit);
        openHelper = new OpenHelper(this, "db_user", null, 1);
        database = openHelper.getReadableDatabase();
        reg_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] args = {reg_username.getText().toString(), reg_userpassword.getText().toString()};
                Cursor cursor = database.query("user", null, "username=? and userpassword=?",
                        args, null, null, null);
                if (cursor.getCount() > 0) {
                    Toast.makeText(RegActivity.this, "用户已存在！", Toast.LENGTH_LONG).show();
                } else {
                    ContentValues values = new ContentValues();
                    values.put("username", reg_username.getText().toString());
                    values.put("userpassword", reg_userpassword.getText().toString());
                    database.insert("user", null, values);
                    Toast.makeText(RegActivity.this, "用户注册成功！", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}