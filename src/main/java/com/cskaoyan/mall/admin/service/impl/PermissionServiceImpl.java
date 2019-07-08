package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Permission;
import com.cskaoyan.mall.admin.mapper.PermissionMapper;
import com.cskaoyan.mall.admin.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> queryPermission(int roleId) {
        return permissionMapper.queryPermission(roleId);
    }
}
