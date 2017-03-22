package com.wenzhiguo.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import com.wenzhiguo.recyclerview.adapter.MyAdapter;
import com.wenzhiguo.recyclerview.bean.Bean;

import java.util.ArrayList;

/**
 * checkBox单选和反选  计算总价格
 */
public class ListViewActivity extends AppCompatActivity implements AbsListView.OnScrollListener {

    //如果在设置数据里面new出来，则刷新没有效果，必须全局
    private ArrayList<Bean> list = new ArrayList<>();
    private ListView mListView;
    private TextView mSum;
    private MyAdapter myAdapter;
    private int index = 1;
    private int shuliang = 30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        //控件
        initView();
        //添加数据
        initData();
        //适配器
        myAdapter = new MyAdapter(this, list);
        mListView.setAdapter(myAdapter);
        //mListView滑动最底部加载数据
        mListView.setOnScrollListener(this);
    }
    //数据
    private void initData() {
        for (int i = index; i < shuliang + index; i++) {
            list.add(new Bean("商品" + i, i, i));
        }
    }
    //控件
    private void initView() {
        mListView = (ListView) findViewById(R.id.listview);
        mSum = (TextView) findViewById(R.id.tv_sum);
    }
    //反选
    public void CheckNnow(View view) {
        for (int i = 0; i < list.size(); i++) {
            //从集合里面拿出是否选中状态，如果是没选中就给设置选中，否则就给设置没选中
            list.get(i).setCheck(!list.get(i).isCheck());
        }
        //刷新适配器
        myAdapter.notifyDataSetChanged();
        //再计算价格
        setPrice();
    }
    //全选
    public void CheckAll(View view) {
        for (int i = 0; i < list.size(); i++) {
            //从集合里面拿出是否选中状态，如果是没选中就给设置选中，否则就给设置没选中
            list.get(i).setCheck(true);
        }
        //刷新适配器
        myAdapter.notifyDataSetChanged();
        //再计算价格
        setPrice();
    }
    //计算价格
    public void setPrice() {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            //从集合里面拿出是否选中状态，如何选中就计算
            boolean check = list.get(i).isCheck();
            if (check){
                sum = sum + list.get(i).getCount()*list.get(i).getPrice();
            }
        }
        mSum.setText("总价格：￥"+sum);
    }
    //滑动底部加载更多数据
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        //判读是否是静止状态
        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE){
            //并且当前可以看到的条目的最后一个是集合的最后一个
            int lastVisiblePosition = view.getLastVisiblePosition();
            if (lastVisiblePosition == list.size()-1){
                //设置数据的条目总数量
                index = index + shuliang ;
                //从新加载数据
                initData();
                //刷新适配器
                myAdapter.notifyDataSetChanged();
            }
        }

    }
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {

    }
}
