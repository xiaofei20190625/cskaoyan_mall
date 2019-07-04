package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Category;
import com.cskaoyan.mall.bean.CategoryL1;
import com.cskaoyan.mall.bean.L1;
import com.cskaoyan.mall.service.CategoryService;
import com.cskaoyan.mall.vo.ResponseVO;
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
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("category/list")
    @ResponseBody
    public ResponseVO<List> getCategories(){
        ResponseVO<List> responseVO = new ResponseVO<>();
        List<CategoryL1> allCategories = categoryService.getAllCategories();
        responseVO.setData(allCategories);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

    @RequestMapping("category/l1")
    @ResponseBody
    public ResponseVO<List> getAllL1(){
        ResponseVO<List> responseVO = new ResponseVO<>();
        List<L1> allL1 = categoryService.getAllL1();
        responseVO.setData(allL1);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

    @RequestMapping("category/delete")
    @ResponseBody
    public ResponseVO deleteBrandById(@RequestBody Category category){
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
