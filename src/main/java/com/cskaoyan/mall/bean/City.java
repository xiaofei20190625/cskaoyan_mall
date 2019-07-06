package com.cskaoyan.mall.bean;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/3 Time 17:15
 */
public class City extends Region{
    List<Discrict> children;

    public City() {
    }

    public City(Integer id, String name, Integer type, Integer code, List<Discrict> children) {
        super(id, name, type, code);
        this.children = children;
    }

    public List<Discrict> getChildren() {
        return children;
    }

    public void setChildren(List<Discrict> children) {
        this.children = children;
    }
}
