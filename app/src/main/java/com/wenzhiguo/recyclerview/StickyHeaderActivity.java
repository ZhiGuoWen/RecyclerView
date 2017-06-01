package com.wenzhiguo.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wenzhiguo.recyclerview.adapter.TestAdapter;
import com.wenzhiguo.recyclerview.bean.GroupInfo;

import java.util.ArrayList;
import java.util.List;

public class StickyHeaderActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    List<String> data;
    TestAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stickyheader);
        mRecyclerView = (RecyclerView) findViewById(R.id.stickyheader_recyclerview);
        //加载数据
        initDatas();
        //适配器配置
        mAdapter = new TestAdapter(data);
        mRecyclerView.setAdapter(mAdapter);
        //Recyclerview的模式
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        //竖向显示
        layoutmanager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutmanager);

        mRecyclerView.addItemDecoration(new StickySectionDecoration(this,new StickySectionDecoration.GroupInfoCallback() {
            @Override
            public GroupInfo getGroupInfo(int position) {

                /*
      分组逻辑，这里为了测试每5个数据为一组。大家可以在实际开发中替换为真正的需求逻辑
                 */
                int groupId = position / 5;
                int index = position % 5;
                GroupInfo groupInfo = new GroupInfo(groupId,groupId+"");
                groupInfo.setGroupLength(5);
                groupInfo.setPosition(index);
                return groupInfo;
            }
        }));
    }

    /**初始化测试数据*/
    private void initDatas() {
        data = new ArrayList<>();
        for (int i = 0; i < 56;i++) {
            data.add(i+" test ");
        }
    }
}
