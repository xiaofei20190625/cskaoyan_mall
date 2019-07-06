package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.CouponUser;
import com.cskaoyan.mall.vo.PageVO;

public interface CouponUserService {
    PageVO<CouponUser> getListUser(int page, int limit, String sort, String order, int couponId, String userId, String status);
}
