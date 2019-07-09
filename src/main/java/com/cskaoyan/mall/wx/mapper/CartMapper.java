package com.cskaoyan.mall.wx.mapper;

import com.cskaoyan.mall.wx.bean.Cart;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    int getCartGoodscount(Integer userId);

}