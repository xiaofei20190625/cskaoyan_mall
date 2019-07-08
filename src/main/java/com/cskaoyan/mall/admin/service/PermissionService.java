package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> queryPermission(int roleId);
}
