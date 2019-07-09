package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Footprint;
import com.cskaoyan.mall.admin.bean.PageList;
import com.cskaoyan.mall.admin.mapper.FootprintMapper;
import com.cskaoyan.mall.admin.service.FootprintService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.cskaoyan.mall.wx.bean.EchoFootprint;
import com.cskaoyan.mall.wx.vo.FootprintVO;
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
        PageVO<Footprint> pagevo = new PageList<Footprint>().pagevo(page, limit, footprintPageByGoodsIdAndUserId);
        return pagevo;
    }

    @Override
    public ResponseVO<FootprintVO> findFootprintByUid(int page, int size, int userId) {
        PageHelper.startPage(page, size);
        List<EchoFootprint> echoFootprints = footprintMapper.echoFootprintListByUid(userId);
        PageInfo<EchoFootprint> pageInfo = new PageInfo<>(echoFootprints);
        FootprintVO footprintVO = new FootprintVO(pageInfo.getList(), pageInfo.getTotal());
        ResponseVO responseVO = new ResponseVO(footprintVO, "成功", 0);
        return responseVO;
    }
}
