package com.cskaoyan.mall.bean;

import java.util.Date;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/5 Time 19:55
 */
public class Issue {
    private Integer id;
    private String question;
    private String answer;
    private Date addTime;
    private Date updateTime;
    private Boolean deleted;

    public Issue() {
    }

    public Issue(Integer id, String question, String answer, Date addTime, Date updateTime, Boolean deleted) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
