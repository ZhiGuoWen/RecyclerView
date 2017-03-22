package com.wenzhiguo.recyclerview.viewholder;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wenzhiguo.recyclerview.R;

/**
 * Created by dell on 2017/3/22.
 * 多条目第一种类型
 */

public class BullTypeOne extends RecyclerView.ViewHolder {

    public  TextView connect;

    public BullTypeOne(View itemView) {
        super(itemView);
        connect = (TextView) itemView.findViewById(R.id.text_connect);
    }
    public void onBind(String s){
        connect.setText(s);
        connect.setTextColor(Color.RED);
    }
}
