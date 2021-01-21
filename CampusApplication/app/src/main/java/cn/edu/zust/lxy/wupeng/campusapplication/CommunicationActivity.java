package cn.edu.zust.lxy.wupeng.campusapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.edu.zust.lxy.wupeng.campusapplication.bean.Message;
import cn.edu.zust.lxy.wupeng.campusapplication.bean.MessageAdapter;
import cn.edu.zust.lxy.wupeng.campusapplication.database.DatabaseHelper;

public class CommunicationActivity extends AppCompatActivity {

    private Button btn_back, btn_submit;
    private EditText et_message;
    private ListView lv_message;
    private SQLiteDatabase database;
    private DatabaseHelper databaseHelper;
    private SharedPreferences sp;
    private List<Message> messageList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);

        databaseHelper = new DatabaseHelper(CommunicationActivity.this, "db_campus", null, 1);
        database = databaseHelper.getReadableDatabase();

        et_message = (EditText) findViewById(R.id.et_message);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_submit = (Button) findViewById(R.id.btn_submit);

        lv_message = (ListView) findViewById(R.id.lv_message);
        //初始化校园圈消息
        initMessage();
        MessageAdapter adapter = new MessageAdapter(this, R.layout.meesage_item,
                messageList);
        lv_message.setAdapter(adapter);
        //提交
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String author = getSharedPreferences("user", MODE_PRIVATE).getString("username", "");
                String content = et_message.getText().toString();
                ContentValues values = new ContentValues();
                values.put("author", author);
                values.put("content", content);
                database.insert("message", null, values);
                Toast.makeText(CommunicationActivity.this, "提交成功！", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CommunicationActivity.this, CommunicationActivity.class);
                startActivity(intent);
            }
        });
        //返回
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CommunicationActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initMessage() {
        Cursor cursor = database.query("message", null, null, null, null, null, null);
        if (cursor.moveToLast()) {
            Message message = new Message();
            message.setAuthor(cursor.getString(1));
            message.setContent(cursor.getString(2));
            messageList.add(message);
        }
        while (cursor.moveToPrevious()) {
            Message message = new Message();
            message.setAuthor(cursor.getString(1));
            message.setContent(cursor.getString(2));
            messageList.add(message);
        }
        cursor.close();
    }
}