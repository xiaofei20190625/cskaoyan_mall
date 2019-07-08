package com.cskaoyan.mall.admin.vo;

import java.util.List;

public class StatisticalVO<T> {

    List columns;
    List<T> rows;

    public List getColumns() {
        return columns;
    }

    public void setColumns(List columns) {
        this.columns = columns;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
