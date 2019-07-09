package com.cskaoyan.mall.wx.service.impl;


import com.cskaoyan.mall.wx.bean.Topic;
import com.cskaoyan.mall.wx.mapper.TopicMapperWx;
import com.cskaoyan.mall.wx.service.TopicServiceWx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alex_Cheng
 * @date 2019/7/4 23:03
 * @Description TODO
 */
@Service
public class TopicServiceWxImpl implements TopicServiceWx {
    @Autowired
    TopicMapperWx topicMapper;
    @Override
    public List<Topic> getWxTopicList() {
        return topicMapper.getWxTopicList();
    }
}
