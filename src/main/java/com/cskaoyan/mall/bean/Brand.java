package com.cskaoyan.mall.bean;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
public class Brand {
    Integer id;
    String name;
    String desc;
    String picUrl;
    Integer sortOrder;
    Double floorPrice;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    Date addTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    Date updateTime;
    Boolean deleted;

    public Brand() {
    }

    public Brand(Integer id, String name, String desc, String picUrl, Integer sortOrder, Double floorPrice, Date addTime, Date updateTime, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.picUrl = picUrl;
        this.sortOrder = sortOrder;
        this.floorPrice = floorPrice;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Double getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(Double floorPrice) {
        this.floorPrice = floorPrice;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}