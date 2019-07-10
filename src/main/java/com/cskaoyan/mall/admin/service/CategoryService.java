package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Category;
import com.cskaoyan.mall.admin.bean.CategoryL1;
import com.cskaoyan.mall.admin.bean.L1;
import com.cskaoyan.mall.wx.bean.Channel;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/4 Time 16:20
 */
public interface CategoryService {
    List<CategoryL1> getAllCategories();

    List<L1> getAllL1();

    int deleteCategoryById(Category category);

    Category createCategory(Category category);

    int updateCategory(Category category);

    Category getCategoryById(Integer id);

    int queryPidById(int id);

    List<Category> getCategoryListById(int brandId);

    List<Channel> getWxChannelList();

    List<Category> queryAllCategoriesL1();

    List<Category> queryAllCategoriesL2(Integer currentCategoryId);

    List<CategoryL1> getFilterCategoryList(String keyword);
}
