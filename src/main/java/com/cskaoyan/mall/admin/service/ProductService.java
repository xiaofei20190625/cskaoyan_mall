package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Product;

import java.util.List;

public interface ProductService {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    Product selectByPrimaryKey(Integer id);

    List<Product> queryByGoodsId(int goodsId);

    int updateByPrimaryKey(Product product);
}
