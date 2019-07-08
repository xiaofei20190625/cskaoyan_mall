package com.cskaoyan.mall.admin.bean;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/3 Time 17:05
 */
public class Province extends Region{
    List<City> children;

    public Province() {
    }

    public List<City> getChildren() {
        return children;
    }

    public void setChildren(List<City> children) {
        this.children = children;
    }
}
