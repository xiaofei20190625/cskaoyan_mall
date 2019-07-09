package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Order;
import com.cskaoyan.mall.admin.bean.OrderDetail;
import com.cskaoyan.mall.wx.bean.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    OrderInfo selectByOid(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);


    List<Order> queryPageOrder(@Param("sort") String sort,
                               @Param("order") String order,
                               @Param("userId") String userId,
                               @Param("orderSn") String orderSn,
                               @Param("statuss") String[] orderStatusArray);

    List<Order> selectAllByUid(Integer userId);

    OrderDetail queryOrderDetailById(@Param("id") int id);

    List<Order> selectUnpayByUid(Integer userId);

    List<Order> selectReadyDeliverOrdersByUid(Integer userId);

    List<Order> selectUnConfirmOrdersByUid(Integer userId);

    List<Order> selectUnAssessOrdersByUid(Integer userId);
}