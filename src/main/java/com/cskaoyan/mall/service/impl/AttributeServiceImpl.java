package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Attribute;
import com.cskaoyan.mall.mapper.AttributeMapper;
import com.cskaoyan.mall.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService {
    @Autowired
    AttributeMapper attributeMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return attributeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Attribute record) {
        return attributeMapper.insert(record);
    }

    @Override
    public int insertSelective(Attribute record) {

        return attributeMapper.insertSelective(record);
    }

    @Override
    public Attribute selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Attribute> queryByGoodsId(int goodsId) {
        return attributeMapper.queryByGoodsId(goodsId);
    }

    @Override
    public int updateByPrimaryKeySelective(Attribute record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Attribute record) {
        return attributeMapper.updateByPrimaryKey(record);
    }
}
