package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.ExpressConfig;
import com.cskaoyan.mall.bean.MallConfig;
import com.cskaoyan.mall.bean.OrderConfig;
import com.cskaoyan.mall.bean.WxConfig;

public interface ConfigService {
    int configMall(MallConfig mallConfig);

    int configExpress(ExpressConfig config);

    int configOrder(OrderConfig orderConfig);

    int configWx(WxConfig wxConfig);
}
