package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Groupon;
import com.cskaoyan.mall.admin.bean.GrouponRules;
import com.cskaoyan.mall.admin.mapper.GoodsMapper;
import com.cskaoyan.mall.admin.mapper.GrouponMapper;
import com.cskaoyan.mall.admin.mapper.GrouponRulesMapper;
import com.cskaoyan.mall.admin.service.GrouponService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alex_Cheng
 * @date 2019/7/5 15:44
 * @Description TODO
 */
@Service
public class GrouponServiceImpl implements GrouponService {
    @Autowired
    GrouponMapper grouponMapper ;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    GrouponRulesMapper grouponRulesMapper;

    @Override
    public PageVO<Groupon> getListRecord(int page, int limit, String sort, String order, String goodsId) {
        PageHelper.startPage(page, limit);
        List<Groupon> orderList = grouponMapper.getListRecord(sort , order ,goodsId  );
        PageInfo<Groupon> grouponPageInfo = new PageInfo<>(orderList);
        PageVO<Groupon> grouponPageVO = new PageVO<>(grouponPageInfo.getTotal(),grouponPageInfo.getList());
        return  grouponPageVO ;
    }
    @Override
    public int create(GrouponRules grouponRules) {
        return grouponMapper.create(grouponRules);
    }

    @Override
    public Groupon findRulesId(Integer id) {
        return null;
    }

    @Override
    public List<Groupon> getWxGrouponList() {
        return grouponMapper.getWxGrouponList();
    }

    @Override
    public List<Groupon> getGrouponRulesByGoodsId(int goodsId) {
        return grouponRulesMapper.getGrouponRulesByGoodsId(goodsId);
    }

    @Override
    public List<Groupon> queryAll() {
        return grouponMapper.queryAll();
    }

    @Override
    public int count() {
        return grouponMapper.count();
    }

    @Override
    public int countGrouponId() {
        return grouponMapper.countGrouponId();
    }

    @Override
    public Groupon getGrouponId(int grouponId) {
        return grouponMapper.selectByPrimaryKey(grouponId);
    }
}