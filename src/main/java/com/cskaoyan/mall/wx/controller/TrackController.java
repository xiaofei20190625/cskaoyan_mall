package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.Feedback;
import com.cskaoyan.mall.admin.service.FeedbackService;
import com.cskaoyan.mall.admin.service.FootprintService;
import com.cskaoyan.mall.admin.vo.OperationVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.cskaoyan.mall.wx.vo.FootprintVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wx")
public class TrackController {
    @Autowired
    FootprintService footprintService;
    //http://192.168.2.100:8081/wx/footprint/list?page=1&size=10
    //足迹列表
    @RequestMapping("footprint/list")
    public ResponseVO getFootprintList(int page, int size) {
        //userid 通过登录前台得到userid和user的name
        int userId = 1;
        ResponseVO<FootprintVO> responseVO = footprintService.findFootprintByUid(page, size, userId);
        return responseVO;

    }





}
