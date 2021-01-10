package cn.edu.zust.lxy.wwb.campusapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.flyco.tablayout.SlidingTabLayout;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.zust.lxy.wwb.campusapplication.IntroActivity;
import cn.edu.zust.lxy.wwb.campusapplication.R;
import cn.edu.zust.lxy.wwb.campusapplication.util.GlideImageLoader;


public class HomeFragment extends Fragment {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private static List<?> images;
    private String[] mTitles;
    private ViewPager viewPager;
    private SlidingTabLayout slidingTabLayout;
    private View view;
    private GridView gridView;
    private int[] icon = { R.mipmap.icon_gk2, R.mipmap.icon_xs,
            R.mipmap.icon_xq, R.mipmap.icon_bj, R.mipmap.icon_js,
            R.mipmap.icon_st };
    private String[] iconName = { "学校概况", "新生攻略", "兴趣课堂", "班级圈", "校园集市", "社团活动" };
    private List<Map<String,Object>> datas = new ArrayList<Map<String,Object>>();

    public HomeFragment() {

    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_home,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        viewPager = view.findViewById(R.id.fixedViewPager);
        slidingTabLayout = view.findViewById(R.id.slidingTabLayout);

        Banner banner = (Banner) view.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        //资源文件
        String[] urls = getResources().getStringArray(R.array.url);
        List list = Arrays.asList(urls);
        images = new ArrayList(list);
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        gridView = (GridView) view.findViewById(R.id.gv);
        for(int i=0;i<iconName.length;i++){
            Map<String,Object> item = new HashMap<String,Object>();
            item.put("iconName",iconName[i]);
            item.put("icon",icon[i]);
            datas.add(item);
        }
        String[] from = {"iconName","icon"};
        int[] to = {R.id.tv_text,R.id.iv_image};
        SimpleAdapter adapter = new SimpleAdapter(getContext(),datas,R.layout.grid_item,from,to);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                switch (position){
                    case 0:
                        intent.setClass(getContext(), IntroActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
}
