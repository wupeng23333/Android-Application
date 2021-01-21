package cn.edu.zust.lxy.wupeng.campusapplication.bean;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

public class BannerLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //Glide
        Glide.with(context)
                .load(path)
                .into(imageView);
    }


}
