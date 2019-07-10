package com.cskaoyan.mall.wx.vo;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/10 Time 14:57
 */
public class ErrVo {
    private String errmsg;
    private Integer errno;

    public ErrVo() {
    }

    public ErrVo(String errmsg, Integer errno) {
        this.errmsg = errmsg;
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }
}
