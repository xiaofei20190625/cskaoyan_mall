package com.cskaoyan.mall.admin.bean;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/4 Time 16:18
 */
public class CategoryL1 extends Category{
    List<Category> children;

    public CategoryL1() {
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }
}
