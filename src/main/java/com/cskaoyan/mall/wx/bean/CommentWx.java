package com.cskaoyan.mall.wx.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/9 Time 23:41
 */
public class CommentWx {
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;
    private String avatar;
    private String content;
    private Integer id;
    private String nickname;
    private String[] picList;

    public CommentWx() {
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String[] getPicList() {
        return picList;
    }

    public void setPicList(String[] picList) {
        this.picList = picList;
    }
}
