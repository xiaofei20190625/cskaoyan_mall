package com.cskaoyan.mall.wx.controller;


import com.cskaoyan.mall.admin.bean.Goods;
import com.cskaoyan.mall.admin.bean.GrouponAndGoods;
import com.cskaoyan.mall.admin.bean.GrouponRules;
import com.cskaoyan.mall.admin.service.GoodsService;
import com.cskaoyan.mall.admin.service.GrouponRulesService;
import com.cskaoyan.mall.admin.service.GrouponService;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.cskaoyan.mall.wx.vo.TopicCountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    public ResponseVO<TopicCountVO> wxGetList(int page, int size) {
        ResponseVO<TopicCountVO> responseVO = new ResponseVO<>();
        TopicCountVO<List> topicVO = new TopicCountVO<>();
        List<GrouponRules> grouponRulesList = grouponRulesService.wxGetList(page, size);
        List<GrouponAndGoods> grouponAndGoodsList = new ArrayList<>();
        for (int i = 0; i < grouponRulesList.size(); i++) {
            Goods goods = goodsService.queryOneById(grouponRulesList.get(i).getGoodsId());
            GrouponAndGoods grouponAndGoods = new GrouponAndGoods();
            grouponAndGoods.setBrief(goods.getBrief());
            grouponAndGoods.setCounterPrice(goods.getCounterPrice());
            grouponAndGoods.setId(goods.getId());
            grouponAndGoods.setName(goods.getName());
            grouponAndGoods.setPicUrl(goods.getPicUrl());
            grouponAndGoods.setRetailPrice(goods.getRetailPrice());
            grouponAndGoods.setGroupon_member(grouponRulesList.get(i).getDiscountMember());
            grouponAndGoods.setGroupon_price(grouponAndGoods.getRetailPrice() - grouponRulesList.get(i).getDiscount());
            grouponAndGoodsList.add(grouponAndGoods);
        }
        topicVO.setCount(grouponRulesList.size());
        topicVO.setData(grouponAndGoodsList);
        responseVO.setData(topicVO);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }
}
