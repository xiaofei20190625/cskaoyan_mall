package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.mapper.GoodsMapper;
import com.cskaoyan.mall.service.GoodsService;
import com.cskaoyan.mall.vo.PageVO;
import com.cskaoyan.mall.vo.ResponseVO;
import com.github.pagehelper.Page;
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
}
