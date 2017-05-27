package com.wenzhiguo.recyclerview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wenzhiguo.recyclerview.R;
import com.wenzhiguo.recyclerview.onclick.RecyclerMoreOnClickListent;
import com.wenzhiguo.recyclerview.viewholder.WaterFallHolder;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by dell on 2017/3/21.
 * 瀑布流适配器,点击事件和动画效果移动交换和删除
 */

public class WaterFallAdapter extends RecyclerView.Adapter<WaterFallHolder> {

    private final ArrayList<String> list;
    private final Context context;
    private ArrayList<Integer> listHeight;
    private RecyclerMoreOnClickListent onItemClick;

    public WaterFallAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
        listHeight = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listHeight.add((int)(100+155*Math.random()));
        }
    }
    //寻找控件，给holder发送过去并返回
    @Override
    public WaterFallHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        WaterFallHolder waterFallHolder = new WaterFallHolder(inflate);
        return waterFallHolder;
    }
    //监听事件接口
    public void setOnItemClick(RecyclerMoreOnClickListent clickListent){
        this.onItemClick = clickListent;
    }
    @Override
    public void onBindViewHolder(WaterFallHolder holder, final int position) {
        //设置条目的高度随机
        ViewGroup.LayoutParams layoutParams = holder.mContext.getLayoutParams();
        layoutParams.height = listHeight.get(position);
        holder.mContext.setLayoutParams(layoutParams);
        //随机颜色背景
        holder.mContext.setBackgroundColor(Color.rgb
                (listHeight.get(position),listHeight.get(position),listHeight.get(position)));
        //监听点击事件
        holder.mContext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClick != null){
                    onItemClick.setOnItemClickListent(position);
                }
            }
        });
        //监听长恩事件
        holder.mContext.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemClick != null){
                    onItemClick.setOnLongItemClickListent(position);
                }
                return true;
            }
        });
        //赋值
        holder.mContext.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    /*控件移除交换位置
    onMove方法是拖拽的回调，参数viewHolder是拖动的Item，
    target是拖动的目标位置的Item,该方法如果返回true表示切换了位置，反之返回false。
     */
    public void onMove(int oldPosition, int newPosition) {
        //交换数据
        Collections.swap(list,oldPosition,newPosition);
        //刷新适配器--
        this.notifyItemMoved(oldPosition,newPosition);
    }
    //删除
    public void onDelete(int adapterPosition) {
        //从集合里删除
        list.remove(adapterPosition);
        //刷新适配器
        this.notifyItemRemoved(adapterPosition);
    }
}
