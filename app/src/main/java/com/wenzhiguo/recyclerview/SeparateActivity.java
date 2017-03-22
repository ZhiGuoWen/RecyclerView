package com.wenzhiguo.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.wenzhiguo.recyclerview.adapter.SeparateAdapter;

import java.util.ArrayList;

/**
 * 单行 多行 单横 多横
 */
public class SeparateActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<String> list;
    private RecyclerView mRecycler;
    private SeparateAdapter separateAdapter;
    private DividerItemDecoration dividerItemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_separate);
        //找空件
        initView();
        //设置数据
        initData();
        //设置管理模式
        mRecycler.setLayoutManager(new LinearLayoutManager
                (this,LinearLayoutManager.VERTICAL,false));
        //分割线
        dividerItemDecoration = new DividerItemDecoration(this, RecyclerView.VERTICAL);
        mRecycler.addItemDecoration(dividerItemDecoration);
        //适配器
        separateAdapter = new SeparateAdapter(this,list);
        mRecycler.setAdapter(separateAdapter);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            list.add("条目" + i);
        }
    }

    private void initView() {
        //单行 多行 单横 多横
        Button mLessVertical = (Button) findViewById(R.id.lessvertical);
        Button mMoreVertical = (Button) findViewById(R.id.morevertical);
        Button mLessHorizontal = (Button) findViewById(R.id.lesshorizontal);
        Button mMoreHorizontal = (Button) findViewById(R.id.morehorizontal);
        mRecycler = (RecyclerView) findViewById(R.id.separate_recycler);

        mLessHorizontal.setOnClickListener(this);
        mLessVertical.setOnClickListener(this);
        mMoreHorizontal.setOnClickListener(this);
        mMoreVertical.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lessvertical:
                //单行
                //设置管理模式
                mRecycler.setLayoutManager(new LinearLayoutManager
                        (this,RecyclerView.VERTICAL,false));
                separateAdapter.notifyDataSetChanged();
                break;
            case R.id.morevertical:
                //多行
                //设置管理模式  3行
                mRecycler.setLayoutManager(new GridLayoutManager(this,3));
                separateAdapter.notifyDataSetChanged();
                break;
            case R.id.lesshorizontal:
                //单横
                //设置管理模式
                mRecycler.setLayoutManager(new LinearLayoutManager
                        (this,RecyclerView.HORIZONTAL,false));
                separateAdapter.notifyDataSetChanged();
                break;

            case R.id.morehorizontal:
                //多横
                //设置管理模式
                mRecycler.setLayoutManager(new GridLayoutManager
                        (this,5,RecyclerView.HORIZONTAL,false));
                separateAdapter.notifyDataSetChanged();
                break;
        }
    }
}
