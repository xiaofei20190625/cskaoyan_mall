package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Goods;
import com.cskaoyan.mall.admin.mapper.GoodsMapper;
import com.cskaoyan.mall.admin.service.GoodsService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.cskaoyan.mall.wx.bean.FloorGoods;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public ResponseVO<PageVO<Goods>> queryAll(int page, int limit) {
        PageHelper.startPage(page, limit);
        List<Goods> goods = goodsMapper.queryAll();
        PageInfo<Goods> pageInfo = new PageInfo<>(goods);
        PageVO<Goods> pageVO = new PageVO<>(pageInfo.getTotal(), pageInfo.getList());
        ResponseVO<PageVO<Goods>> responseVO = new ResponseVO<>(pageVO, "成功", 0);
        return responseVO;
    }

    @Override
    public ResponseVO<PageVO<Goods>> fuzzyQuery(int page, int limit, String goodsSn, String name) {
        PageHelper.startPage(page, limit);
        List<Goods> goods = goodsMapper.fuzzyQuery("%" + goodsSn + "%", "%" + name + "%");
        PageInfo<Goods> pageInfo = new PageInfo<>(goods);
        PageVO<Goods> pageVO = new PageVO<>(pageInfo.getTotal(), pageInfo.getList());
        ResponseVO<PageVO<Goods>> responseVO = new ResponseVO<>(pageVO, "成功", 0);
        return responseVO;
    }

    @Override
    public int insert(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public int delete(Goods goods) {
        return goodsMapper.delete(goods);
    }

    @Override
    public Goods queryOneById(int id) {
        return goodsMapper.queryOneById(id);
    }

    @Override
    public int update(Goods goods) {
        return goodsMapper.update(goods);
    }

    @Override
    public int getGoodsNum() {
        return goodsMapper.getGoodsNum();
    }

    @Override
    public List<FloorGoods> getWxFloorGoodsList() {
        return goodsMapper.getWxFloorGoods();
    }

    @Override
    public List<com.cskaoyan.mall.wx.bean.Goods> getWxHotGoodsList() {
        return goodsMapper.getWxHotGoodsList();
    }

    @Override
    public List<com.cskaoyan.mall.wx.bean.Goods> getWxNewGoodsList() {
        return goodsMapper.getWxNewGoodsList();
    }
}
