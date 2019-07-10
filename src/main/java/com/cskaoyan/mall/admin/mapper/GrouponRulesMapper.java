package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Groupon;
import com.cskaoyan.mall.admin.bean.GrouponRules;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GrouponRulesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GrouponRules record);

    int insertSelective(GrouponRules record);

    GrouponRules selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GrouponRules record);

    int updateByPrimaryKey(GrouponRules record);

    List<GrouponRules> getList(@Param("sort") String sort, @Param("order")String order,@Param("goodsId") String goodsId);

    int create(GrouponRules grouponRules);

    GrouponRules findGoodsId(Integer goodsId);

    List<GrouponRules> queryAll();

    List<GrouponRules> wxGetList();


    int count();

    List<Groupon> getGrouponRulesByGoodsId(@Param("goodsId") int goodsId);

}