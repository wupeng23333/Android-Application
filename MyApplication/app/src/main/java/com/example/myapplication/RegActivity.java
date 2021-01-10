package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
    }

    EditText city;
    EditText birthday;

    public void editTextOnClick(View view) {
        switch (view.getId()) {
            case R.id.city: {
                city = (EditText) findViewById(R.id.city);
                String[] items = {"北京", "上海", "成都", "厦门", "杭州", "武汉"};
                AlertDialog alertDialog = new AlertDialog.Builder(RegActivity.this).setTitle("请选择城市")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                city.setText(items[i]);
                            }
                        }).show();
                break;
            }
            case R.id.birthday: {
                birthday = (EditText) findViewById(R.id.birthday);
                DatePickerDialog dialog = new DatePickerDialog(RegActivity.this,DatePickerDialog.BUTTON_NEUTRAL, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        String date = i + "年" + (i1 + 1) + "月" + i2 + "日";
                        birthday.setText(date);
                    }
                }, 2000, 0, 1);
                dialog.show();
                break;
            }
        }
    }

    public void btnOnClick(View view) {
        if (view.getId()==R.id.submit_btn){
            Toast.makeText(RegActivity.this,"注册成功！",Toast.LENGTH_SHORT).show();
        }
    }
}