package com.cskaoyan.mall.wx.controller;


import com.cskaoyan.mall.admin.bean.Goods;
import com.cskaoyan.mall.admin.bean.GoodsToGroupon;
import com.cskaoyan.mall.admin.bean.GrouponAndGoods;
import com.cskaoyan.mall.admin.bean.GrouponRules;
import com.cskaoyan.mall.admin.service.GoodsService;
import com.cskaoyan.mall.admin.service.GrouponRulesService;
import com.cskaoyan.mall.admin.service.GrouponService;
import com.cskaoyan.mall.admin.vo.BaseRespVo;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.cskaoyan.mall.wx.bean.GoodsWx;
import com.cskaoyan.mall.wx.vo.ListVo;
import com.cskaoyan.mall.wx.vo.TopicCountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alex_Cheng
 * @date 2019/7/9 11:40
 * @Description TODO
 */
@RestController
@RequestMapping("/wx/groupon")
public class WxGrouponController {

    @Autowired
    GrouponRulesService grouponRulesService;
    @Autowired
    GoodsService goodsService;

    //   http://192.168.2.100:8081/wx/groupon/list?page=1&size=10
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object wxGetList(int page, int size) {
        List<GrouponRules> grouponRulesList = grouponRulesService.wxGetList(page, size);
        int count = grouponRulesService.count();
        Map<Object , Object> result = new HashMap<>();
        result.put("count", count);
        //TopicCountVO<List> topicVO = new TopicCountVO<>();
        List<GrouponAndGoods> data = new ArrayList<>();
        for (int i = 0; i < grouponRulesList.size(); i++) {
            GoodsToGroupon goodsWx = goodsService.getGoodsWx(grouponRulesList.get(i).getGoodsId());
            GrouponAndGoods grouponAndGoods = new GrouponAndGoods();
            grouponAndGoods.setGoods(goodsWx);
            grouponAndGoods.setGroupon_member(grouponRulesList.get(i).getDiscountMember());
            grouponAndGoods.setGroupon_price(grouponAndGoods.getGoods().getRetailPrice() - grouponRulesList.get(i).getDiscount());
            data.add(grouponAndGoods);
        }
        //List<GrouponAndGoods> data = grouponAndGoodsList ;
        //ListVo<GrouponAndGoods> data = new ListVo<>();
        //data.setData(grouponAndGoodsList);
/*        topicVO.setCount(grouponRulesList.size());
        topicVO.setData(grouponAndGoodsList);
        responseVO.setData(topicVO);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;*/
        result.put("data",data);
        return  BaseRespVo.ok(result);
    }

    //http://localhost:8080/wx/groupon/my?showType=0
    //http://localhost:8080/wx/groupon/my?showType=1
/*      订单状态：
            101 订单生成，未支付；
            102，下单后未支付用户取消；
            103，下单后未支付超时系统自动取消
            201 支付完成，商家未发货；
            202，订单生产，已付款未发货，但是退款取消；
            301 商家发货，用户未确认；
            401 用户确认收货； 402 用户没有确认收货超过一定时间，系统自动确认收货；*/
    @RequestMapping("my")
    public  Object my(int showType){
        Map<Object ,Object> result = new HashMap<>();






        //result.put("count" ,count);
        //result.put("data" ,data);
        return BaseRespVo.ok(result);
    }
}
