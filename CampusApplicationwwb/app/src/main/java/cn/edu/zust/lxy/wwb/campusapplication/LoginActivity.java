package cn.edu.zust.lxy.wwb.campusapplication;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.HashMap;

import cn.edu.zust.lxy.wwb.campusapplication.util.HttpUtil;

public class LoginActivity extends AppCompatActivity {
    private EditText etAccount;
    private EditText etPwd;
    private Button btnLogin;
    String url = HttpUtil.BASE_URL + "/loginServlet";
    HashMap<String, String> data;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_LONG).show();
                    etAccount.setText("");
                    etPwd.setText("");
                    break;
                case 1:
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etAccount = findViewById(R.id.et_account);
        etPwd = findViewById(R.id.et_pwd);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = etAccount.getText().toString().trim();
                String pwd = etPwd.getText().toString().trim();
                if (account == null || account.length() <= 0) {
                    Toast.makeText(LoginActivity.this,"请输入账号",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pwd == null || pwd.length() <= 0) {
                    Toast.makeText(LoginActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }
                data = new HashMap<String, String>();
                data.put("account", account);
                data.put("password", pwd);
                new Thread(){
                    public void run(){
                        try {
                            String returndata = HttpUtil.postRequest(url, data);
                            JSONObject jsondata = new JSONObject(returndata);
                            Message message = new Message();
                            if (jsondata.getBoolean("flag")) {
                                message.what = 1;
                                handler.sendMessage(message);
                            } else {
                                message.what = 0;
                                handler.sendMessage(message);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });

    }
}
