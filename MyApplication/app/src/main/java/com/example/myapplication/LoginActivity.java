package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    /*完成一个用户登录界面设计，可采用线性布局或者相对布局，
    界面中至少要包含账号（EditText）、密码（EditText）、登录按钮（Button）、注册按钮（Button）等控件。
    点击“登录”按钮，验证用户输入的账号和密码，当用户输入的账号为admin，密码为12345时，显示“登录成功”，
    否则显示“用户名或密码有误”，点击“注册”按钮切换到注册页面。*/


    /*完成一个用户注册界面设计，可采用线性布局或者相对布局，界面中至少要包含账号（EditText）、密码（EditText）、
    性别（RadioButton）、城市（EditText，点击该文本编辑框弹出列表对话框AlertDialog）、出生日期（EditText，
    点击该文本编辑框弹出日期对话框DatePickerDialog）、电话号码（EditText）以及提交按钮（Button）等信息。 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    String username;
    String userpassword;

    public void btnOnClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn: {
                username = ((EditText) findViewById(R.id.username)).getText().toString();
                userpassword = ((EditText) findViewById(R.id.userpassword)).getText().toString();
                if ("admin".equals(username) && "12345".equals(userpassword))
                    Toast.makeText(LoginActivity.this, "登陆成功！", Toast.LENGTH_SHORT).show();
                else Toast.makeText(LoginActivity.this, "用户名或密码有误！", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.reg_btn: {
                Intent intent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(intent);
                break;
            }
            default:
        }

    }
}