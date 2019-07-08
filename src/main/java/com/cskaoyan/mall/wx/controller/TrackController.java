package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.Feedback;
import com.cskaoyan.mall.admin.service.FeedbackService;
import com.cskaoyan.mall.admin.vo.OperationVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wx")
public class TrackController {
    @Autowired
    FeedbackService feedbackService;
    //添加意见回馈
    @RequestMapping("feedback/submit")
    public OperationVO addFeedback(@RequestBody Feedback feedback) {
        int insert = feedbackService.insert(feedback);
        if (insert == 1) {
            OperationVO operationVO = new OperationVO(0, "成功");
            return operationVO;
        } else {
            return new OperationVO(-1, "失败");
        }
    }
    //http://192.168.2.100:8081/wx/footprint/list?page=1&size=10
    //足迹列表
    @RequestMapping("footprint/list")
    public ResponseVO getFootprintList(int page, int size) {
        return new ResponseVO();

    }





}
