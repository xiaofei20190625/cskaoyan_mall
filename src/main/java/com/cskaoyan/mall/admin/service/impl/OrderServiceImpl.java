package com.cskaoyan.mall.admin.service.impl;
import com.cskaoyan.mall.admin.bean.Goods;
import com.cskaoyan.mall.admin.bean.OrderDetail;
import com.cskaoyan.mall.admin.bean.OrderGoods;
import com.cskaoyan.mall.admin.mapper.OrderGoodsMapper;
import com.cskaoyan.mall.admin.mapper.OrderMapper;
import com.cskaoyan.mall.admin.service.OrderService;
import com.cskaoyan.mall.admin.bean.Order;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.cskaoyan.mall.wx.bean.HandleOption;
import com.cskaoyan.mall.wx.bean.OrderResponse;
import com.cskaoyan.mall.wx.vo.DataListVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class OrderServiceImpl  implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderGoodsMapper orderGoodsMapper;

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
    public ResponseVO getAllOrdersByUid(Integer userId,int page, int size) {
        List<Order> orders = orderMapper.selectAllByUid(userId);
        ResponseVO responseVO = getResponseVOByOrderList(orders, userId, page, size);
        return responseVO;
    }

    @Override
    public ResponseVO getUnpayOrdersByUid(Integer userId, int page, int size) {
        List<Order> orders = orderMapper.selectUnpayByUid(userId);
        ResponseVO responseVO = getResponseVOByOrderList(orders, userId, page, size);
        return responseVO;
    }

    @Override
    public ResponseVO getReadyDeliverOrdersByUid(Integer userId, int page, int size) {
        List<Order> orders = orderMapper.selectReadyDeliverOrdersByUid(userId);

        ResponseVO responseVO = getResponseVOByOrderList(orders, userId, page, size);
        return responseVO;
    }

    @Override
    public ResponseVO getUnConfirmOrdersByUid(Integer userId, int page, int size) {
        List<Order> orders = orderMapper.selectUnConfirmOrdersByUid(userId);
        ResponseVO responseVO = getResponseVOByOrderList(orders, userId, page, size);
        return responseVO;
    }

    @Override
    public ResponseVO getUnAssessOrdersByUid(Integer userId, int page, int size) {
        List<Order> orders = orderMapper.selectUnAssessOrdersByUid(userId);
        ResponseVO responseVO = getResponseVOByOrderList(orders, userId, page, size);
        return responseVO;    }

    public ResponseVO getResponseVOByOrderList(List<Order> orders, Integer userId,int page, int size) {
        PageHelper.startPage(page, size);
        //dataListVO中的data
        List<OrderResponse> orderResponseList = new LinkedList<>();
        for (Order order : orders) {
            Integer orderId = order.getId();
            OrderResponse orderResponse = new OrderResponse();
            HandleOption handleOption = new HandleOption();
            Short status = order.getOrderStatus();
            switch (status) {
                case 101:
                    HandleOption.set101(handleOption);
                    orderResponse.setOrderStatusText("未支付");
                    break;
                case 102:
                    HandleOption.set102(handleOption);
                    orderResponse.setOrderStatusText("已取消");
                    break;
                case 103:
                    HandleOption.set103(handleOption);
                    orderResponse.setOrderStatusText("已取消(系统)");
                    break;
                case 201:
                    HandleOption.set201(handleOption);
                    orderResponse.setOrderStatusText("已付款");
                    break;
                case 202:
                    HandleOption.set202(handleOption);
                    orderResponse.setOrderStatusText("已付款");
                    break;
                case 301:
                    HandleOption.set301(handleOption);
                    orderResponse.setOrderStatusText("已发货");
                    break;
                case 401:
                    HandleOption.set401(handleOption);
                    orderResponse.setOrderStatusText("已收货");
                    break;
                case 402:
                    HandleOption.set402(handleOption);
                    orderResponse.setOrderStatusText("已收货");
                    break;
            }
            //注入id
            orderResponse.setId(orderId);
            //注入goodsSn
            orderResponse.setOrderSn(order.getOrderSn());
            //注入HandleOption
            orderResponse.setHandleOption(handleOption);
            //注入actualPrice
            orderResponse.setActualPrice(order.getActualPrice());
            //注入isGroupin
            orderResponse.setGroupin(false);
            //根据orderId查出所有的OrderGoods,并注入goodsList
            List<OrderGoods> orderGoods = orderGoodsMapper.selectByOId(orderId);
            orderResponse.setGoodsList(orderGoods);
            orderResponseList.add(orderResponse);
        }
        PageInfo<OrderResponse> pageInfo = new PageInfo<>(orderResponseList);
        //dataListVO里面需要封装OrderResponse的list
        DataListVO dataListVO = new DataListVO(pageInfo.getTotal(), pageInfo.getList(), pageInfo.getPages());
        ResponseVO responseVO = new ResponseVO(dataListVO, "成功", 0);
        return responseVO;
    }

    @Override
    public OrderDetail getOrderDetailById(int id) {
        return orderMapper.queryOrderDetailById(id);
    }

}
