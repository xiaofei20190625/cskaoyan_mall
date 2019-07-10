package com.cskaoyan.mall.admin.bean;

import java.math.BigDecimal;

/**
 * @author Alex_Cheng
 * @date 2019/7/9 12:00
 * @Description TODO
 */
public class GrouponAndGoods {
    GoodsToGroupon goods;

    double groupon_price;

    int groupon_member;

    public GrouponAndGoods(GoodsToGroupon goods, double groupon_price, int groupon_member) {
        this.goods = goods;
        this.groupon_price = groupon_price;
        this.groupon_member = groupon_member;
    }

    public GrouponAndGoods() {
    }

    public GoodsToGroupon getGoods() {
        return goods;
    }

    public void setGoods(GoodsToGroupon goods) {
        this.goods = goods;
    }

    public double getGroupon_price() {
        return groupon_price;
    }

    public void setGroupon_price(double groupon_price) {
        this.groupon_price = groupon_price;
    }

    public int getGroupon_member() {
        return groupon_member;
    }

    public void setGroupon_member(int groupon_member) {
        this.groupon_member = groupon_member;
    }
}
