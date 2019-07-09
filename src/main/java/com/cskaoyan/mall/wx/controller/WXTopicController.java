package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.Topic;
import com.cskaoyan.mall.admin.service.TopicService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alex_Cheng
 * @date 2019/7/8 23:34
 * @Description TODO
 */
@RestController
@RequestMapping("/wx/topic")
public class WXTopicController {

    @Autowired
    TopicService topicService;

/*    http://192.168.2.100:8081/wx/topic/list?page=1&size=10
    http://192.168.2.100:8081/wx/topic/detail?id=264
    http://192.168.2.100:8081/wx/topic/related?id=264*/
@RequestMapping(value = "/list", method = RequestMethod.GET)
public ResponseVO<PageVO> wxGetList(int page, int limit) {
    PageVO<Topic> topicPageVO = topicService.wxGetList(page, limit);
    ResponseVO<PageVO> responseVO = new ResponseVO<>();
    responseVO.setData(topicPageVO);
    responseVO.setErrmsg("成功");
    responseVO.setErrno(0);
    return responseVO;
}

}
