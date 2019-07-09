package com.cskaoyan.mall.wx.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/9 Time 11:22
 */
public class Goods {
    private String brief;
    private Double counterPrice;
    private Integer id;
    @JsonProperty("isHot")
    private Boolean isHot;
    @JsonProperty("isNew")
    private Boolean isNew;
    private String name;
    private String picUrl;
    private Double retailPrice;

    public Goods() {
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
}
