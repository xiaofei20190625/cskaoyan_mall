package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.Comment;
import com.cskaoyan.mall.admin.bean.Order;
import com.cskaoyan.mall.admin.bean.OrderGoods;
import com.cskaoyan.mall.admin.mapper.OrderGoodsMapper;
import com.cskaoyan.mall.admin.service.CommentService;
import com.cskaoyan.mall.admin.service.OrderService;
import com.cskaoyan.mall.admin.vo.OperationVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.cskaoyan.mall.wx.bean.NewOrderMsg;
import com.cskaoyan.mall.wx.service.OrderGoodsService;
import com.cskaoyan.mall.wx.userwx.UserTokenManager;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
    @Autowired
    CommentService commentService;

    //提交订单
    //http://192.168.2.100:8081/wx/order/submit
    @RequestMapping("order/submit")
    public ResponseVO submitOrder(@RequestBody NewOrderMsg newOrderMsg) {
        Order order = new Order();
        return null;
    }
    //各种订单显示
    @RequestMapping("order/list")
    public ResponseVO getOrderList(int showType, int page, int size, HttpServletRequest request) {
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

    //用户直接取消订单
    @RequestMapping("order/cancel")
    public OperationVO cancelOrder(@RequestBody String jsonOrderId) {
        JsonParser jsonParser = new JsonParser();
        JsonObject object = jsonParser.parse(jsonOrderId).getAsJsonObject();
        int orderId = object.get("orderId").getAsInt();
        int cancle = orderService.cancleOrderByOid(orderId);
        if (cancle == 1) {
            OperationVO operationVO = new OperationVO(0, "成功");
            return operationVO;
        } else {
            OperationVO operationVO = new OperationVO(-1, "失败");
            return operationVO;
        }
    }
    //退款取消订单
    @RequestMapping("order/refund")
    public OperationVO refundCancelOrder(@RequestBody String jsonOrderId) {
        JsonParser jsonParser = new JsonParser();
        JsonObject object = jsonParser.parse(jsonOrderId).getAsJsonObject();
        int orderId = object.get("orderId").getAsInt();
        int refundCancle = orderService.refundOrderByOid(orderId);
        if (refundCancle == 1) {
            OperationVO operationVO = new OperationVO(0, "成功");
            return operationVO;
        } else {
            OperationVO operationVO = new OperationVO(-1, "失败");
            return operationVO;
        }
    }
    //确认收货
    @RequestMapping("order/confirm")
    public OperationVO confirmOrder(@RequestBody String jsonOrderId) {
        JsonParser jsonParser = new JsonParser();
        JsonObject object = jsonParser.parse(jsonOrderId).getAsJsonObject();
        int orderId = object.get("orderId").getAsInt();
        int confirm = orderService.confirmByOid(orderId);
        if (confirm == 1) {
            OperationVO operationVO = new OperationVO(0, "成功");
            return operationVO;
        } else {
            OperationVO operationVO = new OperationVO(-1, "失败");
            return operationVO;
        }
    }
    //删除订单
    //http://192.168.2.100:8081/wx/order/delete
    @RequestMapping("order/delete")
    public OperationVO deleteOrder(@RequestBody String jsonOrderId) {
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

    //商品评论页面回显
    @RequestMapping("order/goods")
    public ResponseVO echoCommentPage(Integer orderId, Integer goodsId) {
        OrderGoods orderGoods = orderGoodsService.selectByOrderIdAndGoodsId(orderId, goodsId);
        ResponseVO<OrderGoods> responseVO = new ResponseVO<>(orderGoods, "成功", 0);
        return responseVO;
    }

    //评论的提交
    //http://192.168.2.100:8081/wx/order/comment
    @RequestMapping("order/comment")
    public OperationVO submitComment(@RequestBody Comment comment, HttpServletRequest request) {
        //获得请求头
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        comment.setUserId(userId);
        comment.setType((byte)0);
        Date now = new Date();
        comment.setAddTime(now);
        comment.setUpdateTime(now);
        OrderGoods orderGoods = orderGoodsService.selectByPrimaryKey(comment.getOrderGoodsId());
        Integer goodsId = orderGoods.getGoodsId();
        comment.setValueId(goodsId);
        int insert = commentService.insert(comment);
        Integer commentId = comment.getId();
        orderGoods.setComment(commentId);
        int update = orderGoodsService.updateByPrimaryKey(orderGoods);
        if (insert == 1 && update == 1) {
            return new OperationVO(0, "成功");
        } else {
            return new OperationVO(-1, "失败");
        }
    }
}
