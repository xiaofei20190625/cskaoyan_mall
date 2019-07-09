package com.cskaoyan.mall.wx.vo;

import java.util.List;

public class DataListVO {
    Long count;

    List data;

    int totalPages;


    public DataListVO() {
    }

    public DataListVO(Long count, List data, int totalPages) {
        this.count = count;
        this.data = data;
        this.totalPages = totalPages;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
