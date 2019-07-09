package com.cskaoyan.mall.wx.vo;

/**
 * @author Alex_Cheng
 * @date 2019/7/9 10:54
 * @Description TODO
 */
public class TopicCountVO<T> {
    int  count  ;
    T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public TopicCountVO(int count, T data) {
        this.count = count;
        this.data = data;
    }

    public TopicCountVO() {
    }
}
