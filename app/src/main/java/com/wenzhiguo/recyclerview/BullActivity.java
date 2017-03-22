package com.wenzhiguo.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wenzhiguo.recyclerview.adapter.BullAdapter;

import java.util.ArrayList;

/**
 * 多条目
 */
public class BullActivity extends AppCompatActivity {

    private RecyclerView mRecycler;
    private ArrayList<String> dataList;
    private DividerItemDecoration dividerItemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bull);
        //找控件
        mRecycler = (RecyclerView) findViewById(R.id.bull_recyclerview);
        ///添加数据
        initData();
        //分割线
        dividerItemDecoration = new DividerItemDecoration(this, RecyclerView.VERTICAL);
        mRecycler.addItemDecoration(dividerItemDecoration);
        //设置管理者模式
        mRecycler.setLayoutManager(new GridLayoutManager(this,RecyclerView.VERTICAL));
        //适配器
        BullAdapter bullAdapter = new BullAdapter(this,dataList);
        mRecycler.setAdapter(bullAdapter);
    }

    //添加数据
    private void initData() {
        dataList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if(i<10){
                dataList.add("类型1////" + i);
            }else if(i>10&&i<20){
                dataList.add("类型2----"+i);
            }
            dataList.add("类型3****"+i);
        }
    }
}
