package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.Coupon;
import com.cskaoyan.mall.admin.bean.CouponUser;
import com.cskaoyan.mall.admin.service.CouponService;
import com.cskaoyan.mall.admin.service.CouponUserService;
import com.cskaoyan.mall.admin.vo.OperationVO;
import com.cskaoyan.mall.wx.bean.CouponAndCouponUser;
import com.cskaoyan.mall.wx.bean.CouponWx;
import com.cskaoyan.mall.wx.userwx.UserTokenManager;
import com.cskaoyan.mall.wx.utils.JSONUtils;
import com.cskaoyan.mall.wx.vo.BaseRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    CouponUserService couponUserService;

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
    @RequestMapping(value = "mylist", method = RequestMethod.GET)
    public Object mylist(int status, int page, int size) {
        Map<Object, Object> result = new HashMap<>();
        int count = couponService.count();
        List<CouponWx> couponWxList = new ArrayList<>();

        if (status == 0) {

            List<CouponAndCouponUser> couponList = couponService.myList(page, size, status);
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
                System.out.println("userid" + ccu.getCouponUser().getUserId());
            }
            result.put("data", couponWxList);
            return BaseRespVO.ok(result);
        } else if (status == 1) {
            List<CouponAndCouponUser> couponList = couponService.myList(page, size, status);
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
        } else if (status == 2) {
            List<CouponAndCouponUser> couponList = couponService.myList(page, size, status);
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
        } else {
            return BaseRespVO.fail();
        }
    }

    //errmsg:"优惠券已领完"errno:740
    //成功 ， 0
    @RequestMapping(value = "receive" , method = RequestMethod.POST)
    public OperationVO receive(@RequestBody Map<String , Object> data ,HttpServletRequest request) {

/*        OperationVO operationVO = new OperationVO();
        operationVO.setErrmsg("成功");
        operationVO.setErrno(0);
        return operationVO;
    }*/

        String tokenKey = request.getHeader("X-Litemall-Token");
        int userId = UserTokenManager.getUserId(tokenKey);
        //int userId = 1 ;
        System.out.println("CouponuserId = " + userId);

        int couponId = (int) data.get("couponId");

        OperationVO operationVO = new OperationVO();
        Coupon coupon = couponService.queryCouponById(couponId);
        int total = coupon.getTotal();
        Short limit = coupon.getLimit();
        Short number = 0;
        if (total == 0) {
            if (limit == 1) {
                CouponUser couponUser = couponUserService.queryByCouponId(couponId);
                if (couponUser == null) {

                    int i = couponUserService.insert(userId, couponId, coupon.getStartTime(), coupon.getEndTime(), new Date());
                    if (i == 1) {
                        operationVO.setErrmsg("成功");
                        operationVO.setErrno(0);
                        return operationVO;
                    }
                    operationVO.setErrmsg("领取失败");
                    operationVO.setErrno(-1);
                    return operationVO;

                }
                operationVO.setErrmsg("优惠券已经领取过");
                operationVO.setErrno(740);
                return operationVO;

            } else if (limit != 0) {
                List<CouponUser> couponUserList = couponUserService.queryByCouponIdList(couponId);
                if (couponUserList == null) {
                    int i = couponUserService.insert(userId, couponId, coupon.getStartTime(), coupon.getEndTime(), new Date());
                    if (i == 1 && number < limit) {
                        number++;
                        operationVO.setErrmsg("成功");
                        operationVO.setErrno(0);
                        return operationVO;
                    } else {
                        operationVO.setErrmsg("优惠券已领完");
                        operationVO.setErrno(740);
                        return operationVO;
                    }
                } else if ((short) couponUserList.size() < limit) {
                    short size = (short) couponUserList.size();


                    int i = couponUserService.insert(userId, couponId, coupon.getStartTime(), coupon.getEndTime(), new Date());
                    if (i == 1 && size < limit) {
                        size++;
                        operationVO.setErrmsg("成功");
                        operationVO.setErrno(0);
                        return operationVO;
                    } else {
                        operationVO.setErrmsg("优惠券已领完");
                        operationVO.setErrno(740);
                        return operationVO;
                    }
                }
                operationVO.setErrmsg("优惠券已领完");
                operationVO.setErrno(740);
                return operationVO;

            } else {
                int i = couponUserService.insert(userId, couponId, coupon.getStartTime(), coupon.getEndTime(), new Date());
                if (i == 1) {
                    operationVO.setErrmsg("成功");
                    operationVO.setErrno(0);
                    return operationVO;
                }
                operationVO.setErrmsg("领取失败");
                operationVO.setErrno(-1);
                return operationVO;
            }
        }
        List<CouponUser> couponUserList = couponUserService.queryByCouponIdList(couponId);
        if (couponUserList.size() >= total){
            operationVO.setErrmsg("优惠券已领完");
            operationVO.setErrno(740);
            return operationVO;
        }
        int i = couponUserService.insert(userId, couponId, coupon.getStartTime(), coupon.getEndTime(), new Date());
        if (i == 1) {
            operationVO.setErrmsg("成功");
            operationVO.setErrno(0);
            return operationVO;
        }
        operationVO.setErrmsg("优惠券已经领取过");
        operationVO.setErrno(740);
        return operationVO;


    }

    //http://192.168.2.100:8081/wx/coupon/selectlist?cartId=369&grouponRulesId=0
    @RequestMapping(value = "selectlist" , method = RequestMethod.GET )
    public BaseRespVO selectList(@RequestBody(required = false) Map<Object , Object> data ,HttpServletRequest request){
        //@RequestBody int cartId , @RequestBody int grouponRulesId
        String tokenKey = request.getHeader("X-Litemall-Token");
        int userId = UserTokenManager.getUserId(tokenKey);
        //int cartId = (int) data.get("cartId");
        //int grouponRulesId = (int) data.get("grouponRulesId");
        BaseRespVO vo = new BaseRespVO();
        List<CouponUser> couponUserList = couponUserService.selectList(userId);
        if(couponUserList == null){
            vo.setData(null);
            vo.setErrmsg("没有优惠券");
            vo.setErrno(-1);
            return vo;
        }
        List<CouponWx> couponWxList = new ArrayList<>();
        for (int i = 0; i < couponUserList.size(); i++) {
            CouponUser couponUser = couponUserList.get(i);
            Integer couponId = couponUser.getCouponId();
            Coupon coupon = couponService.queryCouponById(couponId);
            CouponWx couponWx = new CouponWx();
            couponWx.setDesc(coupon.getDesc());
            couponWx.setDiscount(coupon.getDiscount());
            couponWx.setEndTime(couponUser.getEndTime());
            couponWx.setId(coupon.getId());
            couponWx.setMin(coupon.getMin());
            couponWx.setName(coupon.getName());
            couponWx.setStartTime(couponUser.getStartTime());
            couponWx.setTag(coupon.getTag());
            couponWxList.add(couponWx);
        }

        vo.setData(couponWxList);
        vo.setErrmsg("成功");
        vo.setErrno(0);
        return  vo;
    }
}















