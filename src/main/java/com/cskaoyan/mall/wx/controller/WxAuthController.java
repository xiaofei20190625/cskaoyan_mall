package com.cskaoyan.mall.wx.controller;


import com.cskaoyan.mall.admin.bean.UserVip;
import com.cskaoyan.mall.admin.service.UserVipService;
import com.cskaoyan.mall.wx.userwx.UserInfo;
import com.cskaoyan.mall.wx.userwx.UserToken;
import com.cskaoyan.mall.wx.userwx.UserTokenManager;
import com.cskaoyan.mall.wx.utils.JSONUtils;
import com.cskaoyan.mall.wx.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by little Stone
 * Date 2019/7/8 Time 20:55
 */
@RestController
@RequestMapping("/wx")
public class WxAuthController {
	@Autowired
	UserVipService userVipService;

	@RequestMapping("/auth/login")
	@ResponseBody
	public Object login(@RequestBody Object body, HttpServletRequest request) {
		HashMap hashMap = JSONUtils.toHashMap(body);
		String username = (String) hashMap.get("username");
		String password = (String) hashMap.get("password");

		UserVip userVip = userVipService.findUserVip(username);
		String password1 = userVip.getPassword();
		//*******************************
		//根据username和password查询user信息
		//*******************************
		/*if (password!=password1){
			return BaseRespVo.fail();
		}*/

		if(password.equals(password1)){
			// userInfo
			UserInfo userInfo = new UserInfo();
			userInfo.setNickName(username);
			userInfo.setAvatarUrl(userVip.getAvatar());


			//********************************
			//根据获得userid
			Integer userId = userVip.getId();
			//int userId = 1;
			//********************************
			// token
			UserToken userToken = UserTokenManager.generateToken(userId);

			Map<Object, Object> result = new HashMap<Object, Object>();
			result.put("token", userToken.getToken());
			result.put("tokenExpire", userToken.getExpireTime().toString());
			result.put("userInfo", userInfo);
			return BaseRespVo.ok(result);
		}

		return BaseRespVo.fail();

	}

	@GetMapping("user/index")
	public Object list(HttpServletRequest request) {
		//前端写了一个token放在请求头中
		//*************************
		//获得请求头
		String tokenKey = request.getHeader("X-Litemall-Token");
		Integer userId = UserTokenManager.getUserId(tokenKey);
		//通过请求头获得userId，进而可以获得一切关于user的信息
		//**************************
		if (userId == null) {
			return BaseRespVo.fail();
		}

		Map<Object, Object> data = new HashMap<Object, Object>();
		//***********************************
		//根据userId查询订单信息
		data.put("order", null);
		//***********************************

		return BaseRespVo.ok(data);
	}
}
