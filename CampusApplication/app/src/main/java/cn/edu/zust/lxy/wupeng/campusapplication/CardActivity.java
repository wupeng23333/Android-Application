package cn.edu.zust.lxy.wupeng.campusapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.edu.zust.lxy.wupeng.campusapplication.database.DatabaseHelper;

public class CardActivity extends AppCompatActivity {

    private TextView tv_username, tv_email, tv_telephone, tv_id;
    private Button btn_back;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        tv_id = (TextView) findViewById(R.id.tv_id);
        tv_username = (TextView) findViewById(R.id.tv_username);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_telephone = (TextView) findViewById(R.id.tv_telephone);
        btn_back = (Button) findViewById(R.id.btn_back);

        sp = getSharedPreferences("user", MODE_PRIVATE);
        databaseHelper = new DatabaseHelper(this, "db_campus", null, 1);
        database = databaseHelper.getReadableDatabase();

        String username = sp.getString("username", "");
        Cursor cursor = database.query("user", null, "username=?",
                new String[]{username}, null, null, null);
        cursor.moveToNext();
        String id = cursor.getString(0);
        String email = cursor.getString(3);
        String telephone = cursor.getString(4);
        cursor.close();

        tv_id.setText(id);
        tv_username.setText(username);
        tv_email.setText(email);
        tv_telephone.setText(telephone);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}