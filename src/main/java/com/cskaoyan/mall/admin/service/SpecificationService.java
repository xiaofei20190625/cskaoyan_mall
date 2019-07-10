package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Specification;
import com.cskaoyan.mall.wx.bean.SpecificationWx;

import java.util.List;

public interface SpecificationService {
    int deleteByPrimaryKey(Integer id);

    int insert(Specification record);

    int insertSelective(Specification record);

    Specification selectByPrimaryKey(Integer id);

    List<SpecificationWx> querySpecificationWxByGoodsId(int goodsId);

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);

    List<Specification> queryByGoodsId(int id);
}
