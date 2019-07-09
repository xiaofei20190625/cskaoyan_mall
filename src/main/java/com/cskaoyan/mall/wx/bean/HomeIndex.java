package com.cskaoyan.mall.wx.bean;

import com.cskaoyan.mall.wx.bean.Brand;
import com.cskaoyan.mall.admin.bean.Coupon;
import com.cskaoyan.mall.wx.bean.Groupon;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/9 Time 9:43
 */
public class HomeIndex {
    private List<Banner> banner;
    private List<Brand> brandList;
    private List<Channel> channel;
    private List<Coupon> couponList;
    private List<FloorGoods> floorGoodsList;
    private List<Groupon> grouponList;
    private List<HotGoods> hotGoodsList;
    private List<NewGoods> newGoodsList;
    private List<Topic> topicList;

    public HomeIndex() {
    }

    public List<Banner> getBanner() {
        return banner;
    }

    public void setBanner(List<Banner> banner) {
        this.banner = banner;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public List<Channel> getChannel() {
        return channel;
    }

    public void setChannel(List<Channel> channel) {
        this.channel = channel;
    }

    public List<Coupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<Coupon> couponList) {
        this.couponList = couponList;
    }

    public List<FloorGoods> getFloorGoodsList() {
        return floorGoodsList;
    }

    public void setFloorGoodsList(List<FloorGoods> floorGoodsList) {
        this.floorGoodsList = floorGoodsList;
    }

    public List<Groupon> getGrouponList() {
        return grouponList;
    }

    public void setGrouponList(List<Groupon> grouponList) {
        this.grouponList = grouponList;
    }

    public List<HotGoods> getHotGoodsList() {
        return hotGoodsList;
    }

    public void setHotGoodsList(List<HotGoods> hotGoodsList) {
        this.hotGoodsList = hotGoodsList;
    }

    public List<NewGoods> getNewGoodsList() {
        return newGoodsList;
    }

    public void setNewGoodsList(List<NewGoods> newGoodsList) {
        this.newGoodsList = newGoodsList;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }
}
