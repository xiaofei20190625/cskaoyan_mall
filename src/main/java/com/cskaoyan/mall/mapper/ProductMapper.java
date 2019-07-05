package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Product;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    Product selectByPrimaryKey(Integer id);

    List<Product> queryByGoodsId(int goodsId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}