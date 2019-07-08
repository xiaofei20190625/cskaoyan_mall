package com.cskaoyan.mall.admin.vo;

import java.util.List;

public class SysPermissionVO<T> {
    List<T> children;
    String id;
    String label;

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
