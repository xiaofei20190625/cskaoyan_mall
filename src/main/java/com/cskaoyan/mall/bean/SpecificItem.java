package com.cskaoyan.mall.bean;

public class SpecificItem {
    int value;

    String label;

    public SpecificItem() {
    }

    public SpecificItem(int value, String label) {
        this.value = value;
        this.label = label;
    }

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
}
