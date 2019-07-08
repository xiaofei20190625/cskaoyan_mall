package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Dashboard;
import com.cskaoyan.mall.admin.mapper.DashboardMapper;
import com.cskaoyan.mall.admin.service.DashboardService;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    DashboardMapper dashboardMapper;
    @Override
    public ResponseVO<Dashboard> dashboardHome() {
        Dashboard dashboard = dashboardMapper.dashboardHome();
        ResponseVO<Dashboard> dashboardResponseVO = new ResponseVO<>();
        if (dashboard!=null){
            dashboardResponseVO.setData(dashboard);
            dashboardResponseVO.setErrmsg("成功");
            dashboardResponseVO.setErrno(0);
            return dashboardResponseVO;
        }else {
            dashboardResponseVO.setData(null);
            dashboardResponseVO.setErrmsg("失败");
            dashboardResponseVO.setErrno(-1);
            return dashboardResponseVO;
        }
    }
}
