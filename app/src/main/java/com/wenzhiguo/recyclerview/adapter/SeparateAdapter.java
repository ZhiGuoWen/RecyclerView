package com.wenzhiguo.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wenzhiguo.recyclerview.R;
import com.wenzhiguo.recyclerview.viewholder.SeparateHolder;

import java.util.ArrayList;

/**
 * Created by dell on 2017/3/21.
 * 单行 多行 单横 多横  适配器
 */

public class SeparateAdapter extends RecyclerView.Adapter<SeparateHolder> {
    private final Context context;
    private final ArrayList<String> list;
    //有参构造
    public SeparateAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }
    //找xml，然后给holder传参并返回出去
    @Override
    public SeparateHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        SeparateHolder separateHolder = new SeparateHolder(inflate);
        return separateHolder;
    }
    //给控件赋值
    @Override
    public void onBindViewHolder(SeparateHolder holder, int position) {
        holder.mConnect.setText(list.get(position));
    }
    //返回集合的数量
    @Override
    public int getItemCount() {
        return list.size();
    }
}
