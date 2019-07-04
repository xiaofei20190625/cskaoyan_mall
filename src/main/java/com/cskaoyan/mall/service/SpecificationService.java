package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Specification;

public interface SpecificationService {
    int deleteByPrimaryKey(Integer id);

    int insert(Specification record);

    int insertSelective(Specification record);

    Specification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);
}
