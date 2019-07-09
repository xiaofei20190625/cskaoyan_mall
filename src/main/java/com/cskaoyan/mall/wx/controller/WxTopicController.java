package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.Topic;
import com.cskaoyan.mall.admin.service.TopicService;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.cskaoyan.mall.wx.vo.BaseRespVo;
import com.cskaoyan.mall.wx.vo.TopicCountVO;
import com.cskaoyan.mall.wx.vo.TopicGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alex_Cheng
 * @date 2019/7/8 23:34
 * @Description TODO
 */
@RestController
@RequestMapping("/wx/topic")
public class WxTopicController {

    @Autowired
    TopicService topicService;

    //http://192.168.2.100:8081/wx/topic/list?page=1&size=10
    //http://192.168.2.100:8081/wx/topic/detail?id=264
    //http://192.168.2.100:8081/wx/topic/related?id=264
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object wxGetList(int page, int size) {
/*        ResponseVO<TopicCountVO> responseVO = new ResponseVO<>();
        TopicCountVO<List> topicVO = new TopicCountVO<>();*/
        List<Topic> topicList = topicService.wxGetList(page ,size);
        int count = topicService.count();
        //键值对封装输出映射
        Map<Object , Object> result = new HashMap<>();
        result.put("count", count);
        result.put("data",topicList);
        return  BaseRespVo.ok(result);
/*        topicVO.setCount(count);
        topicVO.setData(topicList);
        responseVO.setData(topicVO);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;*/
    }

    @RequestMapping("detail")
    public Object detail(int id){
        Topic topic = topicService.queryById(id);
        String[] s = {};
        Map<Object, Object> result = new HashMap<Object, Object>();
        result.put("topic", topic);
        result.put("goods" ,s);
        return BaseRespVo.ok(result);
    }

    @RequestMapping("related")
    public  ResponseVO<List> related(int id){
        List<Topic> topicList = topicService.queryAll() ;
        int minId = topicList.get(0).getId();
        int maxId = topicList.get(topicList.size() - 1).getId();
        List<Topic> topics = topicService.related(minId , maxId , id);
        ResponseVO<List> responseVO = new ResponseVO<>(topics ,"成功" , 0 );
        return  responseVO ;
/*        responseVO.setData(topicList);
        Map<Object , Object> result = new HashMap<>();
        result.put("data" , topics);
        return BaseRespVo.ok(result);*/
    }
}
