package com.wupeng.myapplication6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    /*编写程序，实现会员的注册与登录，会员注册的信息保存在本地SQLite数据库中，
    会员登录时如果选择保存密码，则会员登录成功后使用SharePreferences进行保存将账号和密码进行保存。 */
    private EditText et_username, et_userpassword;
    private CheckBox ck_remember;
    private Button btn_login;
    private SharedPreferences sp;
    private Button btn_reg;
    private OpenHelper openHelper;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        openHelper = new OpenHelper(this, "db_user", null, 1);
        database = openHelper.getReadableDatabase();
        et_username = (EditText) findViewById(R.id.username);
        et_userpassword = (EditText) findViewById(R.id.userpassword);
        ck_remember = (CheckBox) findViewById(R.id.remember);
        btn_login = (Button) findViewById(R.id.login);
        btn_reg = (Button) findViewById(R.id.reg);

        //读取SP存储中的数据
        sp = getSharedPreferences("login", MODE_PRIVATE);
        boolean isRemember = sp.getBoolean("sp_isRemember", false);
        if (isRemember) {
            String username = sp.getString("sp_username", "");
            String userpassword = sp.getString("sp_userpassword", "");
            et_username.setText(username);
            et_userpassword.setText(userpassword);
            ck_remember.setChecked(true);
        }

        //判断登录是否成功
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] args = {et_username.getText().toString(), et_userpassword.getText().toString()};
                Cursor cursor = database.query("user", null, "username=? and userpassword=?",
                        args, null, null, null);
                if (cursor.getCount() > 0) {
                    Toast.makeText(LoginActivity.this, "登录成功！", Toast.LENGTH_LONG).show();
                    if (ck_remember.isChecked()) {
                        String username = et_username.getText().toString();
                        String userpassword = et_userpassword.getText().toString();
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("sp_username", username);
                        editor.putString("sp_userpassword", userpassword);
                        editor.putBoolean("sp_isRemember", true);
                        editor.commit();
                    }
                } else Toast.makeText(LoginActivity.this, "登录失败！", Toast.LENGTH_LONG).show();
            }
        });

        //注册
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(intent);
            }
        });
    }

}
