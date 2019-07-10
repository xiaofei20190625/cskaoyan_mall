package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.Coupon;
import com.cskaoyan.mall.admin.service.CouponService;
import com.cskaoyan.mall.wx.bean.CouponAndCouponUser;
import com.cskaoyan.mall.wx.bean.CouponWx;
import com.cskaoyan.mall.wx.vo.BaseRespVO;
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
 * @date 2019/7/10 14:17
 * @Description TODO
 */
@RestController
@RequestMapping("/wx/coupon")
public class WxCouponController {

    @Autowired
    CouponService couponService;

    //http://192.168.2.100:8081/wx/coupon/list?page=1&size=10
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object wxGetList(int page, int size) {
        List<Coupon> topicList = couponService.wxGetList(page, size);
        int count = couponService.count();
        //键值对封装输出映射
        Map<Object, Object> result = new HashMap<>();
        result.put("count", count);
        result.put("data", topicList);
        return BaseRespVO.ok(result);
    }

    //http://192.168.2.100:8081/wx/coupon/mylist?status=2&page=1&size=10
    @RequestMapping(value = "mylist" ,method = RequestMethod.GET)
    public  Object mylist(int status , int page , int size){
        Map<Object ,Object> result = new HashMap<>();
        int count = couponService.count();
        List<CouponWx>  couponWxList = new ArrayList<>();
        if (status == 0){
            List<CouponAndCouponUser> couponList = couponService.myList(page , size , status);
            result.put("count", count);
            for (int i = 0; i < couponList.size(); i++) {
                CouponAndCouponUser ccu = couponList.get(i);
                CouponWx cwx = new CouponWx();
                cwx.setDesc(ccu.getCoupon().getDesc());
                cwx.setDiscount(ccu.getCoupon().getDiscount());
                cwx.setEndTime(ccu.getCouponUser().getEndTime());
                cwx.setId(ccu.getCoupon().getId());
                cwx.setMin(ccu.getCoupon().getMin());
                cwx.setName(ccu.getCoupon().getName());
                cwx.setStartTime(ccu.getCouponUser().getStartTime());
                cwx.setTag(ccu.getCoupon().getTag());
                couponWxList.add(cwx);
            }
            result.put("data", couponWxList);
            return BaseRespVO.ok(result);
        }else if (status == 1){
            List<CouponAndCouponUser> couponList = couponService.myList(page , size , status);
            result.put("count", count);
            for (int i = 0; i < couponList.size(); i++) {
                CouponAndCouponUser ccu = couponList.get(i);
                CouponWx cwx = new CouponWx();
                cwx.setDesc(ccu.getCoupon().getDesc());
                cwx.setDiscount(ccu.getCoupon().getDiscount());
                cwx.setEndTime(ccu.getCouponUser().getEndTime());
                cwx.setId(ccu.getCoupon().getId());
                cwx.setMin(ccu.getCoupon().getMin());
                cwx.setName(ccu.getCoupon().getName());
                cwx.setStartTime(ccu.getCouponUser().getStartTime());
                cwx.setTag(ccu.getCoupon().getTag());
                couponWxList.add(cwx);
            }
            result.put("data", couponWxList);
            return BaseRespVO.ok(result);
        } else if (status == 2){
            List<CouponAndCouponUser> couponList = couponService.myList(page , size , status);
            result.put("count", count);
            for (int i = 0; i < couponList.size(); i++) {
                CouponAndCouponUser ccu = couponList.get(i);
                CouponWx cwx = new CouponWx();
                cwx.setDesc(ccu.getCoupon().getDesc());
                cwx.setDiscount(ccu.getCoupon().getDiscount());
                cwx.setEndTime(ccu.getCouponUser().getEndTime());
                cwx.setId(ccu.getCoupon().getId());
                cwx.setMin(ccu.getCoupon().getMin());
                cwx.setName(ccu.getCoupon().getName());
                cwx.setStartTime(ccu.getCouponUser().getStartTime());
                cwx.setTag(ccu.getCoupon().getTag());
                couponWxList.add(cwx);
            }
            result.put("data", couponWxList);
            return BaseRespVO.ok(result);
        }else {
            return BaseRespVO.fail();
        }

    }






}
