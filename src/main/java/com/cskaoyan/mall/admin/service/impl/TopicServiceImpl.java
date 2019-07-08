package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Topic;
import com.cskaoyan.mall.admin.mapper.TopicMapper;
import com.cskaoyan.mall.admin.service.TopicService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alex_Cheng
 * @date 2019/7/4 23:03
 * @Description TODO
 */
@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicMapper topicMapper ;

    @Override
    public PageVO<Topic> getList(int page, int limit, String sort, String order, String title, String subtitle) {
        PageHelper.startPage(page, limit);
        List<Topic> couponList = topicMapper.getList(sort , order ,title , subtitle );
        PageInfo<Topic> topicPageInfo = new PageInfo<>(couponList);
        PageVO<Topic> topicPageVO = new PageVO<>(topicPageInfo.getTotal(),topicPageInfo.getList());
        return  topicPageVO ;
    }

    @Override
    public int update(Topic topic) {
        return topicMapper.updateByPrimaryKeySelective(topic);
    }

    @Override
    public int delete(Topic topic) {
        return topicMapper.deleteByPrimaryKey(topic.getId());
    }

    @Override
    public int create(Topic topic) {
        return topicMapper.create(topic);
    }
}
