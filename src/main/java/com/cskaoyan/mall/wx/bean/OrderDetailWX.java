package com.cskaoyan.mall.wx.bean;

import java.util.List;

public class OrderDetailWX {
    List orderGoods;

    OrderInfo orderInfo;

    public List getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List orderGoods) {
        this.orderGoods = orderGoods;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }
}
