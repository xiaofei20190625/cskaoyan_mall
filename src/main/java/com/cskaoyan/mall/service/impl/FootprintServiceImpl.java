package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Address;
import com.cskaoyan.mall.bean.Footprint;
import com.cskaoyan.mall.mapper.FootprintMapper;
import com.cskaoyan.mall.service.FootprintService;
import com.cskaoyan.mall.utils.PageUtil;
import com.cskaoyan.mall.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootprintServiceImpl implements FootprintService {
    @Autowired
    FootprintMapper footprintMapper;

    @Override
    public PageVO<Footprint> findFootprintPageByGoodsIdAndUserId(int page, int limit, String userId, String goodsId, String sort, String order) {
        List<Footprint> footprintPageByGoodsIdAndUserId = footprintMapper.findFootprintPageByGoodsIdAndUserId(userId, goodsId,sort,order);
        PageVO<Footprint> pagevo = new PageUtil<Footprint>().pagevo(page, limit, footprintPageByGoodsIdAndUserId);
        return pagevo;
    }
}