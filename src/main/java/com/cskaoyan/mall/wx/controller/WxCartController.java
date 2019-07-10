package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.Ad;
import com.cskaoyan.mall.admin.bean.Address;
import com.cskaoyan.mall.admin.bean.Goods;
import com.cskaoyan.mall.admin.service.AddressService;
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
import java.util.*;

@Controller
@Api(tags = "WxCartController", description = "购物车")
@RequestMapping("wx")
public class WxCartController {
    @Autowired
    CartService cartService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    AddressService addressService;

    /*CartList: WxApiRoot + 'cart/index', //获取购物车的数据 完成
    CartAdd: WxApiRoot + 'cart/add', // 添加商品到购物车 完成
    CartFastAdd: WxApiRoot + 'cart/fastadd', // 立即购买商品 完成
    CartUpdate: WxApiRoot + 'cart/update', // 更新购物车的商品
    CartDelete: WxApiRoot + 'cart/delete', // 删除购物车的商品
    CartChecked: WxApiRoot + 'cart/checked', // 选择或取消选择商品 完成
    CartGoodsCount: WxApiRoot + 'cart/goodscount', // 获取购物车商品件数 完成
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

        //***********************************

        return BaseRespVO.ok(cartCount);
    }


    /*cart/add*/

    @ApiOperation(value = "购物车商品")
    @RequestMapping(value = "cart/add")
    @ResponseBody
    public BaseRespVO getCartAdd(@RequestBody Object boday, HttpServletRequest request){

        HashMap hashMap = JSONUtils.toHashMap(boday);
        int goodsId = (int) hashMap.get("goodsId");
        int number = (int) hashMap.get("number");
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
        Goods goods = goodsService.queryOneById(goodsId);
        cart.setChecked(true);
        cart.setDeleted(false);
        cart.setGoodsName(goods.getName());
        cart.setPicUrl(goods.getPicUrl());
        cart.setGoodsSn(goods.getGoodsSn());
        cart.setPrice(BigDecimal.valueOf(goods.getRetailPrice()));
        Cart querygoodsId = cartService.getCartGoodsByGoodsId(goodsId);
        int insert = -1;
        if (querygoodsId!=null){
            cart.setUpdateTime(date);
            number += querygoodsId.getNumber();
            cart.setNumber(number);
            insert =cartService.CartGoodsAddByGoodsId(cart);
        }
        if (querygoodsId==null){
            cart.setAddTime(date);
            insert = cartService.CartGoodsAdd(cart);
        }

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
        int number = (int) hashMap.get("number");
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
        Goods goods = goodsService.queryOneById(goodsId);
        cart.setChecked(true);
        cart.setDeleted(true);
        cart.setGoodsName(goods.getName());
        cart.setPicUrl(goods.getPicUrl());
        cart.setGoodsSn(goods.getGoodsSn());
        cart.setPrice(BigDecimal.valueOf(goods.getRetailPrice()));
        Cart querygoodsId = cartService.getCartGoodsByGoodsId(goodsId);
        int insert = -1;
        cart.setAddTime(date);
        insert = cartService.CartGoodsAdd(cart);

        if (insert!=1){
            return BaseRespVO.fail();
        }

        Integer CartId = cartService.getCartIdAast(userId,date);

        return BaseRespVO.ok(CartId);
    }
    //cart/checkout?cartId=0&addressId=0&couponId=0&grouponRulesId=1


    //CartList: WxApiRoot + 'cart/index', //获取购物车的数据
   /* cartList: [{id: 233, userId: 1, goodsId: 1109008, goodsSn: "1109008", goodsName: "云端沙发组合", productId: 140,…}]
            0: {id: 233, userId: 1, goodsId: 1109008, goodsSn: "1109008", goodsName: "云端沙发组合", productId: 140,…}
    cartTotal: {goodsCount: 1, checkedGoodsCount: 1, goodsAmount: 3999, checkedGoodsAmount: 3999}
        checkedGoodsAmount: 3999
        checkedGoodsCount: 1
        goodsAmount: 3999
        goodsCount: 1
    errmsg: "成功"
    errno: 0*/

