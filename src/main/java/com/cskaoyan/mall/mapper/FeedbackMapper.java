package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Feedback;
import com.cskaoyan.mall.vo.PageVO;

import java.util.List;

public interface FeedbackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);

    List<Feedback> findFeedbackPage();

    List<Feedback> findFeedbackByUsername(String username);

    List<Feedback> findFeedbackPageByUsernameAndId(String username, Integer id);

    List<Feedback> findFeedbackPageById(Integer id);
}