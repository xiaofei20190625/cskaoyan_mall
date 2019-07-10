package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.OrderGoods;
import com.cskaoyan.mall.admin.mapper.OrderGoodsMapper;
import com.cskaoyan.mall.admin.service.OrderService;
import com.cskaoyan.mall.admin.vo.OperationVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.cskaoyan.mall.wx.service.OrderGoodsService;
import com.cskaoyan.mall.wx.userwx.UserTokenManager;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("wx")
public class OrderWXController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderGoodsService orderGoodsService;
    @Autowired
    OrderGoodsMapper orderGoodsMapper;
    //各种订单显示
    @RequestMapping("order/list")
    public ResponseVO getUnpayOrderList(int showType, int page, int size, HttpServletRequest request) {
        //获得请求头
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        switch (showType) {
            //返回所有订单
            case 0:
                ResponseVO responseVO = orderService.getAllOrdersByUid(userId, page, size);
                return responseVO;
            //返回待付款订单
            case 1:
                ResponseVO responseVO1 = orderService.getUnpayOrdersByUid(userId, page, size);
                return  responseVO1;
            //返回待发货订单
            case 2:
                ResponseVO responseVO2 = orderService.getReadyDeliverOrdersByUid(userId, page, size);
                return  responseVO2;
            //返回待收货订单
            case 3:
                ResponseVO responseVO3 = orderService.getUnConfirmOrdersByUid(userId, page, size);
                return  responseVO3;
            //返回待评价订单
            case 4:
                ResponseVO responseVO4 = orderService.getUnAssessOrdersByUid(userId, page, size);
                return  responseVO4;
            default:
                return new ResponseVO();
        }


    }

    //订单详情
    @RequestMapping("order/detail")
    public ResponseVO getOrderDetail(int orderId) {
        ResponseVO responseVO = orderService.showOrderDetailByOid(orderId);
        return responseVO;
    }

    //取消订单
    //http://192.168.2.100:8081/wx/order/cancel
    @RequestMapping("order/cancel")
    public OperationVO cancelOrder(@RequestBody String jsonOrderId) {
        JsonParser jsonParser = new JsonParser();
        JsonObject object = jsonParser.parse(jsonOrderId).getAsJsonObject();
        int orderId = object.get("orderId").getAsInt();
        int delete1 = orderService.deleteByPrimaryKey(orderId);
        int delete2 = orderGoodsService.deleteByOid(orderId);
        if (delete1 == 1 && delete2 >= 1) {
            OperationVO operationVO = new OperationVO(0, "成功");
            return operationVO;
        } else {
            OperationVO operationVO = new OperationVO(-1, "失败");
            return operationVO;
        }
    }

}
