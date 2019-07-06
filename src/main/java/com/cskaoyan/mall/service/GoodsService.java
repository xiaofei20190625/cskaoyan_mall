package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.vo.PageVO;
import com.cskaoyan.mall.vo.ResponseVO;

public interface GoodsService {
    ResponseVO<PageVO<Goods>> queryAll(int page, int limit);


    ResponseVO<PageVO<Goods>> fuzzyQuery(int page, int limit, String goodsSn, String name);

    int insert(Goods goods);

    int delete(Goods goods);

    Goods queryOneById(int id);

    int update(Goods goods);
}
