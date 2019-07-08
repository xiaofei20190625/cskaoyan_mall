package com.cskaoyan.mall.admin.bean;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/4 Time 16:29
 */
public class Region {
    Integer id;
    String name;
    Integer type;
    Integer code;

    public Region() {
    }

    public Region(Integer id, String name, Integer type, Integer code) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.code = code;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
