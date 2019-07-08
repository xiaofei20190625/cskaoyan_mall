package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Groupon;
import com.cskaoyan.mall.admin.bean.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GrouponMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Groupon record);

    int insertSelective(Groupon record);

    Groupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Groupon record);

    int updateByPrimaryKey(Groupon record);

    List<Groupon> getListRecord(@Param("sort") String sort, @Param("order") String order,
                              @Param("goodsId") String goodsId);
}