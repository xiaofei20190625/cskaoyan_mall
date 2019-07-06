package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.GoodsAndGrouponAndGrouponRules;
import com.cskaoyan.mall.bean.Groupon;
import com.cskaoyan.mall.bean.GrouponRules;
import com.cskaoyan.mall.mapper.GrouponMapper;
import com.cskaoyan.mall.service.GrouponService;
import com.cskaoyan.mall.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public PageVO<GoodsAndGrouponAndGrouponRules> getListRecord(int page, int limit, String sort, String order, String goodsId) {
        PageHelper.startPage(page, limit);
        List<GoodsAndGrouponAndGrouponRules> orderList = grouponMapper.getListRecord(sort , order ,goodsId  );
        PageInfo<GoodsAndGrouponAndGrouponRules> grouponPageInfo = new PageInfo<>(orderList);
        PageVO<GoodsAndGrouponAndGrouponRules> grouponPageVO = new PageVO<>(grouponPageInfo.getTotal(),grouponPageInfo.getList());
        return  grouponPageVO ;
    }

    @Override
    public int create(GrouponRules grouponRules) {
        return grouponMapper.create(grouponRules);
    }
}
