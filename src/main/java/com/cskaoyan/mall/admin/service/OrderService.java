package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Order;
import com.cskaoyan.mall.admin.bean.OrderDetail;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.cskaoyan.mall.wx.bean.OrderInfo;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/4 Time 17:46
 */
public interface OrderService {
    PageVO<Order> getListRecord(int page, int limit, String sort, String order, String goodsId);

    PageVO<Order> getPageOrder(int page, int limit, String sort, String order, String userId, String orderSn, String[] orderStatusArray);

    ResponseVO getAllOrdersByUid(Integer userId,int page, int size);

    ResponseVO getUnpayOrdersByUid(Integer userId,int page, int size);

    ResponseVO getReadyDeliverOrdersByUid(Integer userId,int page, int size);

    ResponseVO getUnConfirmOrdersByUid(Integer userId,int page, int size);

    ResponseVO getUnAssessOrdersByUid(Integer userId,int page, int size);

    ResponseVO showOrderDetailByOid(Integer orderId);

    OrderDetail getOrderDetailById(int id);

    Order selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);


    OrderInfo selectByOid(Integer orderId);
}

