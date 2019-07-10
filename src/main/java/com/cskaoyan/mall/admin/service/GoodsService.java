package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Goods;
import com.cskaoyan.mall.admin.bean.GoodsToGroupon;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.cskaoyan.mall.wx.bean.FloorGoods;
import com.cskaoyan.mall.wx.bean.GoodsWx;
import com.github.pagehelper.PageInfo;

import java.util.List;

import java.util.List;

public interface GoodsService {
    ResponseVO<PageVO<Goods>> queryAll(int page, int limit);


    ResponseVO<PageVO<Goods>> fuzzyQuery(int page, int limit, String goodsSn, String name);

    int insert(Goods goods);

    int delete(Goods goods);

    Goods queryOneById(int id);

    int update(Goods goods);


    List<Goods> getPageBrandsGoodsByIds( Boolean isNew, String order, String sort, int categoryId, String keyword);

    List<Goods> getPageBrandsGoodsById(String brandId);

    int getGoodsNum();

    List<FloorGoods> getWxFloorGoodsList();

    List<GoodsWx> getWxHotGoodsList();

    List<GoodsWx> getWxNewGoodsList();

    GoodsToGroupon getGoodsWx(Integer goodsId);

    List<GoodsWx> getWxRelatedGoods(Integer id);

}
