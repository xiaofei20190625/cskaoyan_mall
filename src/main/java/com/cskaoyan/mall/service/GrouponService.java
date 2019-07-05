package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Groupon;
import com.cskaoyan.mall.vo.PageVO;

public interface GrouponService {
    PageVO<Groupon> getListRecord(int page, int limit, String sort, String order, String goodsId);
}
