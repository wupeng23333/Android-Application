package com.wupeng.myapplication7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserListActivity extends AppCompatActivity {
    private ListView list;
    List<Map<String, Object>> data;
    String url = HttpUtil.BASE_URL + "/listServlet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        list = (ListView) findViewById(R.id.listView1);
        List<Map<String, Object>> ListData = getListData();
        SimpleAdapter adapter = new SimpleAdapter(this, ListData, R.layout.list_item,
                new String[]{"username", "email", "telephone"},
                new int[]{R.id.username, R.id.email, R.id.telephone});
        list.setAdapter(adapter);
    }

    private List<Map<String, Object>> getListData() {
        data = new ArrayList<Map<String, Object>>();
        new Thread() {
            public void run() {
                try {
                    String returndata = HttpUtil.getRequest(url);
                    JSONArray jsondata = new JSONArray(returndata);
                    for (int i = 0; i < jsondata.length(); i++) {
                        //获取json数组中的每一个元素
                        JSONObject jsonObject = jsondata.getJSONObject(i);
                        Map<String, Object> map = new HashMap<String, Object>();
                        map.put("username", jsonObject.getString("username"));
                        map.put("email", jsonObject.getString("email"));
                        map.put("telephone", jsonObject.getString("telephone"));
                        data.add(map);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return data;
    }
}
