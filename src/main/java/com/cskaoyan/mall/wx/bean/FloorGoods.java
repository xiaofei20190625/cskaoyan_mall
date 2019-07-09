package com.cskaoyan.mall.wx.bean;


import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/9 Time 10:39
 */
public class FloorGoods {
    private String id;
    private String name;
    private List<Goods> goodsList;

    public FloorGoods() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
