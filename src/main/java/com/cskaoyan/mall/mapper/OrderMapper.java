package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Order;
import com.cskaoyan.mall.bean.OrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);


    List<Order> queryPageOrder(@Param("sort") String sort,
                               @Param("order") String order,
                               @Param("userId") String userId,
                               @Param("orderSn") String orderSn,
                               @Param("statuss") String[] orderStatusArray);

    OrderDetail queryOrderDetailById(@Param("id") int id);
}