package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.GoodsAndGrouponAndGrouponRules;
import com.cskaoyan.mall.bean.Groupon;
import com.cskaoyan.mall.bean.GrouponRules;
import com.cskaoyan.mall.vo.PageVO;

public interface GrouponService {
    PageVO<GoodsAndGrouponAndGrouponRules> getListRecord(int page, int limit, String sort, String order, String goodsId);

    int create(GrouponRules grouponRules);

    Groupon findRulesId(Integer id);
}
