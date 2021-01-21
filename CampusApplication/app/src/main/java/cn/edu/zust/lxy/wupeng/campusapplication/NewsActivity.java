package cn.edu.zust.lxy.wupeng.campusapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_news_1, tv_news_2, tv_news_3, tv_news_4, tv_news_5;
    private Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        tv_news_1 = (TextView) findViewById(R.id.tv_news_1);
        tv_news_2 = (TextView) findViewById(R.id.tv_news_2);
        tv_news_3 = (TextView) findViewById(R.id.tv_news_3);
        tv_news_4 = (TextView) findViewById(R.id.tv_news_4);
        tv_news_5 = (TextView) findViewById(R.id.tv_news_5);
        btn_back = (Button) findViewById(R.id.btn_back);

        tv_news_1.setOnClickListener(this);
        tv_news_2.setOnClickListener(this);
        tv_news_3.setOnClickListener(this);
        tv_news_4.setOnClickListener(this);
        tv_news_5.setOnClickListener(this);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewsActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri url;
        switch (view.getId()) {
            case R.id.tv_news_1: {
                url = Uri.parse("https://www.zust.edu.cn/info/1089/12542.htm");
                intent.setData(url);
                startActivity(intent);
                break;
            }
            case R.id.tv_news_2: {
                url = Uri.parse("https://www.zust.edu.cn/info/1089/12540.htm");
                intent.setData(url);
                startActivity(intent);
                break;
            }
            case R.id.tv_news_3: {
                url = Uri.parse("https://www.zust.edu.cn/info/1089/12536.htm");
                intent.setData(url);
                startActivity(intent);
                break;
            }
            case R.id.tv_news_4: {
                url = Uri.parse("https://www.zust.edu.cn/info/1089/12535.htm");
                intent.setData(url);
                startActivity(intent);
                break;
            }
            case R.id.tv_news_5: {
                url = Uri.parse("https://www.zust.edu.cn/info/1089/12527.htm");
                intent.setData(url);
                startActivity(intent);
                break;
            }
        }
    }
}