package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.vo.PageVO;
import com.cskaoyan.mall.vo.ResponseVO;

public interface GoodsService {
    ResponseVO<PageVO<Goods>> queryAll(int page, int limit);

    int insert(Goods goods);
}
