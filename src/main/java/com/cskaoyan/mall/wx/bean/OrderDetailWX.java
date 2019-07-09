package com.cskaoyan.mall.wx.bean;

import java.util.List;

public class OrderDetailWX {
    List orderGoods;

    List orderInfo;

    public List getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List orderGoods) {
        this.orderGoods = orderGoods;
    }

    public List getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(List orderInfo) {
        this.orderInfo = orderInfo;
    }
}
