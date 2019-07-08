package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.ExpressConfig;
import com.cskaoyan.mall.admin.bean.MallConfig;
import com.cskaoyan.mall.admin.bean.OrderConfig;
import com.cskaoyan.mall.admin.bean.WxConfig;

public interface ConfigService {
    int configMall(MallConfig mallConfig);

    int configExpress(ExpressConfig config);

    int configOrder(OrderConfig orderConfig);

    int configWx(WxConfig wxConfig);
}
