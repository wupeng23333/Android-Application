package cn.edu.zust.lxy.wupeng.campusapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import cn.edu.zust.lxy.wupeng.campusapplication.bean.BannerLoader;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_shcool, iv_personal_center, iv_news, iv_library, iv_communication, iv_search, iv_education_system,iv_schedule,iv_card;
    private Banner banner;
    //定义图片集合
    private List<Integer> list_img = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //加载轮播图
        initView();

        iv_shcool = (ImageView) findViewById(R.id.school);
        iv_personal_center = (ImageView) findViewById(R.id.personal_center);
        iv_news = (ImageView) findViewById(R.id.news);
        iv_library = (ImageView) findViewById(R.id.library);
        iv_communication = (ImageView) findViewById(R.id.communication);
        iv_search = (ImageView) findViewById(R.id.search);
        iv_education_system = (ImageView) findViewById(R.id.education_system);
        iv_schedule=(ImageView)findViewById(R.id.schedule);
        iv_card=(ImageView)findViewById(R.id.card);

        iv_shcool.setOnClickListener(this);
        iv_personal_center.setOnClickListener(this);
        iv_news.setOnClickListener(this);
        iv_library.setOnClickListener(this);
        iv_communication.setOnClickListener(this);
        iv_search.setOnClickListener(this);
        iv_education_system.setOnClickListener(this);
        iv_schedule.setOnClickListener(this);
        iv_card.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.school: {
                Intent intent = new Intent(HomeActivity.this, SchoolActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.personal_center: {
                Intent intent = new Intent(HomeActivity.this, PersonalCenterActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.news: {
                Intent intent = new Intent(HomeActivity.this, NewsActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.library: {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri url = Uri.parse("https://lib.zust.edu.cn/");
                intent.setData(url);
                startActivity(intent);
                break;
            }
            case R.id.communication: {
                Intent intent = new Intent(HomeActivity.this, CommunicationActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.search: {
                Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.education_system: {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri url = Uri.parse("https://authserver.zust.edu.cn/authserver/login");
                intent.setData(url);
                startActivity(intent);
                break;
            }
            case R.id.schedule: {
                Intent intent = new Intent(HomeActivity.this, ScheduleActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.card: {
                Intent intent = new Intent(HomeActivity.this,CardActivity.class);
                startActivity(intent);
                break;
            }
        }

    }

    //轮播图方法
    private void initView() {
        banner = (Banner) findViewById(R.id.banner);
        //添加数据
        list_img.add(R.drawable.a1);
        list_img.add(R.drawable.a2);
        list_img.add(R.drawable.a3);
        list_img.add(R.drawable.a4);
        list_img.add(R.drawable.a5);
        //设置图片加载器
        banner.setImageLoader(new BannerLoader());
        //显示图片
        banner.setImages(list_img);
        //启动
        banner.start();

    }


}