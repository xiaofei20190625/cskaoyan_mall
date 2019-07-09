package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.OrderGoods;

import java.util.List;

public interface OrderGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderGoods record);

    int insertSelective(OrderGoods record);

    OrderGoods selectByPrimaryKey(Integer id);

    List<OrderGoods> selectByOId(Integer orderId);

    int updateByPrimaryKeySelective(OrderGoods record);

    int updateByPrimaryKey(OrderGoods record);
}