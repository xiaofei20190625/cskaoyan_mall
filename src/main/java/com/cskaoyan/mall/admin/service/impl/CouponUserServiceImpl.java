package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.mapper.CouponUserMapper;
import com.cskaoyan.mall.admin.service.CouponUserService;
import com.cskaoyan.mall.admin.bean.CouponUser;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public CouponUser queryByCouponId(int couponId) {
        return couponUserMapper.queryByCouponId(couponId);
    }

    @Override
    public int insert(Integer userId, int couponId, Date startTime, Date endTime, Date addTime) {
        CouponUser couponUser = new CouponUser();
        couponUser.setUserId(userId);
        couponUser.setCouponId(couponId);
        couponUser.setStartTime(startTime);
        couponUser.setEndTime(endTime);
        couponUser.setAddTime(addTime);
        return couponUserMapper.insertSelective(couponUser);
    }

    @Override
    public List<CouponUser> queryByCouponIdList(int couponId) {
        return couponUserMapper.queryByCouponIdList(couponId);
    }

    @Override
    public List<CouponUser> selectList(int userId) {
        return couponUserMapper.selectList(userId);
    }
}
