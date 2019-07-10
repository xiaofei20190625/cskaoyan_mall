package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.admin.bean.OrderGoods;
import com.cskaoyan.mall.admin.mapper.OrderGoodsMapper;
import com.cskaoyan.mall.wx.service.OrderGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderGoodsServiceImpl implements OrderGoodsService {
    @Autowired
    OrderGoodsMapper orderGoodsMapper;
    @Override
    public int deleteByOid(Integer orderId) {
        return orderGoodsMapper.deleteByOid(orderId);
    }

    @Override
    public OrderGoods selectByPrimaryKey(Integer id) {
        return orderGoodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public OrderGoods selectByOrderIdAndGoodsId(Integer orderId, Integer goodsId) {
        return orderGoodsMapper.selectByOrderIdAndGoodsId(orderId, goodsId);
    }

    @Override
    public int updateByPrimaryKey(OrderGoods record) {
        return orderGoodsMapper.updateByPrimaryKey(record);
    }
}
