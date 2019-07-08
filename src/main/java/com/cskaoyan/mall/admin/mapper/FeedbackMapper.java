package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Feedback;
import com.cskaoyan.mall.admin.vo.PageVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FeedbackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);

    List<Feedback> findFeedbackPageByUsernameAndId(@Param("username") String username,
                                                   @Param("id") Integer id,
                                                   @Param("sort") String sort,
                                                   @Param("order") String order);

}