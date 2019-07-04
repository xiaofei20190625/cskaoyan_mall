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
    public PageVO<Feedback> findFeedbackPageByUsernameAndId(int page, int limit, String username, Integer id, String sort, String order) {
        List<Feedback> feedbackPage = feedbackMapper.findFeedbackPageByUsernameAndId(username, id, sort, order);
        PageVO<Feedback> pagevo = new PageUtil<Feedback>().pagevo(page, limit, feedbackPage);
        return pagevo;
    }
}
