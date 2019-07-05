package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Product;
import com.cskaoyan.mall.mapper.ProductMapper;
import com.cskaoyan.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Product record) {
        return productMapper.insert(record);
    }

    @Override
    public Product selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Product> queryByGoodsId(int goodsId) {
        return productMapper.queryByGoodsId(goodsId);
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return 0;
    }
}