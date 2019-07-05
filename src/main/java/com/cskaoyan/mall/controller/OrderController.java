package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Order;
import com.cskaoyan.mall.bean.OrderDetail;
import com.cskaoyan.mall.service.OrderService;
import com.cskaoyan.mall.vo.PageVO;
import com.cskaoyan.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("order/list")
    @ResponseBody
    public ResponseVO<PageVO> getPageOrders(int page, int limit,
                                            String sort, String order,
                                            String userId, String orderSn,
                                            String[] orderStatusArray){
        if (userId == null) userId = "";
        if (orderSn == null) orderSn = "";
        PageVO<Order> pageVO = orderService.getPageOrder(page, limit, sort, order, userId, orderSn, orderStatusArray);
        ResponseVO<PageVO> responseVO = new ResponseVO<>();
        responseVO.setData(pageVO);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }



    @RequestMapping("order/detail")
    @ResponseBody
    public ResponseVO<OrderDetail> getOrderDetailById(int id){
        OrderDetail orderDetail = orderService.getOrderDetailById(id);
        ResponseVO<OrderDetail> responseVO = new ResponseVO<>();
        if (orderDetail != null){
            responseVO.setData(orderDetail);
            responseVO.setErrno(0);
            responseVO.setErrmsg("成功");
        }
        return responseVO;
    }

}
