package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Feedback;
import com.cskaoyan.mall.vo.PageVO;

public interface FeedbackService {

    PageVO<Feedback> findFeedbackPageByUsernameAndId(int page, int limit, String username, Integer id, String sort, String order);

}
