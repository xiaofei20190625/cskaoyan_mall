package com.cskaoyan.mall.wx.service;

import com.cskaoyan.mall.wx.bean.Cart;

import java.util.Date;

public interface CartService {
    int getCartGoodscount(Integer userId);

    int CartGoodsAdd(Cart cart);

    int getCartIdAast(Integer userId, Date date);
}
