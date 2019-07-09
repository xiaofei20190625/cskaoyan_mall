package com.cskaoyan.mall.wx.vo;

/**
 * @author Alex_Cheng
 * @date 2019/7/9 16:21
 * @Description TODO
 */
public class TopicGoodsVo<T> {
    String[] goods;
    T  data ;

    public String[] getGoods() {
        return goods;
    }

    public void setGoods(String[] goods) {
        this.goods = goods;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TopicGoodsVo(String[] goods, T data) {
        this.goods = goods;
        this.data = data;
    }

    public TopicGoodsVo() {
    }
}
