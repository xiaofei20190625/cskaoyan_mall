package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.mapper.EchoBrandAndCatMapper;
import com.cskaoyan.mall.admin.service.EchoBrandAndCatService;
import com.cskaoyan.mall.admin.bean.CategorySpecific;
import com.cskaoyan.mall.admin.bean.SpecificItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EchoBrandAndCatServiceImpl implements EchoBrandAndCatService {
    @Autowired
    EchoBrandAndCatMapper echoBrandAndCatMapper;
    @Override
    public List<SpecificItem> echoBrand() {
        return echoBrandAndCatMapper.echoBrand();
    }

    @Override
    public List<SpecificItem> getCatchildrenByPid(String pid) {
        return echoBrandAndCatMapper.getCatchildrenByPid(pid);
    }

    @Override
    public List<CategorySpecific> echoCategory() {
        List<CategorySpecific> categorySpecifics = echoBrandAndCatMapper.echoCategory();
        for (CategorySpecific categorySpecific : categorySpecifics) {
            int pid = categorySpecific.getValue();
            List<SpecificItem> catchildrenByPid = echoBrandAndCatMapper.getCatchildrenByPid(Integer.toString(pid));
            categorySpecific.setChildren(catchildrenByPid);
        }
        return categorySpecifics;
    }
}
