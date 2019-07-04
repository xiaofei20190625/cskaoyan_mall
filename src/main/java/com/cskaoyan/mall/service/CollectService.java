package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Collect;
import com.cskaoyan.mall.vo.PageVO;

public interface CollectService {

    PageVO<Collect> findCollectPageByValueIdAndUserId(int page, int limit, String userId, String valueId, String sort, String order);

}
