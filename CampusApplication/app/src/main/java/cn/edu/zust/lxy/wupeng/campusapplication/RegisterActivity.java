package cn.edu.zust.lxy.wupeng.campusapplication;

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

import cn.edu.zust.lxy.wupeng.campusapplication.database.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_username, et_userpassword,et_email, et_telephone;
    private Button btn_register,btn_back;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_username = (EditText) findViewById(R.id.et_username);
        et_userpassword = (EditText) findViewById(R.id.et_userpassword);
        et_email = (EditText) findViewById(R.id.et_email);
        et_telephone = (EditText) findViewById(R.id.et_telephone);
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_back=(Button)findViewById(R.id.btn_back);


        databaseHelper = new DatabaseHelper(this, "db_campus", null, 1);
        database = databaseHelper.getReadableDatabase();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] args = {et_username.getText().toString(), et_userpassword.getText().toString()};
                Cursor cursor = database.query("user", null, "username=? and userpassword=?",
                        args, null, null, null);
                if (cursor.getCount() > 0) {
                    Toast.makeText(RegisterActivity.this, "用户已存在！", Toast.LENGTH_LONG).show();
                } else {
                    ContentValues values = new ContentValues();
                    values.put("username", et_username.getText().toString());
                    values.put("userpassword", et_userpassword.getText().toString());
                    values.put("email",et_email.getText().toString());
                    values.put("telephone",et_telephone.getText().toString());
                    database.insert("user", null, values);
                    Toast.makeText(RegisterActivity.this, "用户注册成功！", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}