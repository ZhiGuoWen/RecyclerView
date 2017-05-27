package com.wenzhiguo.recyclerview.bangzhulei;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.wenzhiguo.recyclerview.adapter.WaterFallAdapter;

/**
 * Created by dell on 2017/3/21.
 * 帮助类
 */

public class ItemTouchCallBack extends ItemTouchHelper.Callback {
    /*ItemTouchHelper.UP 滑动拖拽向上方向
    ItemTouchHelper.DOWN 向下
    ItemTouchHelper.LEFT 向左
    ItemTouchHelper.RIGHT 向右
    ItemTouchHelper.START 依赖布局方向的水平开始方向
    ItemTouchHelper.END 依赖布局方向的水平结束方向*/

    private WaterFallAdapter waterFallAdapter;
    /*该方法返回一个整数，用来指定拖拽和滑动在哪个方向是被允许的。
    在其中使用makeMovementFlags(int dragFlags, int swipeFlags)返回，
    该方法第一个参数用来指定拖动，第二个参数用来指定滑动。*/
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //获取滑动的左右标记删除
        int swipeFlag= ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        //获取滑动的上下左右能够移动
        int dragFlag = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        return makeMovementFlags(dragFlag,swipeFlag);
    }
    //交换位置颜色  第二个参数是一开始item的坐位  第三个参数是结束时的item的坐位
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        //移动的时候
        int oldPosition = viewHolder.getAdapterPosition();
        int newPosition = target.getAdapterPosition();
        //交换位置-交换集合，刷新适配器
        waterFallAdapter.onMove(oldPosition,newPosition);
        return true;
    }
    //传给适配器实现集合移动和移除
    public void setAdapter(WaterFallAdapter waterFallAdapter){
        this.waterFallAdapter = waterFallAdapter;
    }
    //onSwiped方法为Item滑动回调，viewHolder为滑动的item，direction为滑动的方向。
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        //移除
        waterFallAdapter.onDelete(viewHolder.getAdapterPosition());
    }
}
