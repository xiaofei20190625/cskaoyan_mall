package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Collect;
import com.cskaoyan.mall.vo.PageVO;

public interface CollectService {
    PageVO<Collect> findCollectPage(int page, int limit);

    PageVO<Collect> findCollectByUserId(int page, int limit, String userId);

    PageVO<Collect> findCollectPageByValueIdAndUserId(int page, int limit, String userId, String valueId);

    PageVO<Collect> findCollectPageByValueId(int page, int limit, String valueId);
}
