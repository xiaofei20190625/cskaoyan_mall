package com.cskaoyan.mall.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Alex_Cheng
 * @date 2019/7/5 15:19
 * @Description TODO
 */
public class Groupon {
        private Integer id;

        private Integer orderId;

        private Integer grouponId;

        private Integer rulesId;

        private Integer userId;

        private Integer creatorUserId;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
        private Date addTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
        private Date updateTime;

        private String shareUrl;

        private Boolean payed;

        private Boolean deleted;

        public Groupon(Integer id, Integer orderId, Integer grouponId, Integer rulesId, Integer userId, Integer creatorUserId, Date addTime, Date updateTime, String shareUrl, Boolean payed, Boolean deleted) {
            this.id = id;
            this.orderId = orderId;
            this.grouponId = grouponId;
            this.rulesId = rulesId;
            this.userId = userId;
            this.creatorUserId = creatorUserId;
            this.addTime = addTime;
            this.updateTime = updateTime;
            this.shareUrl = shareUrl;
            this.payed = payed;
            this.deleted = deleted;
        }

        public Groupon() {
            super();
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getOrderId() {
            return orderId;
        }

        public void setOrderId(Integer orderId) {
            this.orderId = orderId;
        }

        public Integer getGrouponId() {
            return grouponId;
        }

        public void setGrouponId(Integer grouponId) {
            this.grouponId = grouponId;
        }

        public Integer getRulesId() {
            return rulesId;
        }

        public void setRulesId(Integer rulesId) {
            this.rulesId = rulesId;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getCreatorUserId() {
            return creatorUserId;
        }

        public void setCreatorUserId(Integer creatorUserId) {
            this.creatorUserId = creatorUserId;
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

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl == null ? null : shareUrl.trim();
        }

        public Boolean getPayed() {
            return payed;
        }

        public void setPayed(Boolean payed) {
            this.payed = payed;
        }

        public Boolean getDeleted() {
            return deleted;
        }

        public void setDeleted(Boolean deleted) {
            this.deleted = deleted;
        }
    }
