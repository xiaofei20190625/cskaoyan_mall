package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Attribute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttributeService {
    int deleteByPrimaryKey(Integer id);

    int insert(Attribute record);

    int insertSelective(Attribute record);

    Attribute selectByPrimaryKey(Integer id);

    List<Attribute> queryByGoodsId(@Param("goodsId") int goodsId);

    int updateByPrimaryKeySelective(Attribute record);

    int updateByPrimaryKey(Attribute record);

    List<Attribute> getAttributeByGoodsId(int goodsId);
}
