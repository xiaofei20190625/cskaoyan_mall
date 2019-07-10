package com.cskaoyan.mall.wx.service;

import com.cskaoyan.mall.wx.bean.Cart;

import java.util.Date;
import java.util.List;

public interface CartService {
    int getCartGoodscount(Integer userId);

    int CartGoodsAdd(Cart cart);

    Integer getCartIdAast(Integer userId, Date date);

    List<Cart> getCartByUserId(Integer userId);

    int CartGoodsAddByGoodsId(Cart cart);

    Cart getCartGoodsByGoodsId(int goodsId);

    int updateCartGoodsisChecked(Cart cart);

    int updateCartGoodsAddById(Cart cart);

    int deleteCartGoodsAddById(Cart cart);
}
