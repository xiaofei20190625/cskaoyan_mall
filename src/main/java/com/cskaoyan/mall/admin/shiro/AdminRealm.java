package com.cskaoyan.mall.admin.shiro;

import com.cskaoyan.mall.admin.bean.Admin;
import com.cskaoyan.mall.admin.bean.Permission;
import com.cskaoyan.mall.admin.bean.Role;
import com.cskaoyan.mall.admin.bean.User;
import com.cskaoyan.mall.admin.service.AdminService;
import com.cskaoyan.mall.admin.service.PermissionService;
import com.cskaoyan.mall.admin.service.RoleService;
import com.cskaoyan.mall.admin.vo.LoginVO;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component("realm")
public class AdminRealm extends AuthorizingRealm {

	@Autowired
	AdminService adminService;
	@Autowired
	RoleService roleService;
	@Autowired
	PermissionService permissionService;
	@Autowired
	User user;

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		//关注凭证（密码）
		//执行验证的用户名
		String principal = (String) authenticationToken.getPrincipal();
		//根据用户名 去查询数据库中的密码
		Admin admin = adminService.queryPasswordFromDb(principal);

		String passwordFromDb  = admin.getPassword();

		//参数1：principle是要给到授权使用的
		//参数2：通常写来源于数据库的密码 如果和subject。login中token的密码匹配 才能通过认证
		//参数3：当前的域名（基本没用）

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(admin, passwordFromDb, this.getName());
		return info;

	}

	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//来源于SimpleAuthenticationInfo的第一个参数，可以是String类型，也可以是Javabean
		Admin admin = (Admin) principalCollection.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//从数据库中取出 当前用户的授权信息（可以查询role，也可以查询permission）
		Set<String> roleSet = new HashSet<>();
		Set<String> permissionSet = new HashSet<>();

		int[] roleIds = admin.getRoleIds();
		for (int roleId : roleIds) {
			Role role = roleService.queryRole(roleId);
			String name = role.getName();
			roleSet.add(name);
			List<Permission> permissions = permissionService.queryPermission(roleId);
			for (Permission permission : permissions) {
				String permissionName = permission.getPermission();
				permissionSet.add(permissionName);
			}
		}
		info.addRoles(roleSet);
		info.addStringPermissions(permissionSet);
		return info;
	}

}
