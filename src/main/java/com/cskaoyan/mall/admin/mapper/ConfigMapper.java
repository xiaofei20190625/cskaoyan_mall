package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.ExpressConfig;
import com.cskaoyan.mall.admin.bean.MallConfig;
import com.cskaoyan.mall.admin.bean.OrderConfig;
import com.cskaoyan.mall.admin.bean.WxConfig;

public interface ConfigMapper {
    int configMall(MallConfig mallConfig);

    int configExpress(ExpressConfig config);

    int configOrder(OrderConfig config);

    int configWx(WxConfig config);

}
