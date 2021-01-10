package com.wupeng.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Intent intent = getIntent();
        String name = intent.getStringExtra("s_name");
        String tel = intent.getStringExtra("s_tel");
        String address = intent.getStringExtra("s_address");
        if (name != null)
            ((TextView) findViewById(R.id.name)).setText(name);
        if (tel != null)
            ((TextView) findViewById(R.id.tel)).setText(tel);
        if (address != null)
            ((TextView) findViewById(R.id.address)).setText(address);
    }

    public void Add(View view) {
        switch (view.getId()) {
            case R.id.add: {
                Intent intent = new Intent(ContactActivity.this, AddContactActivity.class);
                startActivity(intent);
            }
        }
    }
}