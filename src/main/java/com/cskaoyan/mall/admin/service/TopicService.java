
package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Topic;
import com.cskaoyan.mall.admin.vo.PageVO;

import java.util.List;

public interface TopicService {
    PageVO<Topic> getList(int page, int limit, String sort, String order, String title, String subtitle);
    int update(Topic topic);

    int delete(Topic topic);

    int create(Topic topic);

    List<com.cskaoyan.mall.wx.bean.Topic> getWxTopicList();
}