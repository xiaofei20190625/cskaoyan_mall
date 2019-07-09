package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Goods;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.cskaoyan.mall.wx.bean.FloorGoods;

import java.util.List;

public interface GoodsService {
    ResponseVO<PageVO<Goods>> queryAll(int page, int limit);


    ResponseVO<PageVO<Goods>> fuzzyQuery(int page, int limit, String goodsSn, String name);

    int insert(Goods goods);

    int delete(Goods goods);

    Goods queryOneById(int id);

    int update(Goods goods);

    int getGoodsNum();

    List<FloorGoods> getWxFloorGoodsList();

    List<com.cskaoyan.mall.wx.bean.Goods> getWxHotGoodsList();

    List<com.cskaoyan.mall.wx.bean.Goods> getWxNewGoodsList();
}
