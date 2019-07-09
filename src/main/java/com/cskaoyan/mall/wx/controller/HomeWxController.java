package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.Ad;
import com.cskaoyan.mall.admin.bean.Coupon;
import com.cskaoyan.mall.admin.bean.Groupon;
import com.cskaoyan.mall.admin.service.*;
import com.cskaoyan.mall.wx.bean.*;

import com.cskaoyan.mall.wx.service.TopicServiceWx;
import com.cskaoyan.mall.wx.vo.BaseRespVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/9 Time 9:42
 */
@Controller
@RequestMapping("wx/home")
public class HomeWxController {

    @Autowired
    AdService adService;
    @Autowired
    BrandService brandService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    CouponService couponService;
    @Autowired
    GrouponService grouponService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    TopicServiceWx topicService;


    @ApiOperation(value = "获取主页页面")
    @RequestMapping("index")
    @ResponseBody
    public BaseRespVo homePage(){
        HashMap data = getHomeIndexMap();
        BaseRespVo baseRespVo = BaseRespVo.ok(data);
        return baseRespVo;
    }

    private HashMap getHomeIndexMap() {
        HashMap<Object, Object> data = new HashMap<>();
        List<Ad> bannerList = adService.getWxBannerList();
        List<Brand> brandList = brandService.getWxBrandList();
        List<Channel> channelList = categoryService.getWxChannelList();
        List<Coupon> couponList = couponService.getWxCouponList();
        List<FloorGoods> floorGoodsList = goodsService.getWxFloorGoodsList();
        List<Groupon> grouponList = grouponService.getWxGrouponList();
        List<Goods> hotGoodsList = goodsService.getWxHotGoodsList();
        List<Goods> newGoodsList = goodsService.getWxNewGoodsList();
        List<Topic> topicList = topicService.getWxTopicList();


        data.put("banner",bannerList);
        data.put("brandList",brandList);
        data.put("channel",channelList);
        data.put("couponList",couponList);
        data.put("floorGoodsList",floorGoodsList);
        data.put("grouponList",grouponList);
        data.put("hotGoodsList",hotGoodsList);
        data.put("newGoodsList",newGoodsList);
        data.put("topicList",topicList);
        return data;
    }
}
