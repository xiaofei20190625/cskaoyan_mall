package com.cskaoyan.mall.wx.controller;


import com.cskaoyan.mall.admin.service.GoodsService;

import com.cskaoyan.mall.wx.vo.BaseRespVO;

import com.cskaoyan.mall.admin.service.*;
import com.cskaoyan.mall.wx.bean.GoodsDetailWx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/9 Time 12:06
 */
@Controller
@RequestMapping("wx/goods")
public class GoodsWxController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    AttributeService attributeService;
    @Autowired
    BrandService brandService;
    @Autowired
    GrouponService grouponService;
    @Autowired
    IssueService issueService;
    @Autowired
    ProductService productService;
    @Autowired
    SpecificationService specificationService;




    @RequestMapping("count")
    @ResponseBody
    public BaseRespVO goodsCount(){
        int count = goodsService.getGoodsNum();
        HashMap data = new HashMap();
        data.put("goodsCount",count);
        BaseRespVO baseRespVo = BaseRespVO.ok(data);
        return baseRespVo;
    }

    /*@RequestMapping("detail")
    @ResponseBody
    public BaseRespVo goodsDetail(Integer id){
        GoodsDetailWx data = getGoodsDetailById(id);
    }*/

    private GoodsDetailWx getGoodsDetailById(int id) {
        GoodsDetailWx goodsDetailWx = new GoodsDetailWx();

//        attributeService.

//        goodsDetailWx.setAttribute();
//        goodsDetailWx.setBrand();
//        goodsDetailWx.setComment();
//        goodsDetailWx.setGroupon();
//        goodsDetailWx.setInfo();
//        goodsDetailWx.setIssue();
//        goodsDetailWx.setProductList();
//        goodsDetailWx.setShareImage();
//        goodsDetailWx.setSpecificationList();
//        goodsDetailWx.setUserHasCollect();
        return goodsDetailWx;
    }

}
