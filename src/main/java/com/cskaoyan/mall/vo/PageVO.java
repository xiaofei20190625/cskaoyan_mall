package com.cskaoyan.mall.vo;

import java.util.List;

public class PageVO<T> {
    long total;

    List<T> items;

    public PageVO() {
    }

    public PageVO(long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
