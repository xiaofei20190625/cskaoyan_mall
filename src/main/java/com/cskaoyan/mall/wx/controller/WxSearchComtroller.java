package com.cskaoyan.mall.wx.controller;


import com.cskaoyan.mall.admin.bean.SearchHistory;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.cskaoyan.mall.wx.bean.Search;
import com.cskaoyan.mall.wx.bean.SearchHotHistory;
import com.cskaoyan.mall.wx.service.SearchService;
import com.cskaoyan.mall.wx.userwx.UserTokenManager;
import com.cskaoyan.mall.wx.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("wx")
public class WxSearchComtroller {
    @Autowired
    SearchService searchService;
    @RequestMapping("search/index")
    public BaseRespVo historyList(HttpServletRequest request) {

        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);

        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************

        Search search = searchService.findSearchHistory(userId);
        return BaseRespVo.ok(search);
    }
    @RequestMapping("search/helper")
    public BaseRespVo historyList(HttpServletRequest request,String keyword) {

        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);

        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************

        List help = searchService.findSearchhelp(keyword);
        return BaseRespVo.ok(help);
    }

}
