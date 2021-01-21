package com.wupeng.myapplication3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
    }

    private String s_name;
    private String s_tel;
    private String s_address;

    public void SubmitBtnOnClick(View view) {

        s_name = ((EditText) findViewById(R.id.s_name)).getText().toString();
        s_tel = ((EditText) findViewById(R.id.s_tel)).getText().toString();
        s_address = ((EditText) findViewById(R.id.s_address)).getText().toString();
        switch (view.getId()) {
            case R.id.submit: {
                Intent intent = new Intent(AddContactActivity.this, ContactActivity.class);
                intent.putExtra("s_name", s_name);
                intent.putExtra("s_tel", s_tel);
                intent.putExtra("s_address", s_address);
                startActivity(intent);
            }
        }

    }
}