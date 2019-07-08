package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Footprint;
import com.cskaoyan.mall.admin.vo.PageVO;

public interface FootprintService {

    PageVO<Footprint> findFootprintPageByGoodsIdAndUserId(int page, int limit, String userId, String goodsId, String sort, String order);

}
