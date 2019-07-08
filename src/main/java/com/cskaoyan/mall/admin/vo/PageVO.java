package com.cskaoyan.mall.admin.vo;

import java.util.List;

public class PageVO<T> {
    Long total;

    List<T> items;

    public PageVO() {
    }

    public PageVO(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "PageVO{" +
                "total=" + total +
                ", items=" + items +
                '}';
    }
}
