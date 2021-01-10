package cn.edu.zust.lxy.wwb.campusapplication.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

import cn.edu.zust.lxy.wwb.campusapplication.R;
import cn.edu.zust.lxy.wwb.campusapplication.bean.News;
import cn.edu.zust.lxy.wwb.campusapplication.util.NewsUtil;


public class NewsFragment extends Fragment {
    private View view;
    private ListView lv;
    private ArrayList<News> mList;

    public NewsFragment() {

    }

    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_news,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        lv = (ListView) view.findViewById(R.id.lv_news);
        mList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            News News1 = new News();
            News1.title = "鸟瞰暴雨后的武汉 全市已转移16万人次";
            News1.des = "7月5-6日，武汉普降暴雨-大暴雨，中心城区、蔡甸部分地区出现特大暴雨。江夏大道汤逊湖大桥段，被湖水冲破的路障。记者贾代腾飞 陈卓摄";
            News1.icon = getContext().getDrawable(R.drawable.android);
            News1.news_url = "http://slide.news.sina.com.cn/s/slide_1_2841_101020.html#p=1";
            mList.add(News1);

            News News2 = new News();
            News2.title = "安徽暴雨 三四十条鳄鱼逃至附近农田";
            News2.des = "因强降雨造成内涝，安徽省芜湖市芜湖县花桥镇鳄鱼湖农庄所养鳄鱼逃跑至附近农田。。据悉，溜出来的鳄鱼为散养的扬子鳄，比较温驯。初步预计有三四十条，具体数量未统计，其中最大的约1.8米长。图为网友拍摄到的农田中的鳄鱼。";
            News2.icon = getContext().getDrawable(R.drawable.android);
            News2.news_url = "http://slide.news.sina.com.cn/s/slide_1_2841_101024.html#p=1";
            mList.add(News2);

            News News3 = new News();
            News3.title = "暴雨过后 南京理工大学变“奇幻森林”";
            News3.des = "近日，持续强降雨，导致地势低洼的南京理工大学出现严重积水。这一组几张照片，南理工恍若童话世界中。网友：泡在水中的南理工，也可以倔强地刷出颜值新高度。";
            News3.icon = getContext().getDrawable(R.drawable.android);
            News3.news_url = "http://slide.news.sina.com.cn/s/slide_1_2841_101010.html#p=1";
            mList.add(News3);
        }

        lv.setAdapter(new NewsAdapter());
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(mList.get(position).news_url));
                startActivity(intent);
            }
        });
    }
    private class NewsAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public News getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(getContext(), R.layout.item_news_layout, null);
                holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
                holder.tv_des = (TextView) convertView.findViewById(R.id.tv_des);
                holder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            News item = getItem(position);
            holder.tv_title.setText(item.title);
            holder.tv_des.setText(item.des);
            holder.iv_icon.setImageDrawable(item.icon);
            return convertView;
        }
    }

    private static class ViewHolder {
        TextView tv_title;
        TextView tv_des;
        ImageView iv_icon;

    }
}
