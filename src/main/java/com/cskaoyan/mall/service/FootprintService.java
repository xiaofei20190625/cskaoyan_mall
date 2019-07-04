package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Footprint;
import com.cskaoyan.mall.vo.PageVO;

public interface FootprintService {
    PageVO<Footprint> findFootprintPage(int page, int limit);

    PageVO<Footprint> findFootprintByUserId(int page, int limit, String userId);

    PageVO<Footprint> findFootprintPageByGoodsIdAndUserId(int page, int limit, String userId, String goodsId);

    PageVO<Footprint> findFootprintPageByGoodsId(int page, int limit, String goodsId);

}
