package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Role;
import com.cskaoyan.mall.mapper.RoleMapper;
import com.cskaoyan.mall.service.RoleSeervice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleSeerviceImpl implements RoleSeervice {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public List<Role> queryOption() {
        List<Role> roles = roleMapper.queryOption();
        return roles;
    }
}
