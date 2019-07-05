package com.cskaoyan.mall.bean;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/5 Time 17:17
 */
public class OrderDetail {
    private Order order;
    private UserVip userVip;
    private List<Goods> orderGoods;

    public OrderDetail() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public UserVip getUserVip() {
        return userVip;
    }

    public void setUserVip(UserVip userVip) {
        this.userVip = userVip;
    }

    public List<Goods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<Goods> orderGoods) {
        this.orderGoods = orderGoods;
    }
}
