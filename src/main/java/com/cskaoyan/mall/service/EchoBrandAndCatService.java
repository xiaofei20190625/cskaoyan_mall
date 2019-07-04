package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.CategorySpecific;
import com.cskaoyan.mall.bean.SpecificItem;

import java.util.List;

public interface EchoBrandAndCatService {
    List<SpecificItem> echoBrand();

    List<SpecificItem>  getCatchildrenByPid(String pid);

    List<CategorySpecific> echoCategory();
}
