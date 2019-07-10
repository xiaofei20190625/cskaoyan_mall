package com.cskaoyan.mall.wx.vo;

/**
 * @author Alex_Cheng
 * @date 2019/7/9 21:48
 * @Description TODO
 */
public class ListVo<T> {
    T data ;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListVo(T data) {
        this.data = data;
    }

    public ListVo() {
    }
}
