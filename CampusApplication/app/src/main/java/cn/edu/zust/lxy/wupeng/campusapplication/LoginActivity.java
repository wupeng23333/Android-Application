package cn.edu.zust.lxy.wupeng.campusapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cn.edu.zust.lxy.wupeng.campusapplication.database.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {
    private EditText et_username, et_userpassword;
    private Button btn_login,btn_back;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;
    //存储登录成功后的用户名
    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        databaseHelper = new DatabaseHelper(LoginActivity.this, "db_campus", null, 1);
        database = databaseHelper.getReadableDatabase();

        et_username = (EditText) findViewById(R.id.et_username);
        et_userpassword = (EditText) findViewById(R.id.et_userpassword);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_back=(Button)findViewById(R.id.btn_back);

        //判断登录是否成功
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] args = {et_username.getText().toString(), et_userpassword.getText().toString()};
                Cursor cursor = database.query("user", null, "username=? and userpassword=?",
                        args, null, null, null);
                if (cursor.getCount() > 0) {
                    //将用户名存储在SharedPreferences中
                    SharedPreferences.Editor editor = getSharedPreferences("user", MODE_PRIVATE).edit();
                    editor.putString("username", et_username.getText().toString());
                    editor.commit();

                    Toast.makeText(LoginActivity.this, "登录成功！", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);

                } else Toast.makeText(LoginActivity.this, "登录失败！", Toast.LENGTH_LONG).show();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}