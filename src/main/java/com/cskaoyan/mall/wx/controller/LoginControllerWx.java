package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.cskaoyan.mall.wx.bean.UserInfo;
import com.cskaoyan.mall.wx.vo.LoginVOWx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/8 Time 17:40
 */
@Controller
@RequestMapping("/wx/auth")
public class LoginControllerWx {
    @Autowired
    LoginVOWx loginVOWx;
    @Autowired
    UserInfo userInfo;



    @RequestMapping("login")
    @ResponseBody
    public ResponseVO<LoginVOWx> login(String username, String password){
        System.out.println(username);
        /*loginVOWx.setToken("x8nbloh114ca9c3u7488uwxc96kfupxd");
        userInfo.setNickname("admin");
        userInfo.setAvatarUrl("");
        loginVOWx.setUserInfo(userInfo);
        String expireTime = "2020-1-1 00:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        try {
            parse = sdf.parse(expireTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        loginVOWx.setTokenExpire(parse);*/

        ResponseVO<LoginVOWx> responseVO = new ResponseVO<>();
        responseVO.setData(loginVOWx);
        responseVO.setErrno(0);
        responseVO.setErrmsg("成功");
        return responseVO;
    }
}
