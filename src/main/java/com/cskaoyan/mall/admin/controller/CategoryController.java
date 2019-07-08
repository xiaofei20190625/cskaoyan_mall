package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.Category;
import com.cskaoyan.mall.admin.bean.CategoryL1;
import com.cskaoyan.mall.admin.bean.L1;
import com.cskaoyan.mall.admin.service.CategoryService;
import com.cskaoyan.mall.admin.vo.ResponseVO;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/4 Time 16:18
 */
@Controller

@RequestMapping(value = "/admin/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @ApiOperation(value = "获取商品类目")
    @RequestMapping("list")
    @ResponseBody
    public ResponseVO<List> getCategories(){
        ResponseVO<List> responseVO = new ResponseVO<>();
        List<CategoryL1> allCategories = categoryService.getAllCategories();
        responseVO.setData(allCategories);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

    @ApiOperation(value = "一级类目的回显")
    @RequestMapping("l1")
    @ResponseBody
    public ResponseVO<List> getAllL1(){
        ResponseVO<List> responseVO = new ResponseVO<>();
        List<L1> allL1 = categoryService.getAllL1();
        responseVO.setData(allL1);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

    @ApiOperation(value = "创建商品类目")
    @RequestMapping("create")
    @ResponseBody
    public ResponseVO<Category> createCategory(@RequestBody Category category){
        Category newCategory = categoryService.createCategory(category);
        ResponseVO<Category> responseVO = new ResponseVO<>();
        if (newCategory != null){
            responseVO.setData(newCategory);
            responseVO.setErrno(0);
            responseVO.setErrmsg("成功");
        }
        return responseVO;
    }

    @ApiOperation(value = "更新商品类目")
    @RequestMapping("update")
    @ResponseBody
    public ResponseVO<Category> updateCategory(@RequestBody Category category){
        int create = categoryService.updateCategory(category);
        ResponseVO<Category> responseVO = new ResponseVO<>();
        if (create == 1){
            Category newCategory = categoryService.getCategoryById(category.getId());
            responseVO.setData(newCategory);
            responseVO.setErrno(0);
            responseVO.setErrmsg("成功");
        }
        return responseVO;
    }

    @ApiOperation(value = "删除商品类目")
    @RequestMapping("delete")
    @ResponseBody
    public ResponseVO deleteCategoryById(@RequestBody Category category){
        int delete = categoryService.deleteCategoryById(category);
        ResponseVO<Object> responseVO = new ResponseVO<>();
        if (delete == 1){
            responseVO.setData(delete);
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
        }
        return responseVO;
    }
}
