package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Topic;
import com.cskaoyan.mall.vo.PageVO;

public interface TopicService {
    PageVO<Topic> getList(int page, int limit, String sort, String order, String title, String subtitle);

    int update(Topic topic);

    int delete(Topic topic);

    int create(Topic topic);
}
