package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Topic;
import com.cskaoyan.mall.admin.vo.PageVO;

public interface TopicService {
    PageVO<Topic> getList(int page, int limit, String sort, String order, String title, String subtitle);
}
