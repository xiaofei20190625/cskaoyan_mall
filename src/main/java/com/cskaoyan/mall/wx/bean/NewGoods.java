package com.cskaoyan.mall.wx.bean;



/**
 * Created by IceFloe_Rot
 * Date 2019/7/9 Time 11:09
 */
public class NewGoods {
    private String brief;
    private Double counterPrice;
    private String id;
    private Boolean isHot;
    private Boolean isNew;
    private String name;
    private String picUrl;
    private Double retailPrice;

    public NewGoods() {
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Double getCounterPrice() {
        return counterPrice;
    }

    public void setCounterPrice(Double counterPrice) {
        this.counterPrice = counterPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getHot() {
        return isHot;
    }

    public void setHot(Boolean hot) {
        isHot = hot;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
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

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }
}
