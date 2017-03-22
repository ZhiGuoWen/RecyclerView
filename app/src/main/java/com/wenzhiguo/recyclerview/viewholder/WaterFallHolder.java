package com.wenzhiguo.recyclerview.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wenzhiguo.recyclerview.R;

/**
 * Created by dell on 2017/3/21.
 * 瀑布流优化
 */

public class WaterFallHolder extends RecyclerView.ViewHolder{

    public final TextView mContext;

    public WaterFallHolder(View itemView) {
        super(itemView);
        mContext = (TextView) itemView.findViewById(R.id.text_connect);
    }
}
