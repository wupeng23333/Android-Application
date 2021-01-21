package cn.edu.zust.lxy.wupeng.campusapplication.bean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import cn.edu.zust.lxy.wupeng.campusapplication.R;
import cn.edu.zust.lxy.wupeng.campusapplication.bean.Message;


public class MessageAdapter extends ArrayAdapter<Message> {
    private int resourceId;
    public MessageAdapter(@NonNull Context context, int resource, @NonNull List<Message> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = getItem(position); //获取当前Message实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent,
                false);
        TextView author = (TextView)view.findViewById(R.id.tv_message_author);
        TextView content = (TextView)view.findViewById(R.id.tv_message_content);

        author.setText(message.getAuthor());
        content.setText(message.getContent());
        return view;
    }
}
