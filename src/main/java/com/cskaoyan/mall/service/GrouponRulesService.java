package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.GrouponRules;
import com.cskaoyan.mall.vo.PageVO;

public interface GrouponRulesService {
    PageVO<GrouponRules> getList(int page, int limit, String sort, String order, String goodsId);

    int create(GrouponRules grouponRules);

    GrouponRules findGoodsId(Integer goodsId);

    int delete(GrouponRules grouponRules);

    int update(GrouponRules grouponRules);
}
