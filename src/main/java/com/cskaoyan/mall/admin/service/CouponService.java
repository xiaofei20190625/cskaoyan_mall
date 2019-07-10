package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Coupon;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.wx.bean.CouponAndCouponUser;

import java.util.List;

public interface CouponService {
    PageVO<Coupon> getList(int page, int limit, String sort, String order, String name, String type, String status);
    int create(Coupon coupon);

    int update(Coupon coupon);

    Coupon getCouponById(int id);

    int delete(Coupon coupon);

    List<Coupon> getWxCouponList();

    List<Coupon> wxGetList(int page, int size);

    int count();

    List<CouponAndCouponUser> myList(int page, int size, int status);
}