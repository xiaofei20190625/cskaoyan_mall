package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Groupon;
import com.cskaoyan.mall.admin.bean.GrouponRules;
import com.cskaoyan.mall.admin.vo.PageVO;

import java.util.List;

public interface GrouponService {
    PageVO<Groupon> getListRecord(int page, int limit, String sort, String order, String goodsId);

    int create(GrouponRules grouponRules);

    Groupon findRulesId(Integer id);

    List<Groupon> getWxGrouponList();

    List<Groupon> getGrouponRulesByGoodsId(int goodsId);

    List<Groupon> queryAll();

    int count();

    int countGrouponId();

    Groupon getGrouponId(int grouponId);
}