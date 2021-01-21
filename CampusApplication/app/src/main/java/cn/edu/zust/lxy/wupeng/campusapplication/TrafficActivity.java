package cn.edu.zust.lxy.wupeng.campusapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TrafficActivity extends AppCompatActivity {
    private Button btn_back;
    private TextView tv_traffic;
    String text = "来校交通路线\n" +
            "\t\t\t\t1、学校地址：杭州市西湖区留和路318号\n" +
            "\t\t\t\t2、赴校路线：\n" +
            "\t\t\t\t\t\t【火车杭州站（城站）--学校】地铁1号线至武林广场下，武林广场北转乘B4至汽车西站，换乘K193、K310 、K853路直达小和山校区；快速公交B2（区间）至八字桥站转乘B4至汽车西站，换乘K193、K310 、K853路直达小和山校区；公交K49路到汽车西站换乘K853路或K193、K310。\n" +
            "\t\t\t\t\t\t【火车东站--学校】地铁1号线至武林广场下，武林广场北转乘B4至汽车西站，换乘K193、K310 、K853路直达小和山校区；公交179路至汽车西站，换乘乘K193、K310 、K853路直达小和山校区。\n" +
            "\t\t\t\t\t\t【汽车西站--学校】乘K193、K310 、K853路直达小和山校区。\n" +
            "\t\t\t\t\t\t【杭州客运中心（九堡）--学校】乘九堡中心站-西站直达班车到汽车西站K193、K310。\n" +
            "\t\t\t\t\t\t【汽车北站--学校】乘K91至长途汽车西站换乘K853、K193、K310路；乘北站-西站直达班车到汽车西站换乘K853、K193、K310路。\n" +
            "\t\t\t\t\t\t【汽车南站--学校】乘南站-西站直达班车到汽车西站换乘K193、K310、K853路。\n" +
            "\t\t\t\t\t\t【自驾车--学校】杭州市区沿天目山路一直往西经西溪湿地到留下，然后沿留和路往南到小和山高教园区浙江科技学院；外地走杭州绕城高速西线留下出口下，向东（留下方向）在西溪路天目山路交叉口右拐至留和路，沿着留和路往南到小和山高教园区浙江科技学院。";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic);
        btn_back = (Button) findViewById(R.id.btn_back);
        tv_traffic = (TextView) findViewById(R.id.tv_traffic);
        tv_traffic.setText(text);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrafficActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }
}
