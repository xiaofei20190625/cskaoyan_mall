package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.ExpressConfig;
import com.cskaoyan.mall.admin.bean.MallConfig;
import com.cskaoyan.mall.admin.bean.OrderConfig;
import com.cskaoyan.mall.admin.bean.WxConfig;
import com.cskaoyan.mall.admin.service.ConfigService;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class ConfigController { //配置管理
    @Autowired
    ConfigService configService;

    @RequestMapping("config/mall")
    public ResponseVO<MallConfig> configMall(@RequestBody MallConfig config){
        int insert = configService.configMall(config);
        ResponseVO responseVO =new ResponseVO<>();
        responseVO.setData(config);
        ResponseVO response = response(insert, responseVO);
        return response;

    }



    private ResponseVO response(int insert,ResponseVO responseVO) {
        if (insert==1){
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
            return responseVO;
        }
        if (insert==-1){
            responseVO.setErrmsg("失败");
            responseVO.setErrno(-1);
            return responseVO;
        }
        return responseVO;
    }

    @RequestMapping("config/express")
    public ResponseVO<ExpressConfig> configExpress(@RequestBody ExpressConfig expressConfig){
        int insert = configService.configExpress(expressConfig);
        ResponseVO responseVO =new ResponseVO<>();
        responseVO.setData(expressConfig);
        ResponseVO response = response(insert, responseVO);
        return response;
    }

    @RequestMapping("config/order")
    public ResponseVO<OrderConfig> configOrder(@RequestBody OrderConfig orderConfig){
        int insert = configService.configOrder(orderConfig);
        ResponseVO responseVO =new ResponseVO<>();
        responseVO.setData(orderConfig);
        ResponseVO response = response(insert, responseVO);
        return response;
    }

    @RequestMapping("config/wx")
    public ResponseVO<WxConfig> configWx(@RequestBody WxConfig wxConfig){
        int insert = configService.configWx(wxConfig);
        ResponseVO responseVO =new ResponseVO<>();
        responseVO.setData(wxConfig);
        ResponseVO response = response(insert, responseVO);
        return response;
    }



}
