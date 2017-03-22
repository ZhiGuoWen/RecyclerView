package com.wenzhiguo.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.wenzhiguo.recyclerview.ListViewActivity;
import com.wenzhiguo.recyclerview.R;
import com.wenzhiguo.recyclerview.bean.Bean;

import java.util.ArrayList;

/**
 * Created by dell on 2017/3/22.
 * checkBox适配器
 */

public class MyAdapter extends BaseAdapter {

    private final ArrayList<Bean> list;
    private final Context context;

    public MyAdapter(Context context, ArrayList<Bean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null){
            vh = new ViewHolder();
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.listview_item,parent,false);
            vh.checkbox = (CheckBox)convertView.findViewById(R.id.checkBox);
            vh.count = (TextView)convertView.findViewById(R.id.tv_count);
            vh.price = (TextView)convertView.findViewById(R.id.tv_price);
            vh.title = (TextView)convertView.findViewById(R.id.tv_title);
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.title.setText(list.get(position).getTitle());
        vh.count.setText(list.get(position).getCount()+"数量");
        vh.price.setText("￥"+list.get(position).getPrice());

        vh.checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断一下当前是否选中
                boolean checked = vh.checkbox.isChecked();
                //设置给集合赋值
                list.get(position).setCheck(checked);
                //重新设置价格
                ListViewActivity listViewActivity =(ListViewActivity) context;
                listViewActivity.setPrice();
            }
        });
        //设置是否选中
        vh.checkbox.setChecked(list.get(position).isCheck());
        return convertView;
    }
    class ViewHolder{
        TextView title,count,price;
        CheckBox checkbox;
    }
}
