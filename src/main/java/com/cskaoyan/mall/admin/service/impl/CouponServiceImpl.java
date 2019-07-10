package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Coupon;
import com.cskaoyan.mall.admin.mapper.CouponMapper;
import com.cskaoyan.mall.admin.service.CouponService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.wx.bean.CouponAndCouponUser;
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

    @Override
    public int create(Coupon coupon) {
        return couponMapper.create(coupon);
    }

    @Override
    public int update(Coupon coupon) {
        return  couponMapper.updateByPrimaryKeySelective(coupon);
    }

    @Override
    public Coupon getCouponById(int id) {
        return couponMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Coupon coupon) {
        return  couponMapper.deleteByPrimaryKey(coupon.getId());
    }

    @Override
    public List<Coupon> getWxCouponList() {
        return couponMapper.getWxCouponList();
    }

    @Override
    public List<Coupon> wxGetList(int page, int size) {
        PageHelper.startPage(page, size);
        return couponMapper.wxGetList();
    }

    @Override
    public int count() {
        return couponMapper.count();
    }

    @Override
    public List<CouponAndCouponUser> myList(int page, int size, int status) {
        PageHelper.startPage(page, size);
        return couponMapper.myList(status);
    }


}
