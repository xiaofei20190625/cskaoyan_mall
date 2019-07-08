package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.bean.Collect;

public interface CollectService {

    PageVO<Collect> findCollectPageByValueIdAndUserId(int page, int limit, String userId, String valueId, String sort, String order);

}
