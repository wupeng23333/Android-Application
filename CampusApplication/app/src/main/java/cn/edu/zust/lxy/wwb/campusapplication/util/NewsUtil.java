package cn.edu.zust.lxy.wwb.campusapplication.util;

import android.content.Context;

import java.util.ArrayList;

import cn.edu.zust.lxy.wwb.campusapplication.R;
import cn.edu.zust.lxy.wwb.campusapplication.bean.News;

/**
 * Created by wwb on 2021/1/2.
 */

public class NewsUtil {
    public static ArrayList<News> getAllNews(Context context) {
        ArrayList<News> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            News News1 = new News();
            News1.title = "鸟瞰暴雨后的武汉 全市已转移16万人次";
            News1.des = "7月5-6日，武汉普降暴雨-大暴雨，中心城区、蔡甸部分地区出现特大暴雨。江夏大道汤逊湖大桥段，被湖水冲破的路障。记者贾代腾飞 陈卓摄";
            News1.icon = context.getResources().getDrawable(R.drawable.android,null);
            News1.news_url = "http://slide.news.sina.com.cn/s/slide_1_2841_101020.html#p=1";
            arrayList.add(News1);

            News News2 = new News();
            News2.title = "安徽暴雨 三四十条鳄鱼逃至附近农田";
            News2.des = "因强降雨造成内涝，安徽省芜湖市芜湖县花桥镇鳄鱼湖农庄所养鳄鱼逃跑至附近农田。。据悉，溜出来的鳄鱼为散养的扬子鳄，比较温驯。初步预计有三四十条，具体数量未统计，其中最大的约1.8米长。图为网友拍摄到的农田中的鳄鱼。";
            News2.icon = context.getResources().getDrawable(R.drawable.android,null);
            News2.news_url = "http://slide.news.sina.com.cn/s/slide_1_2841_101024.html#p=1";
            arrayList.add(News2);

            News News3 = new News();
            News3.title = "暴雨过后 南京理工大学变“奇幻森林”";
            News3.des = "近日，持续强降雨，导致地势低洼的南京理工大学出现严重积水。这一组几张照片，南理工恍若童话世界中。网友：泡在水中的南理工，也可以倔强地刷出颜值新高度。";
            News3.icon = context.getResources().getDrawable(R.drawable.android,null);
            News3.news_url = "http://slide.news.sina.com.cn/s/slide_1_2841_101010.html#p=1";
            arrayList.add(News3);
        }
        return arrayList;
    }
}
