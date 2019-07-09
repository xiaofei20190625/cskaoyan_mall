package com.cskaoyan.mall.wx.bean;



/**
 * Created by IceFloe_Rot
 * Date 2019/7/9 Time 11:15
 */
public class Brand {
    private String desc;
    private Double floorPrice;
    private String id;
    private String name;
    private String picUrl;

    public Brand() {
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(Double floorPrice) {
        this.floorPrice = floorPrice;
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
