package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Coupon;
import com.cskaoyan.mall.admin.vo.PageVO;

public interface CouponService {
    PageVO<Coupon> getList(int page, int limit, String sort, String order, String name, String type, String status);
}
