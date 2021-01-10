package com.wupeng.myapplication7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UserAddActivity extends AppCompatActivity {
    private EditText et_username, et_userpassword, et_email, et_telephone;
    private Button btn_save, btn_display;
    public static final int ADD_FAILD = 0;
    public static final int ADD_SUCCESS = 1;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ADD_FAILD:
                    Toast.makeText(UserAddActivity.this, "新用户添加失败", Toast.LENGTH_LONG).show();
                    et_username.setText("");
                    et_userpassword.setText("");
                    break;
                case ADD_SUCCESS:
                    Toast.makeText(UserAddActivity.this, "新用户添加成功", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(UserAddActivity.this, MainActivity.class);
                    startActivity(intent);
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_add);
        et_username = (EditText) findViewById(R.id.username);
        et_userpassword = (EditText) findViewById(R.id.userpassword);
        et_email = (EditText) findViewById(R.id.email);
        et_telephone = (EditText) findViewById(R.id.telephone);
        btn_save = (Button) findViewById(R.id.save);
        btn_display = (Button) findViewById(R.id.display);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString().trim();
                String password = et_userpassword.getText().toString().trim();
                String email = et_email.getText().toString().trim();
                String telephone = et_telephone.getText().toString().trim();
                final Map<String, String> data = new HashMap<String, String>();
                data.put("username", username);
                data.put("password", password);
                data.put("email", email);
                data.put("telephone", telephone);
                final String url = HttpUtil.BASE_URL + "/addServlet";
                new Thread() {
                    public void run() {
                        try {
                            String returndata = HttpUtil.postRequest(url, data);
                            JSONObject jsondata = new JSONObject(returndata);
                            Message message = new Message();
                            if (jsondata.getBoolean("flag")) {
                                message.what = ADD_SUCCESS;
                                handler.sendMessage(message);
                            } else {
                                message.what = ADD_FAILD;
                                handler.sendMessage(message);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
        btn_display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserAddActivity.this, MainActivity.class);
                finish();
            }
        });
    }

}
