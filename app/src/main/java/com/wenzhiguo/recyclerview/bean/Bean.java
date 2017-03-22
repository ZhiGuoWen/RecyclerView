package com.wenzhiguo.recyclerview.bean;

/**
 * Created by dell on 2017/3/22.
 * checkBox数据bean
 */

public class Bean {
    private String title;
    private int count;
    private int price;
    private boolean isCheck;

    public Bean() {
    }

    public Bean(String title, int count, int price) {
        this.title = title;
        this.count = count;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
