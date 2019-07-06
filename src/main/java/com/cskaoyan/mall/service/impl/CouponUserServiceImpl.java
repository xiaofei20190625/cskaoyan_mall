package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Coupon;
import com.cskaoyan.mall.bean.CouponUser;
import com.cskaoyan.mall.mapper.CouponUserMapper;
import com.cskaoyan.mall.service.CouponUserService;
import com.cskaoyan.mall.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alex_Cheng
 * @date 2019/7/6 14:28
 * @Description TODO
 */
@Service
public class CouponUserServiceImpl implements CouponUserService {
    @Autowired
    CouponUserMapper couponUserMapper ;
    @Override
    public PageVO<CouponUser> getListUser(int page, int limit, String sort, String order, int couponId, String userId, String status) {
        PageHelper.startPage(page, limit);
        List<CouponUser> couponList = couponUserMapper.getListUser(sort , order ,couponId , userId , status);
        PageInfo<CouponUser> couponUserPageInfo = new PageInfo<>(couponList);
        PageVO<CouponUser> couponUserPageVO = new PageVO<>(couponUserPageInfo.getTotal(),couponUserPageInfo.getList());
        return  couponUserPageVO ;
    }
}
