package com.cskaoyan.mall.admin.service.impl;
import com.cskaoyan.mall.admin.bean.OrderDetail;
import com.cskaoyan.mall.admin.mapper.OrderMapper;
import com.cskaoyan.mall.admin.service.OrderService;
import com.cskaoyan.mall.admin.bean.Order;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderServiceImpl  implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public PageVO<Order> getListRecord(int page, int limit, String sort, String order, String goodsId) {
        return null;
    }

    @Override
    public PageVO<Order> getPageOrder(int page, int limit, String sort, String order, String userId, String orderSn, String[] orderStatusArray) {
        PageHelper.startPage(page, limit);
        List<Order> orders = orderMapper.queryPageOrder(sort, order, userId, orderSn, orderStatusArray);
        PageInfo<Order> pageInfo = new PageInfo<>(orders);
        PageVO<Order> pageVO = new PageVO<>(pageInfo.getTotal(), pageInfo.getList());
        return pageVO;
    }

    @Override
    public OrderDetail getOrderDetailById(int id) {
        return orderMapper.queryOrderDetailById(id);
    }

}
