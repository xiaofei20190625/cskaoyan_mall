package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.wx.bean.Cart;
import com.cskaoyan.mall.wx.mapper.CartMapper;
import com.cskaoyan.mall.wx.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartMapper cartMapper;

    @Override
    public int getCartGoodscount(Integer userId) {
        return cartMapper.getCartGoodscount(userId);
    }

    @Override
    public int CartGoodsAdd(Cart cart) {
        return cartMapper.insertSelective(cart);
    }

    @Override
    public int getCartIdAast(Integer userId, Date date) {
        return cartMapper.getCartIdAast(userId,date);
    }
}
