package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.service.BrandService;
import com.cskaoyan.mall.admin.service.CategoryService;
import com.cskaoyan.mall.admin.service.GoodsService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.cskaoyan.mall.wx.userwx.UserTokenManager;
import com.cskaoyan.mall.wx.utils.JSONUtils;
import com.cskaoyan.mall.wx.vo.BaseRespVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "BrandController", description = "商品品牌")
@RequestMapping("wx")
public class WxBrandController {

    @Autowired
    BrandService brandService;
    @Autowired
    CategoryService categoryService;

    //wx/brand/list?page=1&size=10
    @ApiOperation(value = "根据品牌名称分页获取品牌列表")
    @RequestMapping(value = "brand/list")
    @ResponseBody
    public BaseRespVO getPageBrandsList(int page,int size){

        List<HashMap> brandMaps = brandService.getBrand();
        //***********************************
        //分页
        PageVO<List> listPageVO = pageInfo(page, size, brandMaps);
        Long total = listPageVO.getTotal();
        List<List> items = listPageVO.getItems();

        //***********************************
        Map<Object, Object> data = new HashMap<Object, Object>();
        data.put("brandList", items);
        data.put("totalPages", total);

        //***********************************

        return BaseRespVO.ok(data);
    }


    @ApiOperation(value = "根据品牌id获取品牌详情")
    @RequestMapping(value = "brand/detail")
    @ResponseBody
    public BaseRespVO getPageBrandsdetail(int id){

        Brand brand = brandService.getBrandById(id);
        //***********************************
        Map<Object, Object> data = new HashMap<Object, Object>();
        data.put("brand",brand);

        //***********************************

        return BaseRespVO.ok(data);
    }

    private PageVO<List> pageInfo(int page, int size, List list) {
        PageHelper.startPage(page, size);
        PageInfo<List> pageInfo = new PageInfo<>(list);
        PageVO<List> listPageVO = new PageVO<>(pageInfo.getTotal(), pageInfo.getList());
        return listPageVO;
    }


}
