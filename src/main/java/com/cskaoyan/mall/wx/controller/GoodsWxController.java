package com.cskaoyan.mall.wx.controller;


import com.cskaoyan.mall.admin.bean.*;

import com.cskaoyan.mall.admin.service.GoodsService;

import com.cskaoyan.mall.admin.service.*;
import com.cskaoyan.mall.wx.bean.CommentWx;
import com.cskaoyan.mall.wx.bean.GoodsDetailWx;

import com.cskaoyan.mall.wx.bean.GrouponWx;
import com.cskaoyan.mall.wx.bean.SpecificationWx;

import com.cskaoyan.mall.wx.vo.BaseRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

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
    CommentService commentService;
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

    @RequestMapping("detail")
    @ResponseBody
    public BaseRespVO goodsDetail(Integer id){
        GoodsDetailWx data = getGoodsDetailById(id);
        BaseRespVO baseRespVo = BaseRespVO.ok(data);
        return baseRespVo;
    }

    private GoodsDetailWx getGoodsDetailById(int goodsId) {
        GoodsDetailWx goodsDetailWx = new GoodsDetailWx();
        Goods goods = goodsService.queryOneById(goodsId);

        //Attribute
        List<Attribute> attribute = attributeService.getAttributeByGoodsId(goodsId);
        //Brand
        Brand brand = null;
        if (goods.getBrandId() != 0 && goods.getBrandId() != null){
            brand = brandService.getBrandById(goods.getBrandId());
        }
        //Comment
        HashMap<String, Object> comment = new HashMap<>();
        List<CommentWx> comments = commentService.getCommentsByGoodsId(goodsId);
        int count = commentService.getCommentCountByGoodsId(goodsId);
        comment.put("data",comments);
        comment.put("count", count);
        //Groupon
        List<Groupon> groupon = grouponService.getGrouponRulesByGoodsId(goodsId);
        //Info
        Goods info = goodsService.queryOneById(goodsId);
        //Issue
        List<Issue> issue = issueService.getAllIssue();
        //Product
        List<Product> productList = productService.queryByGoodsId(goodsId);
        //Shareimage
        String shareImage = "";

        //SpecificationList
        List<SpecificationWx> specificationList = specificationService.querySpecificationWxByGoodsId(goodsId);

        goodsDetailWx.setAttribute(attribute);
        goodsDetailWx.setBrand(brand);
        goodsDetailWx.setComment(comment);
        goodsDetailWx.setGroupon(groupon);
        goodsDetailWx.setInfo(info);
        goodsDetailWx.setIssue(issue);
        goodsDetailWx.setProductList(productList);
        goodsDetailWx.setShareImage(shareImage);
        goodsDetailWx.setSpecificationList(specificationList);
        goodsDetailWx.setUserHasCollect(0);
        return goodsDetailWx;
    }

}
