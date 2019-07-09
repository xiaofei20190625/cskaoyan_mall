package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Goods;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;

import java.util.List;

public interface GoodsService {
    ResponseVO<PageVO<Goods>> queryAll(int page, int limit);


    ResponseVO<PageVO<Goods>> fuzzyQuery(int page, int limit, String goodsSn, String name);

    int insert(Goods goods);

    int delete(Goods goods);

    Goods queryOneById(int id);

    int update(Goods goods);

    List<Goods> getPageBrandsGoodsByIds( Boolean isNew, String order, String sort, int categoryId);

    List<Goods> getPageBrandsGoodsById(String brandId);
}
