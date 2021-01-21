package cn.edu.zust.lxy.wupeng.campusapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.edu.zust.lxy.wupeng.campusapplication.database.DatabaseHelper;

public class EditActivity extends AppCompatActivity {
    private EditText et_username, et_userpassword,et_email, et_telephone;
    private Button btn_edit,btn_back;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        et_username = (EditText) findViewById(R.id.et_username);
        et_userpassword = (EditText) findViewById(R.id.et_userpassword);
        et_email = (EditText) findViewById(R.id.et_email);
        et_telephone = (EditText) findViewById(R.id.et_telephone);
        btn_edit = (Button) findViewById(R.id.btn_edit);
        btn_back=(Button)findViewById(R.id.btn_back);
        sp = getSharedPreferences("user", MODE_PRIVATE);

        databaseHelper = new DatabaseHelper(this, "db_campus", null, 1);
        database = databaseHelper.getReadableDatabase();


        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = sp.getString("username", "");
                String[] args = {et_username.getText().toString(), et_userpassword.getText().toString()};
                ContentValues values = new ContentValues();
                values.put("username", et_username.getText().toString());
                values.put("userpassword", et_userpassword.getText().toString());
                values.put("email",et_email.getText().toString());
                values.put("telephone",et_telephone.getText().toString());
                int count = database.update("user", values, "username=?", new String[]{username});
                if (count > 0) {
                    //将更新后的username保存到sp中
                    SharedPreferences.Editor editor=sp.edit();
                    editor.clear();
                    editor.putString("username",et_username.getText().toString());
                    editor.commit();
                    Toast.makeText(EditActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(EditActivity.this,PersonalCenterActivity.class);
                    startActivity(intent);
                } else Toast.makeText(EditActivity.this, "修改失败", Toast.LENGTH_SHORT).show();

            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EditActivity.this,PersonalCenterActivity.class);
                startActivity(intent);
            }
        });
    }
}