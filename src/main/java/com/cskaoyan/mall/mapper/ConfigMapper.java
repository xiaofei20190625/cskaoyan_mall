package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.ExpressConfig;
import com.cskaoyan.mall.bean.MallConfig;
import com.cskaoyan.mall.bean.OrderConfig;
import com.cskaoyan.mall.bean.WxConfig;

public interface ConfigMapper {
    int configMall(MallConfig mallConfig);

    int configExpress(ExpressConfig config);

    int configOrder(OrderConfig config);

    int configWx(WxConfig config);

}
