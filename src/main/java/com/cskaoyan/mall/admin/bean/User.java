package com.cskaoyan.mall.admin.bean;

import org.springframework.stereotype.Component;

import java.util.Set;
@Component
public class User {

    String name;
    Set perms;
    Set roles;
    String avatar;

    public User() {
    }

    public User(String name, Set perms, Set roles, String avatar) {
        this.name = name;
        this.perms = perms;
        this.roles = roles;
        this.avatar = avatar;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getPerms() {
        return perms;
    }

    public void setPerms(Set perms) {
        this.perms = perms;
    }

    public Set getRoles() {
        return roles;
    }

    public void setRoles(Set roles) {
        this.roles = roles;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}