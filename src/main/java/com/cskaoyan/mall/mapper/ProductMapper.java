package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    Product selectByPrimaryKey(Integer id);

    List<Product> queryByGoodsId(int goodsId);

    int updateByPrimaryKey(@Param("product") Product product);
}