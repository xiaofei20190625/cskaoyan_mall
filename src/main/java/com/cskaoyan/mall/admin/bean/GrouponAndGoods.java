package com.cskaoyan.mall.admin.bean;

import java.math.BigDecimal;

/**
 * @author Alex_Cheng
 * @date 2019/7/9 12:00
 * @Description TODO
 */
public class GrouponAndGoods {
    String brief;

    double counterPrice;

    int id;

    String name;

    String picUrl;

    double retailPrice;

    double groupon_price;

    int groupon_member;

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

    public GrouponAndGoods(String brief, double counterPrice, int id, String name, String picUrl, double retailPrice, double groupon_price, int groupon_member) {
        this.brief = brief;
        this.counterPrice = counterPrice;
        this.id = id;
        this.name = name;
        this.picUrl = picUrl;
        this.retailPrice = retailPrice;
        this.groupon_price = groupon_price;
        this.groupon_member = groupon_member;
    }

    public GrouponAndGoods() {

    }
}
