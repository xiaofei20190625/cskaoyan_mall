package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.OrderGoods;
import com.cskaoyan.mall.wx.bean.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByOid(Integer orderId);

    int insert(OrderGoods record);

    int insertSelective(OrderGoods record);

    OrderGoods selectByPrimaryKey(Integer id);

    OrderGoods selectByOrderIdAndGoodsId(@Param("orderId") Integer orderId,@Param("goodsId") Integer goodsId);

    List<OrderGoods> selectByOId(Integer orderId);

    int updateByPrimaryKeySelective(OrderGoods record);

    int updateByPrimaryKey(OrderGoods record);

    OrderInfo getOrderInfoByUidAndOid(Integer userId, Integer orderId);

}