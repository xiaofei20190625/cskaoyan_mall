package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Attribute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttributeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Attribute record);

    int insertSelective(Attribute record);

    Attribute selectByPrimaryKey(Integer id);

    List<Attribute> queryByGoodsId(@Param("goodsId") int goodsId);

    int updateByPrimaryKeySelective(Attribute record);

    int updateByPrimaryKey(Attribute record);
}