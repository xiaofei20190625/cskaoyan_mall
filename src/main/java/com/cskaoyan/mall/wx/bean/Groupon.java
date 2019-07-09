package com.cskaoyan.mall.wx.bean;

import com.cskaoyan.mall.wx.bean.Goods;


import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/9 Time 11:19
 */
public class Groupon {
    private Goods goods;
    private Integer grouponMember;
    private Double grouponPrice;

    public Groupon() {
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getGroupon_member() {
        return grouponMember;
    }

    public void setGroupon_member(Integer groupon_member) {
        this.grouponMember = groupon_member;
    }

    public Double getGroupon_price() {
        return grouponPrice;
    }

    public void setGroupon_price(Double groupon_price) {
        this.grouponPrice = groupon_price;
    }
}
