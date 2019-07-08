package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.Goods;
import com.cskaoyan.mall.admin.bean.GrouponRules;
import com.cskaoyan.mall.admin.service.GoodsService;
import com.cskaoyan.mall.admin.service.GrouponRulesService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groupon")
public class GrouponRulesController {

    @Autowired
    GrouponRulesService grouponRulesService;
    @Autowired
    GoodsService goodsService ;

    /*http://192.168.2.100:8081/admin/groupon/list?page=1&limit=20&goodsId=1&sort=add_time&order=desc*/
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseVO<PageVO> getList(int page, int limit, String sort, String order, String goodsId) {
        if (goodsId == null) goodsId = "";
        PageVO<GrouponRules> grouponRulesPageVO = grouponRulesService.getList(page, limit, sort, order, goodsId);
        ResponseVO<PageVO> responseVO = new ResponseVO<>();
        responseVO.setData(grouponRulesPageVO);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseVO<GrouponRules> create(@RequestBody GrouponRules grouponRules) {
        ResponseVO<GrouponRules> responseVO = new ResponseVO<>();
        Goods goods = goodsService.queryOneById(grouponRules.getGoodsId());
        //GrouponRules old = grouponRulesService.findGoodsId(grouponRules.getGoodsId());
        if (goods != null || grouponRules.getDiscount() != null || grouponRules.getDiscountMember() != null || grouponRules.getExpireTime() != null){
            GrouponRules rules = new GrouponRules();
            rules.setGoodsId(goods.getId());
            rules.setGoodsName(goods.getName());
            rules.setPicUrl(goods.getPicUrl());
            rules.setAddTime(goods.getAddTime());
            rules.setUpdateTime(goods.getUpdateTime());
            rules.setDeleted(goods.isDeleted());
            rules.setDiscount(grouponRules.getDiscount());
            rules.setDiscountMember(grouponRules.getDiscountMember());
            rules.setExpireTime(grouponRules.getExpireTime());
            int insert = grouponRulesService.create(rules);
            if (insert == 1) {
                responseVO.setData(rules);
                responseVO.setErrmsg("成功");
                responseVO.setErrno(0);
            }else {
                responseVO.setErrmsg("错误");
                responseVO.setErrno(-1);
            }
        }else {
            responseVO.setErrmsg("参数值不对");
            responseVO.setErrno(402);
        }
        return  responseVO ;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseVO delete(@RequestBody GrouponRules grouponRules){
        int delete = grouponRulesService.delete(grouponRules);
        ResponseVO<Integer> responseVO = new ResponseVO<>();
        if(delete == 1){
            responseVO.setData(delete);
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
        }
        return  responseVO;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseVO<GrouponRules> update(@RequestBody GrouponRules grouponRules) {
        int update = grouponRulesService.update(grouponRules);
        ResponseVO<GrouponRules> responseVO = new ResponseVO<>();
        if (update == 1) {
            responseVO.setData(grouponRules);
            responseVO.setErrno(0);
            responseVO.setErrmsg("成功");
        }
        return responseVO;
    }




}
