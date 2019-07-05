package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.mapper.CategoryMapper;
import com.cskaoyan.mall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public int queryPidById(int id) {
        return categoryMapper.queryPidById(id);
    }
}
