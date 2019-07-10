package com.cskaoyan.mall.wx.service;

import com.cskaoyan.mall.admin.bean.OrderGoods;

public interface OrderGoodsService {
    int deleteByOid(Integer orderId);

    OrderGoods selectByPrimaryKey(Integer id);

    OrderGoods selectByOrderIdAndGoodsId(Integer orderId,Integer goodsId);

    int updateByPrimaryKey(OrderGoods record);

}
