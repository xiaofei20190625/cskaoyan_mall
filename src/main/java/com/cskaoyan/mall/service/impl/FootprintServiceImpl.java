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
    public PageVO<Footprint> findFootprintPage(int page, int limit) {
        List<Footprint> footprintPage = footprintMapper.findFootprintPage();
        PageVO<Footprint> footprintPageVO = new PageUtil<Footprint>().pagevo(page,limit,footprintPage);
        return footprintPageVO;
    }

    @Override
    public PageVO<Footprint> findFootprintByUserId(int page, int limit, String userId) {
        List<Footprint> footprintByUserId = footprintMapper.findFootprintByUserId(userId);
        PageVO<Footprint> pagevo = new PageUtil<Footprint>().pagevo(page, limit, footprintByUserId);
        return pagevo;
    }

    @Override
    public PageVO<Footprint> findFootprintPageByGoodsIdAndUserId(int page, int limit, String userId, String goodsId) {
        List<Footprint> footprintPageByGoodsIdAndUserId = footprintMapper.findFootprintPageByGoodsIdAndUserId(userId, goodsId);
        PageVO<Footprint> pagevo = new PageUtil<Footprint>().pagevo(page, limit, footprintPageByGoodsIdAndUserId);
        return pagevo;
    }

    @Override
    public PageVO<Footprint> findFootprintPageByGoodsId(int page, int limit, String goodsId) {
        List<Footprint> footprintPageByGoodsId = footprintMapper.findFootprintPageByGoodsId(goodsId);
        PageVO<Footprint> pagevo = new PageUtil<Footprint>().pagevo(page, limit, footprintPageByGoodsId);
        return pagevo;
    }

}
