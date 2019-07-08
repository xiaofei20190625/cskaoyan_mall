package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Goods;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;

public interface GoodsService {
    ResponseVO<PageVO<Goods>> queryAll(int page, int limit);


    ResponseVO<PageVO<Goods>> fuzzyQuery(int page, int limit, String goodsSn, String name);

    int insert(Goods goods);

    int delete(Goods goods);

    Goods queryOneById(int id);

    int update(Goods goods);
}
