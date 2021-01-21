package cn.edu.zust.lxy.wupeng.campusapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_back, btn_search_1, btn_search_2, btn_search_3, btn_search_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_search_1 = (Button) findViewById(R.id.btn_search_1);
        btn_search_2 = (Button) findViewById(R.id.btn_search_2);
        btn_search_3 = (Button) findViewById(R.id.btn_search_3);
        btn_search_4 = (Button) findViewById(R.id.btn_search_4);

        btn_search_1.setOnClickListener(this);
        btn_search_2.setOnClickListener(this);
        btn_search_3.setOnClickListener(this);
        btn_search_4.setOnClickListener(this);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //校园黄页
            case R.id.btn_search_1: {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri url = Uri.parse("https://www.zust.edu.cn/fw/xyhy.htm");
                intent.setData(url);
                startActivity(intent);
                break;
            }
            //院历
            case R.id.btn_search_2: {
                Intent intent=new Intent(SearchActivity.this,CalendarActivity.class);
                startActivity(intent);
                break;
            }
            //班车查询
            case R.id.btn_search_3: {
                Intent intent=new Intent(SearchActivity.this,BusActivity.class);
                startActivity(intent);
                break;
            }
            //交通咨询
            case R.id.btn_search_4: {
                Intent intent=new Intent(SearchActivity.this,TrafficActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}