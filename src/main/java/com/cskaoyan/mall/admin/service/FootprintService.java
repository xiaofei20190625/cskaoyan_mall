package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Footprint;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.cskaoyan.mall.wx.bean.EchoFootprint;
import com.cskaoyan.mall.wx.vo.FootprintVO;

import java.util.List;

public interface FootprintService {

    PageVO<Footprint> findFootprintPageByGoodsIdAndUserId(int page, int limit, String userId, String goodsId, String sort, String order);

    ResponseVO<FootprintVO> findFootprintByUid(int page, int size, int userId);

}
