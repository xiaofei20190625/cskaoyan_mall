package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Dashboard;
import com.cskaoyan.mall.service.DashboardService;
import com.cskaoyan.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController { //首页控制
    @Autowired
    DashboardService dashboardService;
    @RequestMapping("dashboard")
   public ResponseVO<Dashboard> dashboard(){
        ResponseVO<Dashboard> dashboardResponseVO = dashboardService.dashboardHome();
        return dashboardResponseVO;
   }


}
