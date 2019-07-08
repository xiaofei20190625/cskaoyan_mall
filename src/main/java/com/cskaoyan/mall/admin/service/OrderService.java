package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Order;
import com.cskaoyan.mall.admin.bean.OrderDetail;
import com.cskaoyan.mall.admin.vo.PageVO;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/4 Time 17:46
 */
public interface OrderService {
    PageVO<Order> getListRecord(int page, int limit, String sort, String order, String goodsId);

    PageVO<Order> getPageOrder(int page, int limit, String sort, String order, String userId, String orderSn, String[] orderStatusArray);

    OrderDetail getOrderDetailById(int id);
}

