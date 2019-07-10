package com.cskaoyan.mall.wx.bean;

/**
 * @author Alex_Cheng
 * @date 2019/7/10 12:50
 * @Description TODO
 */
public class Creator {
    String avatar;

    String nickname;

    public Creator() {
    }

    public Creator(String avatar, String nickname) {
        this.avatar = avatar;
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
