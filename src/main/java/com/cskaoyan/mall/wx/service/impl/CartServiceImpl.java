package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.admin.converter.DateToStringConverter;
import com.cskaoyan.mall.admin.converter.StringToDateConverter;
import com.cskaoyan.mall.wx.bean.Cart;
import com.cskaoyan.mall.wx.mapper.CartMapper;
import com.cskaoyan.mall.wx.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public Integer getCartIdAast(Integer userId, Date date) {
        Integer cartIdAast = cartMapper.getCartIdAast(userId, date);
        return cartIdAast;
    }

    @Override
    public List<Cart> getCartByUserId(Integer userId) {
        return cartMapper.getCartByUserId(userId);
    }

    @Override
    public int CartGoodsAddByGoodsId(Cart cart) {
        return cartMapper.updateByPrimaryKeySelective(cart);
    }

    @Override
    public Cart getCartGoodsByGoodsId(int goodsId) {
        return cartMapper.getCartGoodsByGoodsId(goodsId);
    }

    @Override
    public int updateCartGoodsisChecked(Cart cart) {
        return cartMapper.updateCartGoodsisChecked(cart);
    }

    @Override
    public int updateCartGoodsAddById(Cart cart) {
        return cartMapper.updateCartGoodsAddById(cart);
    }

    @Override
    public int deleteCartGoodsAddById(Cart cart) {
        return cartMapper.updateCartGoodsAddById(cart);
    }
}
