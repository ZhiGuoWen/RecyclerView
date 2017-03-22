package com.wenzhiguo.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wenzhiguo.recyclerview.adapter.WaterFallAdapter;

import java.util.ArrayList;

/**
 * 瀑布流
 */
public class WaterFallActivity extends AppCompatActivity {

    private ArrayList<String> list;
    private DividerItemDecoration dividerItemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterfall);
        //控件
        RecyclerView mRecycler = (RecyclerView) findViewById(R.id.water_recycler);
        //添加数据
        initData();
        //分割线
        dividerItemDecoration = new DividerItemDecoration(this, RecyclerView.VERTICAL);
        mRecycler.addItemDecoration(dividerItemDecoration);
        //设置管理者模式
        mRecycler.setLayoutManager(new GridLayoutManager(this,3,RecyclerView.VERTICAL,false));
        WaterFallAdapter waterFallAdapter = new WaterFallAdapter(this, list);
        mRecycler.setAdapter(waterFallAdapter);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 1; i < 500; i++) {
            list.add("条目"+i);
        }
    }
}
