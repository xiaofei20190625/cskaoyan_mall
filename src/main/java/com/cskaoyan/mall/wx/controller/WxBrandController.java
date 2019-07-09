package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.Brand;
import com.cskaoyan.mall.admin.service.BrandService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(tags = "BrandController", description = "商品品牌管理")
@RequestMapping("wx")
public class WxBrandController {


    /*//wx/brand/list?page=1&size=10
    @Autowired
    BrandService brandService;

    @ApiOperation(value = "根据品牌名称分页获取品牌列表")
    @RequestMapping(value = "brand/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseVO<PageVO> getPageBrands(@RequestBody int page,  int size){

    }*/
}
