package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Topic;
import com.cskaoyan.mall.service.TopicService;
import com.cskaoyan.mall.vo.PageVO;
import com.cskaoyan.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
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

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseVO<Topic> update(@RequestBody Topic topic) {
        int update = topicService.update(topic);
        ResponseVO<Topic> responseVO = new ResponseVO<>();
        if (update == 1) {
            responseVO.setData(topic);
            responseVO.setErrno(0);
            responseVO.setErrmsg("成功");
        }
        return responseVO;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseVO delete(@RequestBody Topic topic){
        int delete = topicService.delete(topic);
        ResponseVO<Integer> responseVO = new ResponseVO<>();
        if(delete == 1){
            responseVO.setData(delete);
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
        }
        return  responseVO;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseVO<Topic> create(@RequestBody Topic topic) {
        int insert = topicService.create(topic);
        ResponseVO<Topic> responseVO = new ResponseVO<>();
        if (insert == 1) {
            responseVO.setData(topic);
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
        }
        return responseVO;
    }
}
