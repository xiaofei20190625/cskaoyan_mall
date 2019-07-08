package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Coupon;
import com.cskaoyan.mall.admin.mapper.CouponMapper;
import com.cskaoyan.mall.admin.service.CouponService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alex_Cheng
 * @date 2019/7/4 22:32
 * @Description TODO
 */
@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    CouponMapper couponMapper;

    @Override
    public PageVO<Coupon> getList(int page, int limit, String sort, String order, String name, String type, String status) {
        PageHelper.startPage(page, limit);
        List<Coupon> couponList = couponMapper.getList(sort , order ,name , type , status);
        PageInfo<Coupon> couponPageInfo = new PageInfo<>(couponList);
        PageVO<Coupon> couponPageVO = new PageVO<>(couponPageInfo.getTotal(),couponPageInfo.getList());
        return  couponPageVO ;
    }
}
