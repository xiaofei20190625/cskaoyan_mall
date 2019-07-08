package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Dashboard;
import com.cskaoyan.mall.admin.vo.ResponseVO;

public interface DashboardService {
    ResponseVO<Dashboard> dashboardHome();

}
