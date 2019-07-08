package com.cskaoyan.mall.admin.bean;

import java.util.List;

public class SysPermission2 {
    List<SysPermission1> children;
    String id;
    String label;

    public List<SysPermission1> getChildren() {
        return children;
    }

    public void setChildren(List<SysPermission1> children) {
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
