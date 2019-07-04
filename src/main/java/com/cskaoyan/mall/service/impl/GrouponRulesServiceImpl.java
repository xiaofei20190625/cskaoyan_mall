package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.GrouponRules;
import com.cskaoyan.mall.bean.Topic;
import com.cskaoyan.mall.mapper.GrouponRulesMapper;
import com.cskaoyan.mall.service.GrouponRulesService;
import com.cskaoyan.mall.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alex_Cheng
 * @date 2019/7/4 23:31
 * @Description TODO
 */
@Service
public class GrouponRulesServiceImpl implements GrouponRulesService {
    @Autowired
    GrouponRulesMapper grouponRulesMapper;

    @Override
    public PageVO<GrouponRules> getList(int page, int limit, String sort, String order, String goodsId) {
        PageHelper.startPage(page, limit);
        List<GrouponRules> couponList = grouponRulesMapper.getList(sort , order ,goodsId );
        PageInfo<GrouponRules> grouponRulesPageInfo = new PageInfo<>(couponList);
        PageVO<GrouponRules> grouponRulesPageVO = new PageVO<>(grouponRulesPageInfo.getTotal(),grouponRulesPageInfo.getList());
        return  grouponRulesPageVO ;
    }
}
