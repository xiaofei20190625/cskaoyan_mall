package com.cskaoyan.mall.wx.vo;

import com.cskaoyan.mall.wx.bean.UserInfo;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/8 Time 19:45
 */
@Component
public class LoginVOWx {
    private String token;
    private Date tokenExpire;
    private UserInfo userInfo;



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getTokenExpire() {
        return tokenExpire;
    }

    public void setTokenExpire(Date tokenExpire) {
        this.tokenExpire = tokenExpire;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
