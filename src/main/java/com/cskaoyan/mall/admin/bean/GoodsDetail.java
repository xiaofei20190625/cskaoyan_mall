
package com.cskaoyan.mall.admin.bean;

import java.util.List;

public class GoodsDetail {
    List<Attribute> attributes;

    int[] categoryIds;

    Goods goods;

    List<Product> products;

    List<Specification> specifications;

    public GoodsDetail() {
    }

    public GoodsDetail(List<Attribute> attributes, int[] categoryIds, Goods goods, List<Product> products, List<Specification> specifications) {
        this.attributes = attributes;
        this.categoryIds = categoryIds;
        this.goods = goods;
        this.products = products;
        this.specifications = specifications;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public int[] getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(int[] categoryIds) {
        this.categoryIds = categoryIds;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Specification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<Specification> specifications) {
        this.specifications = specifications;
    }


}
