package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.Goods;
import com.cskaoyan.mall.admin.service.GoodsService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.wx.bean.Cart;
import com.cskaoyan.mall.wx.service.CartService;
import com.cskaoyan.mall.wx.userwx.UserTokenManager;
import com.cskaoyan.mall.wx.utils.JSONUtils;
import com.cskaoyan.mall.wx.vo.BaseRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "WxCartController", description = "购物车")
@RequestMapping("wx")
public class WxCartController {
    @Autowired
    CartService cartService;
    @Autowired
    GoodsService goodsService;

    /*CartList: WxApiRoot + 'cart/index', //获取购物车的数据
    CartAdd: WxApiRoot + 'cart/add', // 添加商品到购物车
    CartFastAdd: WxApiRoot + 'cart/fastadd', // 立即购买商品
    CartUpdate: WxApiRoot + 'cart/update', // 更新购物车的商品
    CartDelete: WxApiRoot + 'cart/delete', // 删除购物车的商品
    CartChecked: WxApiRoot + 'cart/checked', // 选择或取消选择商品
    CartGoodsCount: WxApiRoot + 'cart/goodscount', // 获取购物车商品件数
    CartCheckout: WxApiRoot + 'cart/checkout', // 下单前信息确认*/




    @ApiOperation(value = "购物车商品数量")
    @RequestMapping(value = "cart/goodscount")
    @ResponseBody
    public BaseRespVO getCartGoodscount(HttpServletRequest request){
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************
        if (userId == null) {
            return BaseRespVO.fail();
        }

        int cartCount = cartService.getCartGoodscount(userId);

        //***********************************
        Map<Object, Object> data = new HashMap<Object, Object>();
        data.put("data",cartCount);
        //***********************************

        return BaseRespVO.ok(data);
    }


    /*cart/add*/

    @ApiOperation(value = "购物车商品")
    @RequestMapping(value = "cart/add")
    @ResponseBody
    public BaseRespVO getCartAdd(@RequestBody Object boday, HttpServletRequest request){

        HashMap hashMap = JSONUtils.toHashMap(boday);
        int goodsId = (int) hashMap.get("goodsId");
        short number = (short) hashMap.get("number");
        int productId = (int) hashMap.get("productId");
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************
        if (userId == null) {
            return BaseRespVO.fail();
        }
        Cart cart = new Cart();
        cart.setGoodsId(goodsId);
        cart.setNumber(number);
        cart.setProductId(productId);
        cart.setUserId(userId);
        cart.setAddTime(new Date());
        Goods goods = goodsService.queryOneById(goodsId);
        cart.setChecked(true);
        cart.setDeleted(false);
        cart.setGoodsName(goods.getName());
        cart.setPicUrl(goods.getPicUrl());
        cart.setGoodsSn(goods.getGoodsSn());
        cart.setPrice(BigDecimal.valueOf(goods.getRetailPrice()));

        int insert = cartService.CartGoodsAdd(cart);

        if (insert!=1){
            return BaseRespVO.fail();
        }

        int cartCount = cartService.getCartGoodscount(userId);

        return BaseRespVO.ok(cartCount);
    }

    //cart/fastadd


    @ApiOperation(value = "立即购买商品")
    @RequestMapping(value = "cart/fastadd")
    @ResponseBody
    public BaseRespVO getCartAastadd(@RequestBody Object boday, HttpServletRequest request){

        HashMap hashMap = JSONUtils.toHashMap(boday);
        int goodsId = (int) hashMap.get("goodsId");
        short number = (short) hashMap.get("number");
        int productId = (int) hashMap.get("productId");
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************
        if (userId == null) {
            return BaseRespVO.fail();
        }
        Cart cart = new Cart();
        cart.setGoodsId(goodsId);
        cart.setNumber(number);
        cart.setProductId(productId);
        cart.setUserId(userId);
        Date date = new Date();
        cart.setAddTime(date);
        Goods goods = goodsService.queryOneById(goodsId);
        cart.setChecked(true);
        cart.setDeleted(true);
        cart.setGoodsName(goods.getName());
        cart.setPicUrl(goods.getPicUrl());
        cart.setGoodsSn(goods.getGoodsSn());
        cart.setPrice(BigDecimal.valueOf(goods.getRetailPrice()));

        int insert = cartService.CartGoodsAdd(cart);

        if (insert!=1){
            return BaseRespVO.fail();
        }
        int CartId = cartService.getCartIdAast(userId,date);

        return BaseRespVO.ok(CartId);
    }


}
