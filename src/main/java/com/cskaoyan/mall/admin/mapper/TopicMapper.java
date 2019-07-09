package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Topic;
import com.cskaoyan.mall.wx.bean.TopicWx;
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

    int create(Topic topic);

<<<<<<< HEAD
    List<TopicWx> getWxTopicList();
=======

    List<Topic> wxGetList();

    int count();

    List<Topic> related(@Param("minId") int minId, @Param("maxId")int maxId, @Param("id")int id);

>>>>>>> 67926eff419d08f4ce0ccc08a89515331282a6f2
}