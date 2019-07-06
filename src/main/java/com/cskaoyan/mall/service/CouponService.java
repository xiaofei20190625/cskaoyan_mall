package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Coupon;
import com.cskaoyan.mall.vo.PageVO;

public interface CouponService {
    PageVO<Coupon> getList(int page, int limit, String sort, String order, String name, String type, String status);

    Coupon insert(Coupon coupon);
}
