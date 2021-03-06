package com.wupeng.myapplication7;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wwb on 2020/12/31.
 */

public class UserAddActivity extends AppCompatActivity {
    private EditText et_username, et_userpassword, et_email, et_telephone;
    private Button btn_save;

    //http://172.19.170.146:8080/addServlet
    private String url = HttpUtil.BASE_URL + "/addServlet";
    private Map<String, String> map;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                //新增成功
                Toast.makeText(UserAddActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(UserAddActivity.this,LoginActivity.class);
                startActivity(intent);
            } else if (msg.what == 0) {
                //新增失败
                Toast.makeText(UserAddActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_add);
        et_username = (EditText) findViewById(R.id.add_username);
        et_userpassword = (EditText) findViewById(R.id.add_userpassword);
        et_email = (EditText) findViewById(R.id.add_email);
        et_telephone = (EditText) findViewById(R.id.add_telephone);
        btn_save = (Button) findViewById(R.id.save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString().trim();
                String password = et_userpassword.getText().toString().trim();
                String email = et_email.getText().toString().trim();
                String telephone = et_telephone.getText().toString().trim();
                map = new HashMap<String, String>();
                map.put("username", username);
                map.put("password", password);
                map.put("email", email);
                map.put("telephone", telephone);
                new Thread() {
                    public void run() {
                        try {
                            String returndata = HttpUtil.postRequest(url, map);
                            JSONObject jsondata = new JSONObject(returndata);
                            Message msg = new Message();
                            if (jsondata.getBoolean("flag")) {
                                //新增成功
                                msg.what = 1;
                            } else {
                                msg.what = 0;
                                //新增失败
                            }
                            handler.sendMessage(msg);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
    }
}
