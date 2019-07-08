package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.GoodsAndGrouponAndGrouponRules;
import com.cskaoyan.mall.admin.bean.GrouponRules;
import com.cskaoyan.mall.admin.bean.Groupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GrouponMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Groupon record);

    int insertSelective(Groupon record);

    Groupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Groupon record);

    int updateByPrimaryKey(Groupon record);

    List<GoodsAndGrouponAndGrouponRules> getListRecord(@Param("sort") String sort, @Param("order") String order,
                                                       @Param("goodsId") String goodsId);

    int create(GrouponRules grouponRules);

    Groupon findRulesId(Integer id);

    List<GoodsAndGrouponAndGrouponRules> get(GoodsAndGrouponAndGrouponRules demo);
}