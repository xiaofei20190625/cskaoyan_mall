package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Address;
import com.cskaoyan.mall.admin.bean.Footprint;
import com.cskaoyan.mall.admin.bean.PageList;
import com.cskaoyan.mall.admin.mapper.FootprintMapper;
import com.cskaoyan.mall.admin.service.FootprintService;
import com.cskaoyan.mall.admin.vo.PageVO;
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
        PageVO<Footprint> pagevo = new PageList<Footprint>().pagevo(page, limit, footprintPageByGoodsIdAndUserId);
        return pagevo;
    }
}
