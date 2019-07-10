package com.cskaoyan.mall.wx.bean;

import com.cskaoyan.mall.admin.bean.Groupon;
import com.cskaoyan.mall.admin.bean.GrouponRules;

import java.util.List;

/**
 * @author Alex_Cheng
 * @date 2019/7/10 12:49
 * @Description TODO
 */
public class GrouponDetail {
    Creator creator ;

    Groupon groupon;

    List<Joiners> joiners;

    int linkGrouponId;

    String[] orderGoods;

    OrderInfo orderInfo;

    GrouponRules rules;

    public GrouponDetail() {
    }

    public GrouponDetail(Creator creator, Groupon groupon, List<Joiners> joiners, int linkGrouponId, String[] orderGoods, OrderInfo orderInfo, GrouponRules rules) {
        this.creator = creator;
        this.groupon = groupon;
        this.joiners = joiners;
        this.linkGrouponId = linkGrouponId;
        this.orderGoods = orderGoods;
        this.orderInfo = orderInfo;
        this.rules = rules;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public Groupon getGroupon() {
        return groupon;
    }

    public void setGroupon(Groupon groupon) {
        this.groupon = groupon;
    }

    public List<Joiners> getJoiners() {
        return joiners;
    }

    public void setJoiners(List<Joiners> joiners) {
        this.joiners = joiners;
    }

    public int getLinkGrouponId() {
        return linkGrouponId;
    }

    public void setLinkGrouponId(int linkGrouponId) {
        this.linkGrouponId = linkGrouponId;
    }

    public String[] getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(String[] orderGoods) {
        this.orderGoods = orderGoods;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public GrouponRules getRules() {
        return rules;
    }

    public void setRules(GrouponRules rules) {
        this.rules = rules;
    }
}
