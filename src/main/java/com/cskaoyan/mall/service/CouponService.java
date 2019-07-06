package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Coupon;
import com.cskaoyan.mall.vo.PageVO;

import java.util.List;

public interface CouponService {
    PageVO<Coupon> getList(int page, int limit, String sort, String order, String name, String type, String status);

    int create(Coupon coupon);

    int update(Coupon coupon);

    Coupon getCouponById(int id);

    int delete(Coupon coupon);
}
