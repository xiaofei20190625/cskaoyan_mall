package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.UserVip;
import com.cskaoyan.mall.service.UserVipService;
import com.cskaoyan.mall.vo.PageVO;
import com.cskaoyan.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManageController {
    @Autowired
    UserVipService userVipService;
    @RequestMapping("user/list")
    public ResponseVO<PageVO> userList(int page, int limit, String sort, String desc){
        PageVO<UserVip> userVipPage = userVipService.findUserVipPage(page, limit);
        ResponseVO<PageVO> userVipResponseVO = new ResponseVO<>();
        userVipResponseVO.setData(userVipPage);
        userVipResponseVO.setErrmsg("成功");
        userVipResponseVO.setErrno(0);
        return userVipResponseVO;
    }


}
