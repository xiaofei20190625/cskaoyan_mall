package com.cskaoyan.mall.wx.bean;

import com.cskaoyan.mall.admin.bean.Specification;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/10 Time 1:08
 */
public class SpecificationWx {
    private String name;
    private List<Specification> valueList;

    public SpecificationWx() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Specification> getValueList() {
        return valueList;
    }

    public void setValueList(List<Specification> valueList) {
        this.valueList = valueList;
    }
}
