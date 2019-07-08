package com.cskaoyan.mall.wx.service;

import com.cskaoyan.mall.wx.bean.Feedback;

public interface FeedbackService {
    int deleteByPrimaryKey(Integer id);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);
}