    @ApiOperation(value = "购物车详情")
    @RequestMapping(value = "cart/index")
    @ResponseBody
    public BaseRespVO getCartIndex(HttpServletRequest request){

        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************
        if (userId == null) {
            return BaseRespVO.fail();
        }

        List<Cart> carts =cartService.getCartByUserId(userId);
        int checkedGoodsCount = 0;
        int goodsCount = 0;
        BigDecimal checkedGoodsAmount = new BigDecimal("0");
        BigDecimal goodsAmount = new BigDecimal("0");
        for (Cart cart : carts) {
            if (cart.getChecked()) {
                checkedGoodsCount += cart.getNumber();
                BigDecimal count = BigDecimal.valueOf(cart.getNumber());
                checkedGoodsAmount = checkedGoodsAmount.add(cart.getPrice().multiply(count));
            }
            if(!cart.getChecked()){
                goodsCount+=cart.getNumber();
                BigDecimal count = BigDecimal.valueOf(cart.getNumber());
                goodsAmount = goodsAmount.add(cart.getPrice().multiply(count));
            }
        }
        goodsCount+=checkedGoodsCount;
        goodsAmount=goodsAmount.add(checkedGoodsAmount);
        Map<Object, Object> cartTotal = new HashMap<Object, Object>();
        cartTotal.put("checkedGoodsCount",checkedGoodsCount);
        cartTotal.put("checkedGoodsAmount",checkedGoodsAmount);
        cartTotal.put("goodsCount",goodsCount);
        cartTotal.put("goodsAmount",goodsAmount);

        Map<Object, Object> data = new HashMap<Object, Object>();
        data.put("cartList",carts);
        data.put("cartTotal",cartTotal);
        return BaseRespVO.ok(data);
    }

    /*
actualPrice: 632 实付
addressId: 14 地址表id
availableCouponLength: 0 可利用优惠券
checkedAddress: {id: 14, name: "菲菲", userId: 1, provinceId: 2, cityId: 33, areaId: 394, address: "发文胡",…}
checkedGoodsList: [{id: 282, userId: 1, goodsId: 1114011, goodsSn: "1114011", goodsName: "104升 纯PC拉链斜纹拉杆箱",…}]
couponId: -1  优惠id
couponPrice: 0 优惠价
freightPrice: 333 运费
goodsTotalPrice: 299 商品合计
grouponPrice: 0 团购价
grouponRulesId: 0 团购规则id
orderTotalPrice: 632 订单价*/

    /*cartId: 0
addressId: 14
couponId: 0
grouponRulesId: 0*/

    //cart/checkout?cartId=0&addressId=0&couponId=0&grouponRulesId=1
    @ApiOperation(value = "确认订单")
    @RequestMapping(value = "cart/checkout")
    @ResponseBody
    public BaseRespVO getCartCheckout( int cartId, int addressId,int couponId,int grouponRulesId,HttpServletRequest request){

        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************
        if (userId == null) {
            return BaseRespVO.fail();
        }
        //Address checkedAddress= addressService.getAddressById(addressId);
        String checkedAddress=null;
        List<Cart> carts =cartService.getCartByUserId(userId);
        int checkedGoodsCount = 0;

        BigDecimal checkedGoodsAmount = new BigDecimal("0");
        BigDecimal orderTotalPrice = new BigDecimal("0");
        BigDecimal freightPrice = new BigDecimal("333");
        for (Cart cart : carts) {
            if (cart.getChecked()) {
                checkedGoodsCount += cart.getNumber();
                BigDecimal count = BigDecimal.valueOf(cart.getNumber());
                checkedGoodsAmount = checkedGoodsAmount.add(cart.getPrice().multiply(count));
            }
        }
        BigDecimal orderTotalPrices = orderTotalPrice.add(checkedGoodsAmount).add(freightPrice);
        Map<Object, Object> data = new HashMap<Object, Object>();
        data.put("actualPrice",orderTotalPrices);
        data.put("addressId",addressId);
        data.put("availableCouponLength",0);
        data.put("checkedAddress",checkedAddress);
        ArrayList<Object> checkedGoodsList = new ArrayList<>();
        data.put("checkedGoodsList",checkedGoodsList);
        data.put("couponId",couponId);
        data.put("couponPrice",0);
        data.put("freightPrice",freightPrice);
        data.put("goodsTotalPrice",checkedGoodsAmount);
        data.put("grouponPrice",0);
        data.put("grouponRulesId",grouponRulesId);
        data.put("orderTotalPrice",orderTotalPrices);
        return BaseRespVO.ok(data);
    }

  /*cartList: [{id: 296, userId: 1, goodsId: 1152101, goodsSn: "1152101", goodsName: "魔兽世界 部落 奥格瑞玛 拉杆箱 可登机",…},…]
        0: {id: 296, userId: 1, goodsId: 1152101, goodsSn: "1152101", goodsName: "魔兽世界 部落 奥格瑞玛 拉杆箱 可登机",…}
        1: {id: 297, userId: 1, goodsId: 1085019, goodsSn: "1085019", goodsName: "20寸 纯PC“铝框”（非全铝）登机箱",…}
cartTotal: {goodsCount: 2, checkedGoodsCount: 2, goodsAmount: 1237, checkedGoodsAmount: 1237}
    checkedGoodsAmount: 1237
    checkedGoodsCount: 2
    goodsAmount: 1237
    goodsCount: 2*/

