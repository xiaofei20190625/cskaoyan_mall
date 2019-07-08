package com.cskaoyan.mall.wx.vo;

import java.util.List;

public class FootprintVO {
    List footprintList;

    Long totalPages;

    public List getFootprintList() {
        return footprintList;
    }

    public void setFootprintList(List footprintList) {
        this.footprintList = footprintList;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }
}
