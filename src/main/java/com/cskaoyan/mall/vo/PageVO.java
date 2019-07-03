package com.cskaoyan.mall.vo;

import java.util.List;

public class PageVO<T> {
    Long total;
    List<T> items;

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

    public PageVO(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }
}
