package com.cskaoyan.mall.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
@ConfigurationProperties(prefix = "admin.login.info")
@Component
public class User {

    String name;
    List perms;
    List roles;
    String avatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getPerms() {
        return perms;
    }

    public void setPerms(List perms) {
        this.perms = perms;
    }

    public List getRoles() {
        return roles;
    }

    public void setRoles(List roles) {
        this.roles = roles;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}