package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.wx.mapper.CartMapper;
import com.cskaoyan.mall.wx.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartMapper cartMapper;

    @Override
    public int getCartGoodscount(Integer userId) {
        return cartMapper.getCartGoodscount(userId);
    }
}
