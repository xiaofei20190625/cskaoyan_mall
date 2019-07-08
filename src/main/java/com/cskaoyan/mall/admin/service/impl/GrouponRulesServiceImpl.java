package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.GrouponRules;

import com.cskaoyan.mall.admin.mapper.GrouponRulesMapper;
import com.cskaoyan.mall.admin.service.GrouponRulesService;
import com.cskaoyan.mall.admin.vo.PageVO;
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

    @Override
    public int create(GrouponRules grouponRules) {
        return grouponRulesMapper.create(grouponRules);
    }

    @Override
    public GrouponRules findGoodsId(Integer goodsId) {
        return grouponRulesMapper.findGoodsId(goodsId);
    }

    @Override
    public int delete(GrouponRules grouponRules) {
        return grouponRulesMapper.deleteByPrimaryKey(grouponRules.getId());
    }

    @Override
    public int update(GrouponRules grouponRules) {
        return grouponRulesMapper.updateByPrimaryKeySelective(grouponRules);
    }
}
