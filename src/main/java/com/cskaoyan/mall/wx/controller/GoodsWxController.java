package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.service.GoodsService;

import com.cskaoyan.mall.wx.vo.BaseRespVO;
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

    @RequestMapping("count")
    @ResponseBody
    public BaseRespVO goodsCount(){
        int count = goodsService.getGoodsNum();
        HashMap data = new HashMap();
        data.put("goodsCount",count);
        BaseRespVO baseRespVo = BaseRespVO.ok(data);
        return baseRespVo;
    }

}
