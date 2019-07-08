package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.User;
import com.cskaoyan.mall.admin.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    LoginVO loginVO;
    @Autowired
    User user;

    @RequestMapping("admin/auth/login")
    @ResponseBody
    public LoginVO<String> login(){
        loginVO.setData("551942c0-ee63-48ae-bcb0-9d15af408959");
        return loginVO;
    }

    @RequestMapping("admin/auth/info")
    @ResponseBody
    public LoginVO<User> loginInfo(){
        loginVO.setData(user);
        return loginVO;
    }
}
