package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.CategorySpecific;
import com.cskaoyan.mall.admin.bean.SpecificItem;

import java.util.List;

public interface EchoBrandAndCatService {
    List<SpecificItem> echoBrand();

    List<SpecificItem>  getCatchildrenByPid(String pid);

    List<CategorySpecific> echoCategory();
}
