package com.cskaoyan.mall.wx.bean;

import com.cskaoyan.mall.admin.bean.Groupon;
import com.cskaoyan.mall.admin.bean.GrouponRules;

import java.math.BigDecimal;

/**
 * @author Alex_Cheng
 * @date 2019/7/9 23:03
 * @Description TODO
 */
public class GrouponMy {
    BigDecimal actualPrice;

    String creator;

    String[] goodsList;

    Groupon groupon;

    HandleOption handleOption;

    int id ;

    Boolean isCreator;

    int joinerCount ;

    int orderId;

    String orderSn;

    String orderStatusText;

    GrouponRules rules;

    public GrouponMy() {
    }

    public GrouponMy(BigDecimal actualPrice, String creator, String[] goodsList, Groupon groupon, HandleOption handleOption, int id, Boolean isCreator, int joinerCount, int orderId, String orderSn, String orderStatusText, GrouponRules rules) {
        this.actualPrice = actualPrice;
        this.creator = creator;
        this.goodsList = goodsList;
        this.groupon = groupon;
        this.handleOption = handleOption;
        this.id = id;
        this.isCreator = isCreator;
        this.joinerCount = joinerCount;
        this.orderId = orderId;
        this.orderSn = orderSn;
        this.orderStatusText = orderStatusText;
        this.rules = rules;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(Boolean creator) {
        isCreator = creator;
    }

    public int getJoinerCount() {
        return joinerCount;
    }

    public void setJoinerCount(int joinerCount) {
        this.joinerCount = joinerCount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
    }

    public GrouponRules getRules() {
        return rules;
    }

    public void setRules(GrouponRules rules) {
        this.rules = rules;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String[] getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(String[] goodsList) {
        this.goodsList = goodsList;
    }

    public Groupon getGroupon() {
        return groupon;
    }

    public void setGroupon(Groupon groupon) {
        this.groupon = groupon;
    }

    public HandleOption getHandleOption() {
        return handleOption;
    }

    public void setHandleOption(HandleOption handleOption) {
        this.handleOption = handleOption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
