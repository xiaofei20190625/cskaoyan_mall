package com.cskaoyan.mall.admin.bean;

import com.cskaoyan.mall.admin.vo.SysPermissionVO;

import java.util.List;

public class Permissions {
    List assignedPermissions;
    List<SysPermissionVO<SysPermissionVO<PermissionApi>>> systemPermissions;

    public List getAssignedPermissions() {
        return assignedPermissions;
    }

    public void setAssignedPermissions(List assignedPermissions) {
        this.assignedPermissions = assignedPermissions;
    }

    public List<SysPermissionVO<SysPermissionVO<PermissionApi>>> getSystemPermissions() {
        return systemPermissions;
    }

    public void setSystemPermissions(List<SysPermissionVO<SysPermissionVO<PermissionApi>>> systemPermissions) {
        this.systemPermissions = systemPermissions;
    }
}
