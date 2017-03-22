package com.wenzhiguo.recyclerview;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import com.wenzhiguo.recyclerview.adapter.WaterFallAdapter;
import com.wenzhiguo.recyclerview.bangzhulei.ItemTouchCallBack;
import com.wenzhiguo.recyclerview.onclick.RecyclerMoreOnClickListent;

import java.util.ArrayList;

/**
 *能够实现刷新，条目拖拽实现动画，左右移动删除
 */
public class AnimationDeleteActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView mRecycler;
    private DividerItemDecoration dividerItemDecoration;
    private ArrayList<String> dataList;
    private SwipeRefreshLayout mSwipeFresh;
    private Handler handler = new Handler();
    private WaterFallAdapter waterFallAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        //找控件
        mRecycler = (RecyclerView) findViewById(R.id.delete_recycler);
        mSwipeFresh = (SwipeRefreshLayout) findViewById(R.id.swipe);
        ///添加数据
        initData();
        //分割线
        dividerItemDecoration = new DividerItemDecoration(this, RecyclerView.VERTICAL);
        mRecycler.addItemDecoration(dividerItemDecoration);
        //设置管理者模式
        mRecycler.setLayoutManager(new GridLayoutManager(this,3,RecyclerView.VERTICAL,false));
        //适配器
        waterFallAdapter = new WaterFallAdapter(this, dataList);
        mRecycler.setAdapter(waterFallAdapter);
        //条目监听
        waterFallAdapter.setOnItemClick(new RecyclerMoreOnClickListent() {
            @Override
            public void setOnItemClickListent(int position) {
                Toast.makeText(AnimationDeleteActivity.this, "点击了"+position,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void setOnLongItemClickListent(int position) {
                Toast.makeText(AnimationDeleteActivity.this, "长恩了"+position,
                        Toast.LENGTH_SHORT).show();
            }
        });
        //设置帮助类
        ItemTouchCallBack itemTouchCallBack = new ItemTouchCallBack();
        //设置帮助类
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchCallBack);
        //进行关联
        itemTouchHelper.attachToRecyclerView(mRecycler);
        itemTouchCallBack.setAdapter(waterFallAdapter);
        //设置颜色
        mSwipeFresh.setColorSchemeColors(Color.RED,Color.GRAY,Color.GREEN);
        //刷新
        mSwipeFresh.setOnRefreshListener(this);
    }
    //添加数据
    private void initData() {
        dataList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            dataList.add("条目" + i);
        }
    }
    //刷新
    @Override
    public void onRefresh() {
       handler.postDelayed(new Runnable() {
           @Override
           public void run() {
               //刷新的时候给集合添加一条数据并加载到指定的第一条
               dataList.add(0,"刷新一下"+Math.random());
               waterFallAdapter.notifyDataSetChanged();
               //隐藏  上面的控件
               mSwipeFresh.setRefreshing(false);
           }
       }, 2000);
    }
}
