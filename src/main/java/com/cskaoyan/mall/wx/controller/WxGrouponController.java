package com.cskaoyan.mall.wx.controller;


import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.service.*;
import com.cskaoyan.mall.admin.vo.BaseRespVo;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.cskaoyan.mall.wx.bean.*;
import com.cskaoyan.mall.wx.vo.ListVo;
import com.cskaoyan.mall.wx.vo.TopicCountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alex_Cheng
 * @date 2019/7/9 11:40
 * @Description TODO
 */
@RestController
@RequestMapping("/wx/groupon")
public class WxGrouponController {

    @Autowired
    GrouponRulesService grouponRulesService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    GrouponService grouponService ;
    @Autowired
    OrderService orderService;
    @Autowired
    UserVipService userVipService;



    //   http://192.168.2.100:8081/wx/groupon/list?page=1&size=10
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object wxGetList(int page, int size) {
        List<GrouponRules> grouponRulesList = grouponRulesService.wxGetList(page, size);
        int count = grouponRulesService.count();
        Map<Object , Object> result = new HashMap<>();
        result.put("count", count);
        //TopicCountVO<List> topicVO = new TopicCountVO<>();
        List<GrouponAndGoods> data = new ArrayList<>();
        for (int i = 0; i < grouponRulesList.size(); i++) {
            GoodsToGroupon goodsWx = goodsService.getGoodsWx(grouponRulesList.get(i).getGoodsId());
            GrouponAndGoods grouponAndGoods = new GrouponAndGoods();
            grouponAndGoods.setGoods(goodsWx);
            grouponAndGoods.setGroupon_member(grouponRulesList.get(i).getDiscountMember());
            grouponAndGoods.setGroupon_price(grouponAndGoods.getGoods().getRetailPrice() - grouponRulesList.get(i).getDiscount());
            data.add(grouponAndGoods);
        }
        //List<GrouponAndGoods> data = grouponAndGoodsList ;
        //ListVo<GrouponAndGoods> data = new ListVo<>();
        //data.setData(grouponAndGoodsList);
/*        topicVO.setCount(grouponRulesList.size());
        topicVO.setData(grouponAndGoodsList);
        responseVO.setData(topicVO);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;*/
        result.put("data",data);
        return  BaseRespVo.ok(result);
    }

