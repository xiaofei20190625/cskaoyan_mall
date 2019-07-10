package com.cskaoyan.mall.wx.bean;

import com.cskaoyan.mall.admin.bean.Coupon;
import com.cskaoyan.mall.admin.bean.CouponUser;

/**
 * @author Alex_Cheng
 * @date 2019/7/10 15:09
 * @Description TODO
 */
public class CouponAndCouponUser {
    Coupon coupon;

    CouponUser couponUser;

    public CouponAndCouponUser() {
    }

    public CouponAndCouponUser(Coupon coupon, CouponUser couponUser) {
        this.coupon = coupon;
        this.couponUser = couponUser;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public CouponUser getCouponUser() {
        return couponUser;
    }

    public void setCouponUser(CouponUser couponUser) {
        this.couponUser = couponUser;
    }
}
