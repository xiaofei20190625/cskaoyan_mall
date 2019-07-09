package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Coupon;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CouponMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    Coupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(@RequestBody Coupon record);

    int updateByPrimaryKey(Coupon record);

    List<Coupon> getList(@Param("sort") String sort, @Param("order") String order, @Param("name") String name,
                         @Param("type") String type, @Param("status") String status);

    int create(Coupon coupon);

    List<Coupon> getWxCouponList();
}