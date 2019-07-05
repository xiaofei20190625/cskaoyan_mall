package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Product;

import java.util.List;

public interface ProductService {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    Product selectByPrimaryKey(Integer id);

    List<Product> queryByGoodsId(int goodsId);

    int updateByPrimaryKey(Product product);
}
