package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Collect;
import com.cskaoyan.mall.admin.vo.PageVO;

public interface CollectService {

    PageVO<Collect> findCollectPageByValueIdAndUserId(int page, int limit, String userId, String valueId, String sort, String order);

    int verifyCollectByUserIdAndGoodsId(int goodsId, Integer userId);
}
