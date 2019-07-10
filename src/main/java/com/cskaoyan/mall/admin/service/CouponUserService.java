package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.CouponUser;
import com.cskaoyan.mall.admin.vo.PageVO;

import java.util.Date;
import java.util.List;

public interface CouponUserService {
    PageVO<CouponUser> getListUser(int page, int limit, String sort, String order, int couponId, String userId, String status);

    CouponUser queryByCouponId(int couponId);

    int insert(Integer userId, int couponId, Date startTime, Date endTime, Date addTime);

    List<CouponUser> queryByCouponIdList(int couponId);

    List<CouponUser> selectList();

}
