package com.cskaoyan.mall.wx.mapper;

import com.cskaoyan.mall.wx.bean.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    int getCartGoodscount(Integer userId);

    Integer getCartIdAast(@Param("userId") Integer userId, @Param("date") Date date);

    List<Cart> getCartByUserId(Integer userId);

    Cart getCartGoodsByGoodsId(int goodsId);

    int updateCartGoodsisChecked(Cart cart);

    int updateCartGoodsAddById(Cart cart);

}