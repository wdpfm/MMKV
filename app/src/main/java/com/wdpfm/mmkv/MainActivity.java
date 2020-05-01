package com.wdpfm.mmkv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.tencent.mmkv.MMKV;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MMKV.initialize(this);//初始化设定 MMKV 的根目录 这个必不可少
        MMKV kv = MMKV.defaultMMKV();//获取默认MMKV对象
        //给按钮加对象的省略方法 无需声明button对象 直接获取按钮


        boolean bValue = kv.decodeBool("live");//decode解码 从数据里取出关键字bool的值 这个"bool"的值是上一行添加的
        TextView t1=findViewById(R.id.edit1);
        t1.setText(bValue?"活着":"死了");//条件?是:否

        int iValue = kv.decodeInt("age");//decode解码 从数据里取出关键字bool的值 这个"bool"的值是上一行添加的
        TextView t2=findViewById(R.id.edit2);
        t2.setText(iValue+"");//条件?是:否

        String sValue = kv.decodeString("name");//decode解码 从数据里取出关键字bool的值 这个"bool"的值是上一行添加的
        TextView t3=findViewById(R.id.edit3);
        t3.setText(sValue);//条件?是:否

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MMKV kv = MMKV.defaultMMKV();//获取默认MMKV对象
                kv.encode("live", true);//encode的意思是编码 这个就是把这对关键字-值 存储
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MMKV kv = MMKV.defaultMMKV();//获取默认MMKV对象
                kv.encode("age", 11);//encode的意思是编码 这个就是把这对关键字-值 存储
                //这个出现的问题是不能setText为一个int  拼接一个空字符串进去就可以了
                //现在的操作是存储指定数据并 读取MMKV显示到界面 那怎么让app启动的时候读取呢
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MMKV kv = MMKV.defaultMMKV();//获取默认MMKV对象
                kv.encode("name", "pfm");//encode的意思是编码 这个就是把这对关键字-值 存
            }
        });


//
//        kv.encode("int", 1);//存int型
//        int iValue = kv.decodeInt("int");//这样取出来int的值就是1
//
//        kv.encode("string", "Hello from mmkv");//存字符串型
//        String str = kv.decodeString("string");//这样取出来string的值就是Hello from mmkv
//        //比sp简单 下面做个演示


    }
}
