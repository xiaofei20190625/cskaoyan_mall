package com.cskaoyan.mall.admin.bean;

import java.util.List;

public class EchoBrandAndCat {

    List<SpecificItem> brandList;

    List<CategorySpecific> categoryList;

    public EchoBrandAndCat() {
    }

    public EchoBrandAndCat(List<SpecificItem> brandList, List<CategorySpecific> categoryList) {
        this.brandList = brandList;
        this.categoryList = categoryList;
    }

    public List<SpecificItem> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<SpecificItem> brandList) {
        this.brandList = brandList;
    }

    public List<CategorySpecific> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategorySpecific> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "EchoBrandAndCat{" +
                "brandList=" + brandList +
                ", categoryList=" + categoryList +
                '}';
    }
}
