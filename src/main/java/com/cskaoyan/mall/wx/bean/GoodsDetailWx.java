package com.cskaoyan.mall.wx.bean;

import com.cskaoyan.mall.admin.bean.*;

import java.util.List;
import java.util.Map;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/9 Time 17:21
 */
public class GoodsDetailWx {
    private List<Attribute> attribute;
    private Brand brand;
    private Map<String,Object> comment;
    private List<Groupon> groupon;
    private Goods info;
    private List<Issue> issue;
    private List<Product> productList;
    private String shareImage;
    private List<SpecificationWx> specificationList;
    private Integer userHasCollect;

    public GoodsDetailWx() {
    }

    public List<Attribute> getAttribute() {
        return attribute;
    }

    public void setAttribute(List<Attribute> attribute) {
        this.attribute = attribute;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Map<String,Object> getComment() {
        return comment;
    }

    public void setComment(Map<String,Object> comment) {
        this.comment = comment;
    }

    public List<Groupon> getGroupon() {
        return groupon;
    }

    public void setGroupon(List<Groupon> groupon) {
        this.groupon = groupon;
    }

    public Goods getInfo() {
        return info;
    }

    public void setInfo(Goods info) {
        this.info = info;
    }

    public List<Issue> getIssue() {
        return issue;
    }

    public void setIssue(List<Issue> issue) {
        this.issue = issue;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getShareImage() {
        return shareImage;
    }

    public void setShareImage(String shareImage) {
        this.shareImage = shareImage;
    }

    public List<SpecificationWx> getSpecificationList() {
        return specificationList;
    }

    public void setSpecificationList(List<SpecificationWx> specificationList) {
        this.specificationList = specificationList;
    }

    public Integer getUserHasCollect() {
        return userHasCollect;
    }

    public void setUserHasCollect(Integer userHasCollect) {
        this.userHasCollect = userHasCollect;
    }
}
