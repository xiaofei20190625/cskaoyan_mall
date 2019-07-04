package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Footprint;
import com.cskaoyan.mall.vo.PageVO;

public interface FootprintService {

    PageVO<Footprint> findFootprintPageByGoodsIdAndUserId(int page, int limit, String userId, String goodsId, String sort, String order);

}
