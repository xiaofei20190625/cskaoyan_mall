package com.cskaoyan.mall.wx.bean;



/**
 * Created by IceFloe_Rot
 * Date 2019/7/9 Time 10:39
 */
public class Channel {
    private String iconUrl;
    private Integer id;
    private String name;

    public Channel() {
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
