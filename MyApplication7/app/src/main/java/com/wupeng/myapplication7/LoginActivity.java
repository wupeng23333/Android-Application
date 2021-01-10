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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    /*编写程序，实现基于Android客户端与服务器端交互的会员注册、登录、个人资料管理等功能，
    要求数据存储在MySQL数据库中，Servlet提供后台数据服务接口，Android做为客户端程序。*/

    //将验证成功后的user对象传递给UserActivity
    private JSONObject user;
//    private String user_username,user_userpassword,user_email,user_telephone;
    private Button btn_add, btn_login;
    private EditText et_username, et_userpassword;
    private String url = HttpUtil.BASE_URL + "/loginServlet";
    private Map<String, String> map;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                //登录成功
                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, UserActivity.class);
                try {
                    intent.putExtra("id",user.getString("id"));
                    intent.putExtra("username",user.getString("username"));
                    intent.putExtra("userpassword",user.getString("password"));
                    intent.putExtra("email",user.getString("email"));
                    intent.putExtra("telephone",user.getString("telephone"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                startActivity(intent);
            } else if (msg.what == 0) {
                //登录失败
                Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_add = (Button) findViewById(R.id.add);
        btn_login = (Button) findViewById(R.id.login);
        et_username = (EditText) findViewById(R.id.login_username);
        et_userpassword = (EditText) findViewById(R.id.login_userpassword);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString().trim();
                String password = et_userpassword.getText().toString().trim();
                map = new HashMap<String, String>();
                map.put("username", username);
                map.put("password", password);
                new Thread() {
                    public void run() {
                        try {
                            String returndata = HttpUtil.postRequest(url, map);
                            JSONObject jsondata = new JSONObject(returndata);
                            user=jsondata.getJSONObject("user");
                            Message msg = new Message();
                            if (jsondata.getBoolean("flag")) {
                                //登录成功
                                msg.what = 1;
                            } else {
                                //登录失败
                                msg.what = 0;
                            }
                            handler.sendMessage(msg);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, UserAddActivity.class);
                startActivity(intent);
            }
        });
    }
}

