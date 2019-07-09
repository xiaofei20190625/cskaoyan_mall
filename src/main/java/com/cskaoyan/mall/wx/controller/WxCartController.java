package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.wx.service.CartService;
import com.cskaoyan.mall.wx.userwx.UserTokenManager;
import com.cskaoyan.mall.wx.vo.BaseRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "WxCartController", description = "购物车")
@RequestMapping("wx")
public class WxCartController {
    @Autowired
    CartService cartService;

    /*CartList: WxApiRoot + 'cart/index', //获取购物车的数据
    CartAdd: WxApiRoot + 'cart/add', // 添加商品到购物车
    CartFastAdd: WxApiRoot + 'cart/fastadd', // 立即购买商品
    CartUpdate: WxApiRoot + 'cart/update', // 更新购物车的商品
    CartDelete: WxApiRoot + 'cart/delete', // 删除购物车的商品
    CartChecked: WxApiRoot + 'cart/checked', // 选择或取消选择商品
    CartGoodsCount: WxApiRoot + 'cart/goodscount', // 获取购物车商品件数
    CartCheckout: WxApiRoot + 'cart/checkout', // 下单前信息确认*/
   /* @ApiOperation(value = "根据品牌名称分页获取品牌列表")
    @RequestMapping(value = "brand/list")
    @ResponseBody
    public BaseRespVO getPageBrandsList(int page, int size){

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
    }*/



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

    //cart/index
    /*cart/add
    goodsId: 1109008
    number: 1
    productId: 140


    data: 60
    errmsg: "成功"
    errno: 0
*/
}
