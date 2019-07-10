package com.cskaoyan.mall.wx.bean;

import javax.validation.constraints.Size;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/10 Time 16:19
 */
public class RegisterUser {
    private String code;
    @Size(min = 11,max = 11,message = "请输入11位有效手机号")
    private String mobile;
    @Size(min = 6,max = 14,message = "密码长度在6~14个字符之间")
    private String password;
    @Size(min = 6,max = 20,message = "用户名长度在6~20个字符之间")
    private String username;
    private String wxCode;

    public RegisterUser() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWxCode() {
        return wxCode;
    }

    public void setWxCode(String wxCode) {
        this.wxCode = wxCode;
    }
}
