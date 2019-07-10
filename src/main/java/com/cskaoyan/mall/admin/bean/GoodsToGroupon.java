package com.cskaoyan.mall.admin.bean;

/**
 * @author Alex_Cheng
 * @date 2019/7/9 21:37
 * @Description TODO
 */
public class GoodsToGroupon {
    String brief;

    double counterPrice;

    int id;

    String name;

    String picUrl;

    double retailPrice;

    public GoodsToGroupon(String brief, double counterPrice, int id, String name, String picUrl, double retailPrice) {
        this.brief = brief;
        this.counterPrice = counterPrice;
        this.id = id;
        this.name = name;
        this.picUrl = picUrl;
        this.retailPrice = retailPrice;
    }

    public GoodsToGroupon() {
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public double getCounterPrice() {
        return counterPrice;
    }

    public void setCounterPrice(double counterPrice) {
        this.counterPrice = counterPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }
}
