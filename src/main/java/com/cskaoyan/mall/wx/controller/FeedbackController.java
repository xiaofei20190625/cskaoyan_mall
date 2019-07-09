package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.Admin;
import com.cskaoyan.mall.admin.bean.Feedback;
import com.cskaoyan.mall.admin.bean.User;
import com.cskaoyan.mall.admin.bean.UserVip;
import com.cskaoyan.mall.admin.service.FeedbackService;
import com.cskaoyan.mall.admin.service.UserVipService;
import com.cskaoyan.mall.admin.vo.OperationVO;
import com.cskaoyan.mall.wx.userwx.UserTokenManager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("wx")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;
    @Autowired
    UserVipService userVipService;
    //添加意见回馈
    @RequestMapping("feedback/submit")
    public OperationVO addFeedback(@RequestBody Feedback feedback, HttpServletRequest request) {
        //获得请求头
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        feedback.setUserId(userId);
        feedback.setStatus(0);
        //根据id查username
        UserVip userVip = userVipService.findUserVipByiD(userId);
        String username = userVip.getUsername();
        feedback.setUsername(username);
        if (feedback.getPicUrls().length != 0) {
            //有图片
            feedback.setHasPicture(true);
        } else {
            //没图片
            feedback.setHasPicture(false);
        }
        Date now = new Date();
        feedback.setAddTime(now);
        feedback.setUpdateTime(now);
        int insert = feedbackService.insert(feedback);
        if (insert == 1) {
            OperationVO operationVO = new OperationVO(0, "成功");
            return operationVO;
        } else {
            return new OperationVO(-1, "失败");
        }
    }
}
