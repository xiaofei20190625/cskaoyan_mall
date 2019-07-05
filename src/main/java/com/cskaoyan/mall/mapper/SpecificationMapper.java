package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Specification;

import java.util.List;

public interface SpecificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Specification record);

    int insertSelective(Specification record);

    Specification selectByPrimaryKey(Integer id);

    List<Specification> queryByGoodsId(int goodsId);

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);
}