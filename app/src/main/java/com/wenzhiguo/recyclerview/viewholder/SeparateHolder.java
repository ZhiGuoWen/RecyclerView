package com.wenzhiguo.recyclerview.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wenzhiguo.recyclerview.R;

/**
 * Created by dell on 2017/3/21.
 * 单行 多行 单横 多横   优化
 */

public class SeparateHolder extends RecyclerView.ViewHolder{

    public final TextView mConnect;
    public SeparateHolder(View itemView) {
        super(itemView);
        mConnect = (TextView) itemView.findViewById(R.id.text_connect);
    }
}
