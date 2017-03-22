package com.wenzhiguo.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wenzhiguo.recyclerview.R;
import com.wenzhiguo.recyclerview.viewholder.BullTypeOne;
import com.wenzhiguo.recyclerview.viewholder.BullTypeThere;
import com.wenzhiguo.recyclerview.viewholder.BullTypeTwo;

import java.util.ArrayList;

/**
 * Created by dell on 2017/3/22.
 * 多条目适配器
 */

public class BullAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final ArrayList<String> dataList;
    private final Context context;
    private final int TYPE1 = 1;
    private final int TYPE2 = 2;
    private final int TYPE3 = 3;

    //有参构造
    public BullAdapter(Context context, ArrayList<String> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case 1:
                View inflate1 = LayoutInflater.from(context).inflate
                        (R.layout.recycler_item, parent, false);
                viewHolder = new BullTypeOne(inflate1);
                break;
            case 2:
                View inflate2 = LayoutInflater.from(context).inflate
                        (R.layout.recycler_item, parent, false);
                viewHolder = new BullTypeTwo(inflate2);
                break;
            case 3:
                View inflate3 = LayoutInflater.from(context).inflate
                        (R.layout.recycler_item, parent, false);
                viewHolder = new BullTypeThere(inflate3);
                break;
        }
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        if (position < 10) {
            return TYPE1;
        } else if (position < 20&&position>=10) {
            return TYPE2;
        }
        return TYPE3;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case 1:
                ((BullTypeOne)holder).onBind(dataList.get(position));
                break;
            case 2:
                ((BullTypeTwo)holder).onBind(dataList.get(position));
                break;
            case 3:
                ((BullTypeThere)holder).onBind(dataList.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
