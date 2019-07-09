package com.cskaoyan.mall.wx.bean;

import com.cskaoyan.mall.admin.bean.*;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/9 Time 17:21
 */
public class GoodsDetailWx {
    private Attribute attribute;
    private BrandWx brand;
    private Comment comment;
    private GrouponWx groupon;
    private GoodsWx info;
    private Issue issue;
    private List<Product> productList;
    private String shareImage;
    private List<Specification> specificationList;
    private Boolean userHasCollect;

    public GoodsDetailWx() {
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public BrandWx getBrand() {
        return brand;
    }

    public void setBrand(BrandWx brand) {
        this.brand = brand;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public GrouponWx getGroupon() {
        return groupon;
    }

    public void setGroupon(GrouponWx groupon) {
        this.groupon = groupon;
    }

    public GoodsWx getInfo() {
        return info;
    }

    public void setInfo(GoodsWx info) {
        this.info = info;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
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

    public List<Specification> getSpecificationList() {
        return specificationList;
    }

    public void setSpecificationList(List<Specification> specificationList) {
        this.specificationList = specificationList;
    }

    public Boolean getUserHasCollect() {
        return userHasCollect;
    }

    public void setUserHasCollect(Boolean userHasCollect) {
        this.userHasCollect = userHasCollect;
    }
}
