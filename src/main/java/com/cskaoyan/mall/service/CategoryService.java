package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Category;
import com.cskaoyan.mall.bean.CategoryL1;
import com.cskaoyan.mall.bean.L1;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/4 Time 16:20
 */
public interface CategoryService {
    List<CategoryL1> getAllCategories();

    List<L1> getAllL1();

    int deleteCategoryById(Category category);
}
