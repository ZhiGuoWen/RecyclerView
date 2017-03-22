package com.wenzhiguo.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * 设置五个textview控件点击跳转到具体内容
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        initView();
    }

    private void initView() {
        TextView mSeparate = (TextView) findViewById(R.id.text1);
        TextView mWaterfall = (TextView) findViewById(R.id.text2);
        TextView mBull = (TextView) findViewById(R.id.text3);
        TextView mDelete = (TextView) findViewById(R.id.text4);
        TextView mXlistView = (TextView) findViewById(R.id.text5);
        //监听事件
        mSeparate.setOnClickListener(this);
        mWaterfall.setOnClickListener(this);
        mBull.setOnClickListener(this);
        mDelete.setOnClickListener(this);
        mXlistView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text1:
                //单行 多行 单横 多横
                setIntent(SeparateActivity.class);
                break;
            case R.id.text2:
                //瀑布流  瀑布流动画
                setIntent(WaterFallActivity.class);
                break;
            case R.id.text3:
                //多条目效果展示
                setIntent(BullActivity.class);
                break;
            case R.id.text4:
                //条目拖拽删除
                setIntent(AnimationDeleteActivity.class);
                break;
            case R.id.text5:
                //购物车
                setIntent(ListViewActivity.class);
                break;
        }
    }

    public void setIntent(Class c) {
        Intent intent = new Intent(this,c);
        startActivity(intent);
    }
}
