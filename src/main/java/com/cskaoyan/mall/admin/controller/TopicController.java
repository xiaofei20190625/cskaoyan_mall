package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.Topic;
import com.cskaoyan.mall.admin.service.TopicService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/topic")
public class TopicController {

    @Autowired
    TopicService topicService;

    /* http://192.168.2.100:8081/admin/topic/list?page=1&limit=20&title=1&subtitle=1&sort=add_time&order=desc*/
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseVO<PageVO> getList(int page, int limit, String sort, String order, String title, String subtitle) {
        if (title == null) title = "";
        if (subtitle == null) subtitle = "";
        PageVO<Topic> topicPageVO = topicService.getList(page, limit, sort, order, title, subtitle);
        ResponseVO<PageVO> responseVO = new ResponseVO<>();
        responseVO.setData(topicPageVO);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }
}
