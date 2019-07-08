package com.cskaoyan.mall.admin.shiro;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;


public class MallShiroSessionManager extends DefaultWebSessionManager {

	public static final String LOGIN_TOKEN_KEY = "X-Litemall-Admin-Token";
	private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";

	public MallShiroSessionManager() {
		super();
	}

	@Override
	protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		String id = servletRequest.getHeader(LOGIN_TOKEN_KEY);

		if (!StringUtils.isEmpty(id)){
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,REFERENCED_SESSION_ID_SOURCE);
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID,id);
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID,Boolean.TRUE);
			return id;
		}

		//如果没有携带id参数则按照父类的方式在cookie进行获取
		Serializable sessionId = super.getSessionId(request, response);
		return sessionId;

	}


}
