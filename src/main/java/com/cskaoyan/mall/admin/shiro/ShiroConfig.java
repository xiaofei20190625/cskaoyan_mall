package com.cskaoyan.mall.admin.shiro;

import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class ShiroConfig {

	/*@Bean
	public CustomRealm customRealm(){
		return new CustomRealm();
	}*/
	@Bean
	public DefaultWebSecurityManager securityManager(AdminRealm adminRealm,MallShiroSessionManager mallShiroSessionManager){
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		defaultWebSecurityManager.setRealm(adminRealm);
		defaultWebSecurityManager.setSessionManager(mallShiroSessionManager);
		return defaultWebSecurityManager;
	}
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

		shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);



		shiroFilterFactoryBean.setLoginUrl("/admin/auth/login");

		HashMap<String, String> filterMap = new HashMap<>();

		filterMap.put("/admin/auth/login","anon");
		filterMap.put("/admin/auth/logout","logout");
		filterMap.put("/admin/**","authc");
		filterMap.put("/wx/auth/login","anon");

		filterMap.put("/wx/**","anon");

		//filterMap.put("/user/query","perms[user:query]");
		//filterMap.put("/user/query2","perms[user:query2]");


		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

		return shiroFilterFactoryBean;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager defaultWebSecurityManager)
	{
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(defaultWebSecurityManager);
		return authorizationAttributeSourceAdvisor;
	}

	@Bean
	public MallShiroSessionManager mallShiroSessionManager(){
		MallShiroSessionManager mallShiroSessionManager = new MallShiroSessionManager();
		return mallShiroSessionManager;
	}

	@Bean
	public AdminRealm adminRealm(){
		AdminRealm adminRealm = new AdminRealm();
		return adminRealm;
	}



}
