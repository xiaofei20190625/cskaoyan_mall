package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.service.StatisticalService;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.cskaoyan.mall.admin.vo.StatisticalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticalController {
   @Autowired
    StatisticalService statisticalService;

    /**
     * 统计报表 用户统计
     * @return 用户数据
     */
    @RequestMapping("stat/user")
    public ResponseVO<StatisticalVO> statUser(){
        StatisticalVO statistical = statisticalService.queryStatistical();
        ResponseVO<StatisticalVO> statisticalResponseVO = responseVO(statistical);
        return statisticalResponseVO;
    }

    private ResponseVO<StatisticalVO> responseVO(StatisticalVO statistical) {
        ResponseVO<StatisticalVO> ResponseVO =new ResponseVO<>();
        if (statistical!=null){
            ResponseVO.setData(statistical);
            ResponseVO.setErrmsg("成功");
            ResponseVO.setErrno(0);
            return ResponseVO;
        }else {
            ResponseVO.setErrmsg("失败");
            ResponseVO.setErrno(-1);
            return ResponseVO;
        }
    }

    /**
     * 统计报表 订单统计
     * @return 订单数据
     */
    @RequestMapping("stat/order")
    public ResponseVO<StatisticalVO> statOrder(){
        StatisticalVO statistical = statisticalService.queryStatisticalOrder();
        ResponseVO<StatisticalVO> statisticalResponseVO = responseVO(statistical);
        return statisticalResponseVO;
    }

    /**
     * 统计报表 商品统计
     * @return 商品数据
     */
    @RequestMapping("stat/goods")
    public ResponseVO<StatisticalVO> statGoods(){
        StatisticalVO statistical = statisticalService.queryStatisticalGoods();
        ResponseVO<StatisticalVO> statisticalResponseVO = responseVO(statistical);
        return statisticalResponseVO;
    }
}
