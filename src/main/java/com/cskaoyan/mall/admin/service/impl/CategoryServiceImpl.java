package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Category;
import com.cskaoyan.mall.admin.bean.CategoryL1;
import com.cskaoyan.mall.admin.bean.L1;
import com.cskaoyan.mall.admin.mapper.CategoryMapper;
import com.cskaoyan.mall.admin.service.CategoryService;
import com.cskaoyan.mall.wx.bean.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/4 Time 16:21
 */

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<CategoryL1> getAllCategories() {
        return categoryMapper.queryAllCategories();
    }

    @Override
    public List<L1> getAllL1() {
        return categoryMapper.queryAllL1();
    }

    @Override
    public int deleteCategoryById(Category category) {
        return categoryMapper.deleteCategory(category.getId());
    }

    @Override
    public Category createCategory(Category category) {
        int create = categoryMapper.insertSelective(category);
        if (create == 1){
            return category;
        }
        return null;
    }

    @Override
    public int updateCategory(Category category) {
        return categoryMapper.updateByPrimaryKey(category);
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int queryPidById(int id) {
        return categoryMapper.queryPidById(id);
    }

    @Override
    public List<Category> getCategoryListById(int brandId) {
        List<Category> categoryList = categoryMapper.getCategoryListById(brandId);
        return categoryList;
    }
     @Override
    public List<Channel> getWxChannelList() {
        return categoryMapper.getWxChannelList();

    }

    @Override
    public List<Category> queryAllCategoriesL1() {
        return categoryMapper.queryAllCategoriesL1();
    }

    @Override
    public List<Category> queryAllCategoriesL2(Integer currentCategoryId) {
        return categoryMapper.queryAllCategoriesL2(currentCategoryId);
    }

    @Override
    public List<Category> getFilterCategoryList(String keyword) {
        if (keyword == null){
            keyword = "";
        }
        return categoryMapper.getFilterCategoryList(keyword);
    }
}
