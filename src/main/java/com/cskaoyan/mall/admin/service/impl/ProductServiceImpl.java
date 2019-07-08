package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Product;
import com.cskaoyan.mall.admin.mapper.ProductMapper;
import com.cskaoyan.mall.admin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {

        return productMapper.deleteByPrimaryKey(id);
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
    public int updateByPrimaryKey(Product product) {
        return productMapper.updateByPrimaryKey(product);
    }
}
