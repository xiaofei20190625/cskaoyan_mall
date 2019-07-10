package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Specification;
import com.cskaoyan.mall.wx.bean.SpecificationWx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Specification record);

    int insertSelective(Specification record);

    Specification selectByPrimaryKey(Integer id);

    List<SpecificationWx> querySpecificationWxByGoodsId(@Param("goodsId") int goodsId);

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);

    List<Specification> queryByGoodsId(@Param("id") int id);
}