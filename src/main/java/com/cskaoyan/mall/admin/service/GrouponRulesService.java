package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.GrouponRules;
import com.cskaoyan.mall.admin.vo.PageVO;

import java.util.List;

public interface GrouponRulesService {
    PageVO<GrouponRules> getList(int page, int limit, String sort, String order, String goodsId);
    int create(GrouponRules grouponRules);

    GrouponRules findGoodsId(Integer goodsId);

    int delete(GrouponRules grouponRules);

    int update(GrouponRules grouponRules);

    List<GrouponRules> wxGetList(int page, int size);

    int count();
}