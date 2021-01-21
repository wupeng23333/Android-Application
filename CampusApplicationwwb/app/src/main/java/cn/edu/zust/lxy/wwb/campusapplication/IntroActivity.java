package cn.edu.zust.lxy.wwb.campusapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity {
    private String text="\t\t\t\t浙江科技学院的前身由浙江大学于1980年创办。经过40年的建设，学校已发展成为一所具有硕士、学士学位授予权和外国留学生、港澳台学生招生权的特色鲜明的应用型省属本科高校。\n"
            +"\t\t\t\t学校有两个校区，小和山校区位于杭州市西湖区西溪湿地畔，校园土地面积1900余亩，建筑面积47万平方米；安吉校区位于拥有联合国人居奖美誉的竹乡安吉，土地面积800余亩，建筑面积16.5万平方米。校园自然环境优美，山明水秀，湖光鹭影，全国人大常委会原委员长张德江曾赞叹“真山真水，真是读书的好地方”。\n"
            +"\t\t\t\t学校下设14个二级学院、1个教学部；现有56个本科专业；拥有5个学术型硕士学位授权一级学科、5个硕士专业学位授权点。学校面向全国24个省（区、市）招生；现有全日制本科生、研究生17000余名；留学生2300余名。教学科研仪器设备总值4.19多亿元，纸质图书180余万册。\n"
            +"\t\t\t\t学校拥有一支具有国际化视野、学术水平一流、师德师风高尚、梯队结构合理的优秀人才队伍。现有教职工1400余名，专任教师1070余名，其中高级职称470余名，具有博士学位教师约占45%，具有6个月以上海外学术经历教师占30%以上，双师双能型教师占42%以上；全国优秀教师、享受国务院特殊津贴等18人，国家级知名专家等国家级人才7人，省级知名专家等省部级人才130余人。\n"
            +"\t\t\t\t学校现有省一流学科6个、省重点实验室等省部级以上学科科研平台15个。近年来获得国家级科技计划项目、国家基金100余项目，省部级及以上科研奖项30余项，其中国家级科学技术奖2项，与企业共建研发机构及科技成果转移转化中心100余个，发表论文4300余篇，其中三大索引和人文社科权威级学术期刊论文1000余篇。\n"
            +"\t\t\t\t长期以来，学校致力于建设“德国模式 中国特色”的新型现代应用型大学，秉承“崇德、尚用、求真、创新”之校训，坚持“学以致用、全面发展”的育人理念，以打造“卓越工程师的摇篮”为目标，积极开展教育教学改革与实践，培养具有实践能力、创新精神、国际素养和社会责任的高素质应用型人才。";
    private TextView tv;
    private ImageView backIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        tv = (TextView)findViewById(R.id.tv_intro);
        backIv = findViewById(R.id.iv_back);
        tv.setSingleLine(false);
        //tv.setMaxLines(20);
        tv.setText(text);
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();   //销毁当前的activity
            }
        });
    }
}
