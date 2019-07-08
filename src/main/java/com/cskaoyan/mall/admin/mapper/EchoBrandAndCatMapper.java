package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CategorySpecific;
import com.cskaoyan.mall.admin.bean.SpecificItem;

import java.util.List;

public interface EchoBrandAndCatMapper {
    List<SpecificItem> echoBrand();

    List<SpecificItem>  getCatchildrenByPid(String pid);

    List<CategorySpecific> echoCategory();
}
