package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.bean.Feedback;

public interface FeedbackService {

    PageVO<Feedback> findFeedbackPageByUsernameAndId(int page, int limit, String username, Integer id, String sort, String order);

}
