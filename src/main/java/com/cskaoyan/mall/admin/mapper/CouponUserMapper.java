package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CouponUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CouponUser record);

    int insertSelective(CouponUser record);

    CouponUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CouponUser record);

    int updateByPrimaryKey(CouponUser record);

    List<CouponUser> getListUser(@Param("sort") String sort, @Param("order")String order,
                                 @Param("couponId")int couponId, @Param("userId")String userId, @Param("status")String status);
}