package cn.edu.zust.lxy.wupeng.campusapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PersonalCenterActivity extends AppCompatActivity {

    private Button btn_back;
    private TextView tv_username;
    private LinearLayout ll_exit, ll_edit;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_center);
        btn_back = (Button) findViewById(R.id.btn_back);
        tv_username = (TextView) findViewById(R.id.tv_username);
        ll_edit = (LinearLayout) findViewById(R.id.ll_edit);
        ll_exit = (LinearLayout) findViewById(R.id.ll_exit);
        sp = getSharedPreferences("user", MODE_PRIVATE);

        tv_username.setText(sp.getString("username", ""));
        //修改资料
        ll_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PersonalCenterActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });
        //退出登录
        ll_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //清除sp中的数据
                SharedPreferences.Editor editor=sp.edit();
                editor.clear().commit();
                Toast.makeText(PersonalCenterActivity.this, "退出成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PersonalCenterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PersonalCenterActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}