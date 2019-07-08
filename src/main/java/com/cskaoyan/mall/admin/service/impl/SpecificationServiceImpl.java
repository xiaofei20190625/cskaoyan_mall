package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Specification;
import com.cskaoyan.mall.admin.mapper.SpecificationMapper;
import com.cskaoyan.mall.admin.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificationServiceImpl implements SpecificationService {
    @Autowired
    SpecificationMapper specificationMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return specificationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Specification record) {
        return 0;
    }

    @Override
    public int insertSelective(Specification record) {
        return specificationMapper.insertSelective(record);
    }

    @Override
    public Specification selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Specification> queryByGoodsId(int goodsId) {
        return specificationMapper.queryByGoodsId(goodsId);
    }

    @Override
    public int updateByPrimaryKeySelective(Specification record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Specification record) {
        return specificationMapper.updateByPrimaryKey(record);
    }
}