  /*{productIds: [102], isChecked: 1}
isChecked: 1
productIds: [102]
0: 102*/
    //cart/checked
    @ApiOperation(value = "购物车选择")
    @RequestMapping(value = "cart/checked")
    @ResponseBody
    public BaseRespVO getCartChecked(@RequestBody Object object, HttpServletRequest request){
        HashMap hashMap = JSONUtils.toHashMap(object);
        int isChecked = (int) hashMap.get("isChecked");
        Boolean Checked = true;
        if (isChecked==0){
            Checked = false;
        }

        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************
        if (userId == null) {
            return BaseRespVO.fail();
        }
        List<Integer> productIds = (List) hashMap.get("productIds");
        for (Integer productId : productIds) {
            Cart cart = new Cart();
            cart.setUpdateTime(new Date());
            cart.setProductId(productId);
            cart.setUserId(userId);
            cart.setChecked(Checked);
            cartService.updateCartGoodsisChecked(cart);
        }
        List<Cart> carts =cartService.getCartByUserId(userId);
        int checkedGoodsCount = 0;
        int goodsCount = 0;
        BigDecimal checkedGoodsAmount = new BigDecimal("0");
        BigDecimal goodsAmount = new BigDecimal("0");
        for (Cart cart : carts) {
            if (cart.getChecked()) {
                checkedGoodsCount += cart.getNumber();
                BigDecimal count = BigDecimal.valueOf(cart.getNumber());
                checkedGoodsAmount = checkedGoodsAmount.add(cart.getPrice().multiply(count));
            }
            if(!cart.getChecked()){
                goodsCount+=cart.getNumber();
                BigDecimal count = BigDecimal.valueOf(cart.getNumber());
                goodsAmount = goodsAmount.add(cart.getPrice().multiply(count));
            }
        }
        goodsCount+=checkedGoodsCount;
        goodsAmount=goodsAmount.add(checkedGoodsAmount);
        Map<Object, Object> cartTotal = new HashMap<Object, Object>();
        cartTotal.put("checkedGoodsCount",checkedGoodsCount);
        cartTotal.put("checkedGoodsAmount",checkedGoodsAmount);
        cartTotal.put("goodsCount",goodsCount);
        cartTotal.put("goodsAmount",goodsAmount);

        Map<Object, Object> data = new HashMap<Object, Object>();
        data.put("cartList",carts);
        data.put("cartTotal",cartTotal);
        return BaseRespVO.ok(data);
    }


   // CartUpdate: WxApiRoot + 'cart/update', // 更新购物车的商品
    /*goodsId: 1070000
    id: 302
    number: 1
    productId: 85*/
   // CartDelete: WxApiRoot + 'cart/delete', // 删除购物车的商品
   @ApiOperation(value = "更新购物车的商品")
   @RequestMapping(value = "cart/update")
   @ResponseBody
   public BaseRespVO getCartUpdate(@RequestBody Object boday, HttpServletRequest request){

       HashMap hashMap = JSONUtils.toHashMap(boday);
       int goodsId = (int) hashMap.get("goodsId");
       int id = (int) hashMap.get("id");
       int number = (int) hashMap.get("number");
       int productId = (int) hashMap.get("productId");
       String tokenKey = request.getHeader("X-Litemall-Token");
       Integer userId = UserTokenManager.getUserId(tokenKey);
       //通过请求头获得userId，进而可以获得一切关于user的信息
       //**************************
       if (userId == null) {
           return BaseRespVO.fail();
       }
       Cart cart = new Cart();
       cart.setId(id);
       cart.setGoodsId(goodsId);
       cart.setNumber(number);
       cart.setProductId(productId);
       cart.setUserId(userId);
       Date date = new Date();
       Goods goods = goodsService.queryOneById(goodsId);
       cart.setChecked(true);
       cart.setDeleted(false);
       cart.setGoodsName(goods.getName());
       cart.setPicUrl(goods.getPicUrl());
       cart.setGoodsSn(goods.getGoodsSn());
       cart.setPrice(BigDecimal.valueOf(goods.getRetailPrice()));


       int insert = -1;
       cart.setUpdateTime(date);
       insert =cartService.updateCartGoodsAddById(cart);

       if (insert!=1){
           return BaseRespVO.fail();
       }
       return BaseRespVO.ok(null);
   }

    // CartDelete: WxApiRoot + 'cart/delete', // 删除购物车的商品
    @ApiOperation(value = "删除购物车的商品")
    @RequestMapping(value = "cart/delete")
    @ResponseBody
    public BaseRespVO getCartDelete(@RequestBody Object boday, HttpServletRequest request){

        HashMap hashMap = JSONUtils.toHashMap(boday);
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************
        if (userId == null) {
            return BaseRespVO.fail();
        }

        List<Integer> productIds = (List) hashMap.get("productIds");
        int delete = -1;
        for (Integer productId : productIds) {
            Cart cart = new Cart();
            cart.setUpdateTime(new Date());
            cart.setProductId(productId);
            cart.setUserId(userId);
            cart.setDeleted(true);
            delete =cartService.updateCartGoodsisChecked(cart);
        }

        if (delete!=1){
            return BaseRespVO.fail();
        }
        return BaseRespVO.ok(null);
    }

}
