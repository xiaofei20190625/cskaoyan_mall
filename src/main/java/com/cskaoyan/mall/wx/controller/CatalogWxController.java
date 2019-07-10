package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.Category;
import com.cskaoyan.mall.admin.service.CategoryService;
import com.cskaoyan.mall.wx.vo.BaseRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/10 Time 11:38
 */
@Controller
@RequestMapping("wx/catalog")
public class CatalogWxController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("index")
    @ResponseBody
    public BaseRespVO catalogIndex(){
        HashMap<String, Object> catalogIndex = getCatalogIndex();
        BaseRespVO baseRespVO = BaseRespVO.ok(catalogIndex);
        return baseRespVO;
    }

    private HashMap<String, Object> getCatalogIndex() {
        HashMap<String, Object> hashMap = new HashMap<>();
        List<Category> categoryList = categoryService.queryAllCategoriesL1();
        Category currentCategory = categoryList.get(0);
        Integer currentCategoryId = currentCategory.getId();
        List<Category> currentSubCategory = categoryService.queryAllCategoriesL2(currentCategoryId);

        hashMap.put("categoryList",categoryList);
        hashMap.put("currentCategory",currentCategory);
        hashMap.put("currentSubCategory",currentSubCategory);

        return hashMap;
    }

    @RequestMapping("current")
    @ResponseBody
    public BaseRespVO catalogCurrent(Integer id){
        HashMap<String, Object> catalogCurrent = getCatalogCurrentById(id);
        BaseRespVO baseRespVO = BaseRespVO.ok(catalogCurrent);
        return baseRespVO;
    }

    private HashMap<String, Object> getCatalogCurrentById(int id) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Category currentCategory = categoryService.getCategoryById(id);
        List<Category> currentSubCategory = categoryService.queryAllCategoriesL2(id);

        hashMap.put("currentCategory",currentCategory);
        hashMap.put("currentSubCategory",currentSubCategory);

        return hashMap;
    }

}
