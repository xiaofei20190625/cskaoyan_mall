package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Topic record);

    int insertSelective(Topic record);

    Topic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKeyWithBLOBs(Topic record);

    int updateByPrimaryKey(Topic record);

    List<Topic> getList(@Param("sort") String sort, @Param("order")String order,
                        @Param("title")String title, @Param("subtitle")String subtitle);
}