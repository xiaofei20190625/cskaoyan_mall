package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Specification;

import java.util.List;

public interface SpecificationService {
    int deleteByPrimaryKey(Integer id);

    int insert(Specification record);

    int insertSelective(Specification record);

    Specification selectByPrimaryKey(Integer id);

    List<Specification> queryByGoodsId(int goodsId);

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);
}
