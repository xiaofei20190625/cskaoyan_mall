package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Feedback;
import com.cskaoyan.mall.admin.bean.PageList;
import com.cskaoyan.mall.admin.mapper.FeedbackMapper;
import com.cskaoyan.mall.admin.service.FeedbackService;
import com.cskaoyan.mall.admin.vo.PageVO;
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
        PageVO<Feedback> pagevo = new PageList<Feedback>().pagevo(page, limit, feedbackPage);
        return pagevo;
    }

    @Override
    public int insert(Feedback record) {
        return feedbackMapper.insert(record);
    }
}
