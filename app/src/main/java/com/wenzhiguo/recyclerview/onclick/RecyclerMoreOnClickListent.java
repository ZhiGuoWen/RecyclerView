package com.wenzhiguo.recyclerview.onclick;

/**
 * Created by dell on 2017/3/21.
 * 定义两个抽象类，一个长恩点击，一个监听事件
 */

public interface RecyclerMoreOnClickListent {
    public void setOnItemClickListent(int position);
    public void setOnLongItemClickListent(int position);
}
