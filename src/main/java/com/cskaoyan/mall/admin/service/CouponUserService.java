package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.CouponUser;
import com.cskaoyan.mall.admin.vo.PageVO;

public interface CouponUserService {
    PageVO<CouponUser> getListUser(int page, int limit, String sort, String order, int couponId, String userId, String status);
}
