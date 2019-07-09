package com.cskaoyan.mall.wx.bean;

import com.cskaoyan.mall.wx.bean.Goods;


import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/9 Time 11:19
 */
public class Groupon {
    private List<Goods> goods;
    private Integer groupon_member;
    private Double groupon_price;

    public Groupon() {
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public Integer getGroupon_member() {
        return groupon_member;
    }

    public void setGroupon_member(Integer groupon_member) {
        this.groupon_member = groupon_member;
    }

    public Double getGroupon_price() {
        return groupon_price;
    }

    public void setGroupon_price(Double groupon_price) {
        this.groupon_price = groupon_price;
    }
}