    //http://localhost:8080/wx/groupon/my?showType=0
    //http://localhost:8080/wx/groupon/my?showType=1
/*      订单状态：
            101 订单生成，未支付；
            102，下单后未支付用户取消；
            103，下单后未支付超时系统自动取消
            201 支付完成，商家未发货；
            202，订单生产，已付款未发货，但是退款取消；
            301 商家发货，用户未确认；
            401 用户确认收货； 402 用户没有确认收货超过一定时间，系统自动确认收货；
            401*/
    @RequestMapping("my")
    public  Object my(int showType){
        Map<Object ,Object> result = new HashMap<>();
        if (showType == 0){
            List<GrouponMy> data = new ArrayList<>();

            List<Groupon> gList = grouponService.queryAll();
            int count = grouponService.count();
            for (int i = 0; i < gList.size(); i++) {
                //每次循环都要实例对象添加属性
                GrouponMy grouponMy = new GrouponMy();
                Groupon groupon = gList.get(i);
                Integer orderId = groupon.getOrderId();
                Order order = orderService.selectByPrimaryKey(orderId);

                //int actualPrice;
                grouponMy.setActualPrice(order.getActualPrice());
                Integer userId = order.getUserId();
                UserVip userVip = userVipService.findUserVipByiD(userId);
                //String creator;
                grouponMy.setCreator(userVip.getNickname());
                //String[] goodsList;
                String[] strings ={};
                grouponMy.setGoodsList(strings);
                //Groupon groupon;
                grouponMy.setGroupon(groupon);
                //HandleOption handleOption;
                OrderResponse orderResponse = new OrderResponse();
                HandleOption handleOption = new HandleOption();
                Short status = order.getOrderStatus();
                switch (status) {
                    case 101:
                        HandleOption.set101(handleOption);
                        orderResponse.setOrderStatusText("未付款");
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
                grouponMy.setHandleOption(handleOption);
                //int id ;
                grouponMy.setId(groupon.getId());

                //Boolean isCreator;
                Integer creatorUserId = groupon.getCreatorUserId();
                Integer userId1 = groupon.getUserId();
                if (creatorUserId == userId1){
                    grouponMy.setCreator(true);
                }else
                    grouponMy.setCreator(false);

                //int joinerCount ;
                int joinerCount = grouponService.countGrouponId();
                grouponMy.setJoinerCount(joinerCount);

                //int orderId;
                grouponMy.setOrderId(order.getId());
                //String orderSn;
                grouponMy.setOrderSn(order.getOrderSn());
                //String orderStatusText;
                grouponMy.setOrderStatusText(orderResponse.getOrderStatusText());

                //GrouponRules rules;
                Integer rulesId = groupon.getRulesId();
                GrouponRules rules = grouponRulesService.getRulesId(rulesId);
                grouponMy.setRules(rules);

                data.add(grouponMy);
            }
            result.put("count" ,count);
            result.put("data" ,data);
            return BaseRespVo.ok(result);
        }else if(showType == 1)  {
            String[] data = {};
            result.put("count" ,0);
            result.put("data" ,data);
            return BaseRespVo.ok(result);
        }else {
            return BaseRespVo.fail();
        }
    }

    @RequestMapping("detail")
    public  BaseRespVo detail(int grouponId){
        BaseRespVo baseRespVo = new BaseRespVo();
        GrouponDetail data = new GrouponDetail();
        Groupon groupon = grouponService.getGrouponId(grouponId);

        //Creator creator ;
        UserVip user = userVipService.findUserVipByiD(groupon.getCreatorUserId());
        Creator creator = new Creator();
        creator.setAvatar(user.getAvatar());
        creator.setNickname(user.getNickname());
        data.setCreator(creator);

        //Groupon groupon;
        data.setGroupon(groupon);

        //Joiners joiners;
        if (groupon.getGrouponId() == 0){
            List<Joiners> joinersList = new ArrayList<>();
            Joiners joiners = new Joiners(user.getAvatar() ,user.getNickname());
            joinersList.add(joiners);
            data.setJoiners(joinersList);
        }else {
            data.setJoiners(null);
        }

        //int linkGrouponId;
        data.setLinkGrouponId(1);

        //String[] orderGoods;
        String[] orderGoods = {};
        data.setOrderGoods(orderGoods);

        //OrderInfo orderInfo;
        OrderInfo orderInfo = orderService.selectByOid(groupon.getOrderId());
        Order order = orderService.selectByPrimaryKey(groupon.getOrderId());
        HandleOption handleOption = new HandleOption();
        Short status = order.getOrderStatus();
        switch (status) {
            case 101:
                HandleOption.set101(handleOption);
                orderInfo.setHandleOption(handleOption);
                orderInfo.setOrderStatusText("未付款");
                break;
            case 102:
                HandleOption.set102(handleOption);
                orderInfo.setHandleOption(handleOption);
                orderInfo.setOrderStatusText("已取消");
                break;
            case 103:
                HandleOption.set103(handleOption);
                orderInfo.setHandleOption(handleOption);
                orderInfo.setOrderStatusText("已取消(系统)");
                break;
            case 201:
                HandleOption.set201(handleOption);
                orderInfo.setHandleOption(handleOption);
                orderInfo.setOrderStatusText("已付款");
                break;
            case 202:
                HandleOption.set202(handleOption);
                orderInfo.setHandleOption(handleOption);
                orderInfo.setOrderStatusText("已付款");
                break;
            case 301:
                HandleOption.set301(handleOption);
                orderInfo.setHandleOption(handleOption);
                orderInfo.setOrderStatusText("已发货");
                break;
            case 401:
                HandleOption.set401(handleOption);
                orderInfo.setHandleOption(handleOption);
                orderInfo.setOrderStatusText("已收货");
                break;
            case 402:
                HandleOption.set402(handleOption);
                orderInfo.setHandleOption(handleOption);
                orderInfo.setOrderStatusText("已收货");
                break;
        }
        data.setOrderInfo(orderInfo);

        //GrouponRules rules;
        GrouponRules rules = grouponRulesService.getRulesId(groupon.getRulesId());
        data.setRules(rules);

        baseRespVo.setData(data);
        baseRespVo.setErrmsg("成功");
        baseRespVo.setErrno(0);
        return  baseRespVo;
    }
}
