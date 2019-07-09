package com.cskaoyan.mall.wx.bean;


import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/9 Time 10:39
 */
public class FloorGoods {
    private Integer id;
    private String name;
    private List<GoodsWx> goodsList;

    public FloorGoods() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GoodsWx> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsWx> goodsList) {
        this.goodsList = goodsList;
    }
}
