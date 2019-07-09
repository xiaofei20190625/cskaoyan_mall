
package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Topic;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.wx.bean.TopicWx;

import java.util.List;

public interface TopicService {

    PageVO<Topic> getList(int page, int limit, String sort, String order, String title, String subtitle);
    int update(Topic topic);

    int delete(Topic topic);

    int create(Topic topic);

<<<<<<< HEAD
    List<TopicWx> getWxTopicList();
=======
    List<Topic> wxGetList(int page , int size);

    int count();

    Topic queryById(int id);

    List<Topic> queryAll();

    List<Topic> related(int minId, int maxId, int id);
>>>>>>> 67926eff419d08f4ce0ccc08a89515331282a6f2
}