package com.cskaoyan.mall.bean;

import java.util.List;

public class CategorySpecific {
    private int value;

    private String label;

    List<SpecificItem>  children;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<SpecificItem> getChildren() {
        return children;
    }

    public void setChildren(List<SpecificItem> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "CategorySpecific{" +
                "value=" + value +
                ", label='" + label + '\'' +
                ", children=" + children +
                '}';
    }
}