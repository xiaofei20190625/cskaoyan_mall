package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.wx.bean.Feedback;
import com.cskaoyan.mall.wx.mapper.FeedbackMapper;
import com.cskaoyan.mall.wx.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackMapper feedbackMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Feedback record) {
        return 0;
    }

    @Override
    public int insertSelective(Feedback record) {
        return 0;
    }

    @Override
    public Feedback selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Feedback record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Feedback record) {
        return 0;
    }
}
