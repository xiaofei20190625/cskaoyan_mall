package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.GoodsS;
import com.cskaoyan.mall.bean.OrderS;
import com.cskaoyan.mall.bean.UserS;


import java.util.List;

public interface StatisticalMapper {

    List<UserS> queryUserS();

    List<OrderS> queryOrderS();

    List<GoodsS> queryGoodsS();
}
