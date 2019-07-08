package com.cskaoyan.mall.wx.bean;

import org.springframework.stereotype.Component;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/8 Time 17:58
 */
@Component
public class UserInfo {
    private String avatarUrl;
    private String nickname;

    public UserInfo() {
    }

    public UserInfo(String avatarUrl, String nickname) {
        this.avatarUrl = avatarUrl;
        this.nickname = nickname;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
