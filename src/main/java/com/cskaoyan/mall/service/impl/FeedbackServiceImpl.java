package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Feedback;
import com.cskaoyan.mall.mapper.FeedbackMapper;
import com.cskaoyan.mall.service.FeedbackService;
import com.cskaoyan.mall.utils.PageUtil;
import com.cskaoyan.mall.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackMapper feedbackMapper;
    @Override
    public PageVO<Feedback> findFeedbackPage(int page, int limit) {
        List<Feedback> feedbackPage = feedbackMapper.findFeedbackPage();
        PageVO<Feedback> pagevo = new PageUtil<Feedback>().pagevo(page, limit, feedbackPage);
        return pagevo;
    }

    @Override
    public PageVO<Feedback> findFeedbackByUsername(int page, int limit, String username) {
        List<Feedback> feedbackPage = feedbackMapper.findFeedbackByUsername(username);
        PageVO<Feedback> pagevo = new PageUtil<Feedback>().pagevo(page, limit, feedbackPage);
        return pagevo;
    }

    @Override
    public PageVO<Feedback> findFeedbackPageByUsernameAndId(int page, int limit, String username, Integer id) {
        List<Feedback> feedbackPage = feedbackMapper.findFeedbackPageByUsernameAndId(username, id);
        PageVO<Feedback> pagevo = new PageUtil<Feedback>().pagevo(page, limit, feedbackPage);
        return pagevo;
    }

    @Override
    public PageVO<Feedback> findFeedbackPageById(int page, int limit, Integer id) {
        List<Feedback> feedbackPage = feedbackMapper.findFeedbackPageById(id);
        PageVO<Feedback> pagevo = new PageUtil<Feedback>().pagevo(page, limit, feedbackPage);
        return pagevo;
    }
}
