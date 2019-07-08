package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.ExpressConfig;
import com.cskaoyan.mall.admin.bean.MallConfig;
import com.cskaoyan.mall.admin.bean.OrderConfig;
import com.cskaoyan.mall.admin.bean.WxConfig;
import com.cskaoyan.mall.admin.mapper.ConfigMapper;
import com.cskaoyan.mall.admin.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    ConfigMapper configMapper;
    @Override
    public int configMall(MallConfig mallConfig) {
        return configMapper.configMall(mallConfig);
    }

    @Override
    public int configExpress(ExpressConfig config) {
        return configMapper.configExpress(config);
    }

    @Override
    public int configOrder(OrderConfig config) {
        return configMapper.configOrder(config);
    }

    @Override
    public int configWx(WxConfig config) {
        return configMapper.configWx(config);
    }
}
