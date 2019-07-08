package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.Dashboard;
import com.cskaoyan.mall.admin.service.DashboardService;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class HomeController { //首页控制
    @Autowired
    DashboardService dashboardService;
    @RequestMapping("dashboard")
   public ResponseVO<Dashboard> dashboard(){
        ResponseVO<Dashboard> dashboardResponseVO = dashboardService.dashboardHome();
        return dashboardResponseVO;
   }


}
