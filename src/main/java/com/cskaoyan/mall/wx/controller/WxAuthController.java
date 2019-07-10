package com.cskaoyan.mall.wx.controller;


import com.cskaoyan.mall.admin.bean.UserVip;
import com.cskaoyan.mall.admin.service.UserVipService;
import com.cskaoyan.mall.wx.bean.RegisterUser;
import com.cskaoyan.mall.wx.userwx.UserInfo;
import com.cskaoyan.mall.wx.userwx.UserToken;
import com.cskaoyan.mall.wx.userwx.UserTokenManager;
import com.cskaoyan.mall.wx.utils.JSONUtils;
import com.cskaoyan.mall.wx.vo.BaseRespVO;
import com.cskaoyan.mall.wx.vo.ErrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
			return BaseRespVO.fail();
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
			return BaseRespVO.ok(result);
		}

		return BaseRespVO.fail();

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
			return BaseRespVO.fail();
		}

		Map<Object, Object> data = new HashMap<Object, Object>();
		//***********************************
		//根据userId查询订单信息
		data.put("order", null);
		//***********************************

		return BaseRespVO.ok(data);
	}

	@RequestMapping("/auth/logout")
	@ResponseBody
	public HashMap<String,String> logout(){
		HashMap<String, String> hashMap = new HashMap<>();
		return hashMap;
	}

	@RequestMapping("/auth/register")
	@ResponseBody
	public ErrVo register(@Valid @RequestBody UserVip user, BindingResult bindingResult){
		//数据校验
		if (bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			String field = fieldError.getField();
			String errorMessage = fieldError.getDefaultMessage();
			ErrVo errVo = new ErrVo(errorMessage, 703);
			return errVo;
		}
		//检查用户名是否重复
		UserVip userIfExist = userVipService.findUserVip(user.getUsername());
		if (userIfExist != null){
			ErrVo errVo = new ErrVo("用户名已经被注册，请登录", 703);
			return errVo;
		}
		//注册
		int i = userVipService.registerUser(user);
		if (i == 1) {
			ErrVo errVo = new ErrVo("成功", 0);

			return errVo;
		}
		ErrVo errVo = new ErrVo("注册失败，请重试", 500);
		return errVo;
	}
}
