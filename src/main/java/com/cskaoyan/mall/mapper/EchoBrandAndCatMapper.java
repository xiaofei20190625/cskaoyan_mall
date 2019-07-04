package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CategorySpecific;
import com.cskaoyan.mall.bean.SpecificItem;

import java.util.List;

public interface EchoBrandAndCatMapper {
    List<SpecificItem> echoBrand();

    List<SpecificItem>  getCatchildrenByPid(String pid);

    List<CategorySpecific> echoCategory();
}
