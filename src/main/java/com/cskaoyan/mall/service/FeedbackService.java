package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Feedback;
import com.cskaoyan.mall.vo.PageVO;

public interface FeedbackService {
    PageVO<Feedback> findFeedbackPage(int page, int limit);

    PageVO<Feedback> findFeedbackByUsername(int page, int limit, String username);

    PageVO<Feedback> findFeedbackPageByUsernameAndId(int page, int limit, String username, Integer id);

    PageVO<Feedback> findFeedbackPageById(int page, int limit, Integer id);
}
